package com.shopspreeng.mutlicoinwallet.ui.list

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.shopspreeng.mutlicoinwallet.data.CurrencyRepository

/**
 * Created by Thadeus-APMIS on 3/25/2018.
 */
class MainViewModelFactory (currencyRepository: CurrencyRepository): ViewModelProvider.NewInstanceFactory() {

    val mCurrencyRepository = currencyRepository

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(mCurrencyRepository) as T
    }
}