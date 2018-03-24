package com.shopspreeng.mutlicoinwallet

import android.app.Application
import android.content.ContentValues.TAG
import android.text.TextUtils
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

/**
 * Created by Thadeus-APMIS on 3/23/2018.
 */
class MultiCoinWallet : Application() {

    private var mInstance: MultiCoinWallet? = null

    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }

    @Synchronized
    fun getInstance(): MultiCoinWallet? {
        return mInstance
    }

    val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(applicationContext)
    }

    fun <T> addToRequestQueue(request: Request<T>, tag: String) {
        request.tag = if (TextUtils.isEmpty(tag)) TAG else tag
        requestQueue?.add(request)
    }

    fun <T> addToRequestQueue(request: Request<T>) {
        request.tag = TAG
        requestQueue?.add(request)
    }

    fun cancelPendingRequests(tag: Any) {
        if (requestQueue != null) {
            requestQueue!!.cancelAll(tag)
        }
    }

}