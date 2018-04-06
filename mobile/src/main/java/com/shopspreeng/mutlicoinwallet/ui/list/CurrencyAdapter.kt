package com.shopspreeng.mutlicoinwallet.ui.list

import android.arch.lifecycle.LiveData
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shopspreeng.mutlicoinwallet.R
import com.shopspreeng.mutlicoinwallet.data.database.Currency

/**
 * Created by Thadeus-APMIS on 4/6/2018.
 */
class CurrencyAdapter(val currencies: LiveData<List<Currency>>) : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.currency_list_item, parent, false) as View
        return CurrencyViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class CurrencyViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    }
}