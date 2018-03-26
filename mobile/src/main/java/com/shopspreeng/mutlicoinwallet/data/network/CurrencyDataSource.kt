package com.shopspreeng.mutlicoinwallet.data.network

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.shopspreeng.mutlicoinwallet.MultiCoinWallet
import com.shopspreeng.mutlicoinwallet.data.database.Currency
import java.util.concurrent.TimeUnit

/**
 * Created by Thadeus-APMIS on 3/26/2018.
 */

class CurrencyDataSource(context: Context, multiCoinExecutors: MultiCoinWallet) {
    // The number of days we want our API to return, set to 14 days or two weeks
    val NUM_DAYS = 14
    private val LOG_TAG = CurrencyDataSource::class.java!!.getSimpleName()

    // Interval at which to sync with the weather. Use TimeUnit for convenience, rather than
    // writing out a bunch of multiplication ourselves and risk making a silly mistake.
    private val SYNC_INTERVAL_HOURS = 3
    private val SYNC_INTERVAL_SECONDS = TimeUnit.HOURS.toSeconds(SYNC_INTERVAL_HOURS.toLong()).toInt()
    private val SYNC_FLEXTIME_SECONDS = SYNC_INTERVAL_SECONDS / 3
    private val SUNSHINE_SYNC_TAG = "sunshine-sync"

    // For Singleton instantiation
    private val LOCK = Any()
    private var sInstance: CurrencyDataSource? = null
    private val mContext = context

    private val mExecutors = multiCoinExecutors

    private val mDownloadedCoinCurrency: LiveData<Currency>? = null

    fun getCurrencyRates(): LiveData<Currency>? {
        return mDownloadedCoinCurrency
    }

    fun getInstance(): CurrencyDataSource? {
        Log.d(LOG_TAG, "Getting the network data source")
        if (sInstance == null) {
            synchronized(LOCK) {
                sInstance = CurrencyDataSource(mContext, mExecutors)
                Log.d(LOG_TAG, "Made new network data source")
            }
        }
        return sInstance
    }

    fun fetchCurrencies() {
        Log.v(LOG_TAG, "Fetch Weather Started")
        mExecutors.networkIO()?.execute({
            val currencyResponse = NetworkUtils(mContext).getCurrencies()

            Log.v("Currency Response", currencyResponse.toString())
        })
    }

}