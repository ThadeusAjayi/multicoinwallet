package com.shopspreeng.mutlicoinwallet.data.network

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

    fun fromJson (jsonArray: JSONArray): List<Currency> {

        var currencyList: MutableList<Currency> = mutableListOf()

        for (i in 0..(jsonArray.length() - 1)) {
            var quickCurrency = jsonArray.get(i)
            var ccccc: Currency = Gson().fromJson(quickCurrency.toString(), Currency::class.java)
            currencyList.add(ccccc)
        }

        return currencyList
    }

}