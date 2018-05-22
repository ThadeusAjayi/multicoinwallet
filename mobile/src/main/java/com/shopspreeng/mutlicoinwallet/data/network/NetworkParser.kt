package com.shopspreeng.mutlicoinwallet.data.network

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.shopspreeng.mutlicoinwallet.data.database.Currency
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

/**
 * Created by Thadeus-APMIS on 3/26/2018.
 */

class NetworkParser {

    fun fromJson (jsonArray: JSONArray): List<Currency>? {

        val currencies: MutableList<Currency> = arrayListOf()
        Log.v("array length", jsonArray.length().toString())

        for (i in 0..(jsonArray.length() - 1)) {
            val quickCurrency = jsonArray.get(i)
            val ccccc = Gson().fromJson(quickCurrency.toString(), Currency::class.java)
            currencies.add(ccccc)
        }

        return currencies
    }

}