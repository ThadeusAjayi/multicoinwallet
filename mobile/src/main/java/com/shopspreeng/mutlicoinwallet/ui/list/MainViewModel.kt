package com.shopspreeng.mutlicoinwallet.ui.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.shopspreeng.mutlicoinwallet.data.CurrencyRepository
import com.shopspreeng.mutlicoinwallet.data.database.Currency

/**
 * Created by Thadeus-APMIS on 3/25/2018.
 */
class MainViewModel(currencyRepository: CurrencyRepository): ViewModel() {

    val mCurrency = currencyRepository.getCurrencyUpdates()

    fun getCurrencyUpdates(): LiveData<List<Currency>> {
        return mCurrency
    }

}