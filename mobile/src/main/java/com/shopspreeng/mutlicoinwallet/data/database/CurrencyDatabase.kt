package com.shopspreeng.mutlicoinwallet.data.database

import android.arch.persistence.room.*
import android.content.Context


/**
 * Created by Thadeus-APMIS on 3/24/2018.
 */

@Database(entities = arrayOf(Currency::class), version = 1)
@TypeConverters(CurrencyConverter::class)

abstract class CurrencyDatabase: RoomDatabase() {

    abstract fun CurrencyDao(): CurrencyDao

    companion object {
        val DATABASE_NAME = "currency"
        private var INSTANCE: CurrencyDatabase? = null

        fun getInstance(context: Context): CurrencyDatabase? {
            if (INSTANCE == null) {
                synchronized(CurrencyDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            CurrencyDatabase::class.java, DATABASE_NAME)
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }


}