package com.shopspreeng.mutlicoinwallet.data.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Thadeus-APMIS on 3/23/2018.
 */

/**
 * Single currency entry
 */
@Entity(tableName = "currency")
data class Currency(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "_id")var _id: Long?,
                    @ColumnInfo(name = "currencyId")val id: String?,
                    @ColumnInfo(name = "name")val name: String?,
                    @ColumnInfo(name = "symbol")val symbol: String?,
                    @ColumnInfo(name = "rank")val rank: String?,
                    @ColumnInfo(name = "price_usd")val price_usd: String?,
                    @ColumnInfo(name = "price_btc")val price_btc: String?,
                    @ColumnInfo(name = "volume24h")val volume24h: String?,
                    @ColumnInfo(name = "market_cap_usd")val market_cap_usd: String?,
                    @ColumnInfo(name = "available_supply")val available_supply: String?,
                    @ColumnInfo(name = "total_supply")val total_supply: String?,
                    @ColumnInfo(name = "percent_change_1h")val percent_change_1h: String?,
                    @ColumnInfo(name = "percent_change_24h")val percent_change_24h: String?,
                    @ColumnInfo(name = "percent_change_7d")val percent_change_7d: String?,
                    @ColumnInfo(name = "last_updated")val last_updated: String?)