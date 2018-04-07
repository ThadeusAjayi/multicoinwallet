package com.shopspreeng.mutlicoinwallet.data.network

import com.shopspreeng.mutlicoinwallet.data.database.Currency

/**
 * Created by Thadeus-APMIS on 3/26/2018.
 */
class CurrencyResponse(currency: List<Currency>?) {

    private val mCurrency : List<Currency>? = currency

    fun getCurrency(): List<Currency>? {
        return mCurrency
    }

}