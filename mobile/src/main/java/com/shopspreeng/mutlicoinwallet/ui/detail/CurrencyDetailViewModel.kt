package com.shopspreeng.mutlicoinwallet.ui.detail

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.shopspreeng.mutlicoinwallet.data.database.Currency

/**
 * Created by Thadeus-APMIS on 3/24/2018.
 */
class CurrencyDetailViewModel : ViewModel() {

    val mCurrency= MutableLiveData<Currency>()

    fun getCurrency () : MutableLiveData<Currency> {
        return mCurrency
    }

    fun setCurrency (currency: Currency) {
        mCurrency.postValue(currency)
    }


}
