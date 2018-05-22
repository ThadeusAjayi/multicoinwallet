package com.shopspreeng.mutlicoinwallet.data.network

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.Intent
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.shopspreeng.mutlicoinwallet.MultiCoinWallet
import com.shopspreeng.mutlicoinwallet.data.database.Currency
import org.json.JSONArray
import java.util.concurrent.TimeUnit

/**
 * Created by Thadeus-APMIS on 3/26/2018.
 */

class CurrencyNetworkDataSource(context: Context, multiCoinExecutors: MultiCoinWallet) {
    // The number of days we want our API to return, set to 14 days or two weeks
    val NUM_DAYS = 14
    private val LOG_TAG = CurrencyNetworkDataSource::class.java.simpleName

    // Interval at which to sync with the weather. Use TimeUnit for convenience, rather than
    // writing out a bunch of multiplication ourselves and risk making a silly mistake.
    private val SYNC_INTERVAL_HOURS = 3
    private val SYNC_INTERVAL_SECONDS = TimeUnit.HOURS.toSeconds(SYNC_INTERVAL_HOURS.toLong()).toInt()
    private val SYNC_FLEXTIME_SECONDS = SYNC_INTERVAL_SECONDS / 3
    private val SUNSHINE_SYNC_TAG = "sunshine-sync"

    // For Singleton instantiation
    private val LOCK = Any()
    private var sInstance: CurrencyNetworkDataSource? = null

    private val mExecutors = multiCoinExecutors

    private val mDownloadedCoinCurrency: MutableLiveData<List<Currency>>? = MutableLiveData()

    val CURRENCY_RATES = "https://api.coinmarketcap.com/v1/ticker/?limit=10"

    val BASE_URL = CURRENCY_RATES

    var applicationContext = context

    val requestQueue = Volley.newRequestQueue(context)

    fun getCurrencies(): LiveData<List<Currency>>? {
        return mDownloadedCoinCurrency
    }

    fun getInstance(): CurrencyNetworkDataSource? {
        Log.d(LOG_TAG, "Getting the network data source")
        if (sInstance == null) {
            synchronized(LOCK) {
                sInstance = CurrencyNetworkDataSource(applicationContext, mExecutors)
                Log.d(LOG_TAG, "Made new network data source")
            }
        }
        return sInstance
    }

    fun fetchCurrencies() {
        Log.v(LOG_TAG, "Fetch Coin Started")
        mExecutors.networkIO()?.execute({

            var response = CurrencyResponse(NetworkUtils(applicationContext).getCurrencies())

            Log.v("Response After Data", java.lang.String.valueOf(response))

            mDownloadedCoinCurrency?.postValue(response.getCurrency())
        })
    }

    fun startFetchCurrencyService() {
        applicationContext?.startService(Intent(applicationContext, CurrencySyncIntentService::class.java))
    }

}