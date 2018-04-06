package com.shopspreeng.mutlicoinwallet.utilities

import android.content.Context
import com.shopspreeng.mutlicoinwallet.MultiCoinWallet
import com.shopspreeng.mutlicoinwallet.data.database.CurrencyDatabase
import com.shopspreeng.mutlicoinwallet.data.network.CurrencyNetworkDataSource
import com.shopspreeng.mutlicoinwallet.data.CurrencyRepository
import com.shopspreeng.mutlicoinwallet.ui.list.MainViewModelFactory
import java.util.concurrent.Executor

/**
 * Created by Thadeus-APMIS on 3/26/2018.
 */
class InjectorUtils {

    fun provideRepository(context: Context): CurrencyRepository {
        val currencyDatabase = CurrencyDatabase.getInstance(context.applicationContext)
        val multiCoinWallet = MultiCoinWallet(Executor {  }, Executor {  }, Executor {  }).getInstance()!!
        val currencyDataSource = CurrencyNetworkDataSource(context, multiCoinWallet)
        return CurrencyRepository(currencyDatabase!!.CurrencyDao(), currencyDataSource, multiCoinWallet)
    }

    fun provideNetworkData(context: Context): CurrencyNetworkDataSource? {
        val multiCoinWallet: MultiCoinWallet? = MultiCoinWallet(Executor { }, Executor { }, Executor { }).getInstance()
        return CurrencyNetworkDataSource(context, multiCoinWallet!!)
    }

    fun provideMainActivityFactory(context: Context): MainViewModelFactory {
        return MainViewModelFactory(provideRepository(context))
    }


}