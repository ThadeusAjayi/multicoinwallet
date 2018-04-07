package com.shopspreeng.mutlicoinwallet.data

import android.arch.lifecycle.LiveData
import android.util.Log
import com.shopspreeng.mutlicoinwallet.MultiCoinWallet
import com.shopspreeng.mutlicoinwallet.data.database.Currency
import com.shopspreeng.mutlicoinwallet.data.database.CurrencyDao
import com.shopspreeng.mutlicoinwallet.data.network.CurrencyNetworkDataSource

/**
 * Created by Thadeus-APMIS on 3/26/2018.
 */
class CurrencyRepository(currencyDao: CurrencyDao, currencyNetworkDataSource: CurrencyNetworkDataSource, multiCoinWallet: MultiCoinWallet) {

    private val LOG_TAG = CurrencyRepository::class.java.simpleName

    private val LOCK = Any()
    private var sInstance: CurrencyRepository? = null
    private var mCurrencyDao = currencyDao
    private var mCurrencyNetworkDataSource = currencyNetworkDataSource
    private var mExecutors = multiCoinWallet
    private var mInitialized = false

    init {
        val networkData: LiveData<List<Currency>>? = mCurrencyNetworkDataSource.getCurrencies()
        networkData?.observeForever({currencies ->
            mExecutors.diskIO()?.execute({
                mCurrencyDao.bulkInsert(currencies)
                Log.d(LOG_TAG, "New values inserted")
            })
        })
    }

    @Synchronized
    fun getInstance(): CurrencyRepository ?{
        Log.d(LOG_TAG, "Getting the repository")
        if (sInstance == null) {
            synchronized(LOCK) {
                sInstance = CurrencyRepository(mCurrencyDao, mCurrencyNetworkDataSource,
                        mExecutors)
                Log.d(LOG_TAG, "Made new repository")
            }
        }
        return sInstance
    }

    @Synchronized
    fun initializeData() {
        // Only perform initialization once per app lifetime. If initialization has already been
        // performed, we have nothing to do in this method.
        if (mInitialized) return
        mInitialized = true

        mExecutors.diskIO()?.execute {
            mCurrencyNetworkDataSource.startFetchCurrencyService()
        }
    }

    fun getCurrencyUpdates(): LiveData<List<Currency>> {
        initializeData()
        return mCurrencyDao.getAllCurrencies()
    }


}