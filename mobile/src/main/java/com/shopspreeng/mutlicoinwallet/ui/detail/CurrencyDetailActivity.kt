package com.shopspreeng.mutlicoinwallet.ui.detail

import android.arch.lifecycle.*
import android.os.Bundle
import com.shopspreeng.mutlicoinwallet.R
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.shopspreeng.mutlicoinwallet.data.database.Currency


class CurrencyDetailActivity : LifecycleActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_detail)

        val mViewModel = ViewModelProviders.of(this).get(CurrencyDetailViewModel::class.java)

        mViewModel.getCurrency().observe(this, Observer {
            toast(CurrencyDetailViewModel().mCurrency)
        })

    }

    fun toast (currency: MutableLiveData<Currency>) {
        Toast.makeText(this, currency.toString(), LENGTH_SHORT).show()
    }

}
