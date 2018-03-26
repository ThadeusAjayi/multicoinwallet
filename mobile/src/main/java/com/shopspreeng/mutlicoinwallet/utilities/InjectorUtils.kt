package com.shopspreeng.mutlicoinwallet.utilities

import android.content.Context
import com.shopspreeng.mutlicoinwallet.MultiCoinWallet
import com.shopspreeng.mutlicoinwallet.data.network.CurrencyDataSource
import java.util.concurrent.Executor

/**
 * Created by Thadeus-APMIS on 3/26/2018.
 */
class InjectorUtils {

    fun provideNetworkData(context: Context): CurrencyDataSource? {
        val multiCoinWallet: MultiCoinWallet? = MultiCoinWallet(Executor { }, Executor { }, Executor { }).getInstance()
        return CurrencyDataSource(context, multiCoinWallet!!)
    }

}