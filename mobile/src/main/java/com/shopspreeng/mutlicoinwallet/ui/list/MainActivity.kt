package com.shopspreeng.mutlicoinwallet.ui.list

import android.arch.lifecycle.LifecycleActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.shopspreeng.mutlicoinwallet.R
import com.shopspreeng.mutlicoinwallet.data.network.CurrencySyncIntentService

class MainActivity : LifecycleActivity(), View.OnClickListener {

    override fun onClick(p0: View?) {
        Toast.makeText(this, "Yea I got it", LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startService(Intent(applicationContext, CurrencySyncIntentService::class.java))

    }
}
