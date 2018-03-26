package com.shopspreeng.mutlicoinwallet.data.network

import android.app.IntentService
import android.content.Intent
import android.util.Log
import com.shopspreeng.mutlicoinwallet.utilities.InjectorUtils

/**
 * Created by Thadeus-APMIS on 3/26/2018.
 */

class CurrencySyncIntentService: IntentService("CurrencySyncIntentService") {

    private val LOG_TAG = CurrencySyncIntentService::class.java!!.simpleName

    override fun onHandleIntent(p0: Intent?) {
        Log.d(LOG_TAG, "Intent service started")
        val currencyDataSource: CurrencyDataSource? = InjectorUtils().provideNetworkData(applicationContext)
                ?.getInstance()
        currencyDataSource?.fetchCurrencies()
    }

}