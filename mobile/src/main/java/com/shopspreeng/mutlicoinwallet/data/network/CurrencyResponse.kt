package com.shopspreeng.mutlicoinwallet.data.network

import android.support.annotation.NonNull
import com.shopspreeng.mutlicoinwallet.data.database.Currency

/**
 * Created by Thadeus-APMIS on 3/26/2018.
 */
class CurrencyResponse(@NonNull currency: String) {

    val mCurrency: String? = null

    fun getCurrency(): String? {
        return mCurrency
    }

}