package com.shopspreeng.mutlicoinwallet.data.database

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

/**
 * Created by Thadeus-APMIS on 3/24/2018.
 */
@Dao
interface CurrencyDao {

    @Query("SELECT * FROM currency")
    fun getAllCurrencies(): List<Currency>

    @Query("SELECT * FROM currency WHERE currency = :currency")
    fun getSingleCurrency(currency: Currency)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(currencies: Currency)

    @Delete
    fun delete(currency: Currency)

}