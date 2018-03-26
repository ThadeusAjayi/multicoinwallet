package com.shopspreeng.mutlicoinwallet.data.network

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.shopspreeng.mutlicoinwallet.data.database.Currency
import org.json.JSONArray
import org.json.JSONObject

/**
 * Created by Thadeus-APMIS on 3/26/2018.
 */

/**
 * Network calls are made here
 */

class NetworkUtils(context: Context) {

    val TAG = NetworkUtils::class.java.simpleName

    val CURRENCY_RATES = "https://api.coinmarketcap.com/v1/ticker/?limit=10"

    val BASE_URL = CURRENCY_RATES

    var applicationContext: Context? = context

    val requestQueue = Volley.newRequestQueue(applicationContext)

    fun getCurrencies() : List<Currency>? {
        var currencyResult: List<Currency>? = listOf()

        val stringRequest = StringRequest(Request.Method.GET, BASE_URL,
                Response.Listener<String> { response ->
                    val jar = JSONArray(response)

                    currencyResult = NetworkParser().fromJson(jar)
                    Log.v("Currency Result", currencyResult.toString())

                },
                Response.ErrorListener { error ->
                    Log.v("Error", error.message)
                })
        requestQueue.add(stringRequest)

        return currencyResult
    }




}