package com.shopspreeng.mutlicoinwallet.data.database

import android.arch.persistence.room.TypeConverter

/**
 * Created by Thadeus-APMIS on 3/24/2018.
 */
class CurrencyConverter {
    @TypeConverter
    fun convertCurrency (): Double? {
        return null
    }
}