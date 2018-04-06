package com.shopspreeng.mutlicoinwallet.ui.list

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.shopspreeng.mutlicoinwallet.MultiCoinWallet
import com.shopspreeng.mutlicoinwallet.R
import com.shopspreeng.mutlicoinwallet.data.database.Currency
import com.shopspreeng.mutlicoinwallet.data.network.CurrencyNetworkDataSource
import com.shopspreeng.mutlicoinwallet.data.network.CurrencySyncIntentService
import com.shopspreeng.mutlicoinwallet.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executor

class MainActivity : LifecycleActivity(), View.OnClickListener {

    var mViewModel : MainViewModel? = null

    override fun onClick(p0: View?) {
        Toast.makeText(this, "Yea I got it", LENGTH_SHORT).show()
        val mainActivityFactory = InjectorUtils().provideMainActivityFactory(applicationContext)
        mViewModel = ViewModelProviders.of(this, mainActivityFactory).get(MainViewModel::class.java)

        mViewModel?.getCurrencyUpdates()?.observe(this, Observer {
            Observer<List<Currency>> { currencies ->
                Log.v("Currencies", currencies.toString())
            }
        })

        /*CurrencyNetworkDataSource(applicationContext, MultiCoinWallet(Executor {  }, Executor {  }, Executor {  }))
                .getCurrencies()?.observe(this,
                        Observer<Array<Currency>>{currencies ->
                            run {
                                Log.v("Currencies observed", currencies.toString())
                            }
                        })*/

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testTv.setOnClickListener(this)

        startService(Intent(applicationContext, CurrencySyncIntentService::class.java))

    }
}
