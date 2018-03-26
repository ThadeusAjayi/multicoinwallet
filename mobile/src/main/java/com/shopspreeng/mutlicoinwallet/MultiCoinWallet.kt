package com.shopspreeng.mutlicoinwallet
import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by Thadeus-APMIS on 3/23/2018.
 */
class MultiCoinWallet  {

    private val LOCK = Any()
    private var sInstance: MultiCoinWallet? = null
    private var diskIO: Executor? = null
    private var mainThread: Executor? = null
    private var networkIO: Executor? = null

    constructor(diskIO: Executor, networkIO: Executor, mainThread: Executor) {
        this.diskIO = diskIO
        this.networkIO = networkIO
        this.mainThread = mainThread
    }

    fun getInstance(): MultiCoinWallet? {
        if (sInstance == null) {
            synchronized(LOCK) {
                sInstance = MultiCoinWallet(Executors.newSingleThreadExecutor(),
                        Executors.newFixedThreadPool(3),
                        MainThreadExecutor())
            }
        }
        return sInstance
    }

    fun diskIO(): Executor? {
        return diskIO
    }

    fun mainThread(): Executor? {
        return mainThread
    }

    fun networkIO(): Executor? {
        return networkIO
    }

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }

}