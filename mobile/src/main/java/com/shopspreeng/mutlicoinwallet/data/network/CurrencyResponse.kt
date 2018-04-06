package com.shopspreeng.mutlicoinwallet.data.network

import com.shopspreeng.mutlicoinwallet.data.database.Currency

/**
 * Created by Thadeus-APMIS on 3/26/2018.
 */
class CurrencyResponse(currency: Array<Currency>?) {

    private val mCurrency : Array<Currency>? = currency

    fun getCurrency(): Array<Currency>? {
        return mCurrency
    }

}