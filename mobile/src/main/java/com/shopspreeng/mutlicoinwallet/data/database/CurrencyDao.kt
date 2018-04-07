package com.shopspreeng.mutlicoinwallet.data.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

/**
 * Created by Thadeus-APMIS on 3/24/2018.
 */
@Dao
interface CurrencyDao {

    @Query("SELECT * FROM currency")
    fun getAllCurrencies(): LiveData<List<Currency>>

  /*  @Query("SELECT * FROM currency WHERE currency = :currency")
    fun getSingleCurrency(currency: Currency): LiveData<Currency>*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(currencies: List<Currency>?)

    @Delete
    fun delete(currency: Currency)

}