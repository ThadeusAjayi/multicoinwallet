package com.shopspreeng.mutlicoinwallet.ui.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.shopspreeng.mutlicoinwallet.MultiCoinWallet
import com.shopspreeng.mutlicoinwallet.R
import org.json.JSONObject

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val mInstance = MultiCoinWallet().getInstance()

    override fun onClick(p0: View?) {
        Toast.makeText(this, "Yea I got it", LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var jaRequest = JsonObjectRequest(Request.Method.GET,
                "https://api.coinmarketcap.com/v1/ticker/",null,
                Response.Listener<JSONObject> {
                    response -> Log.v("Response", response.toString())
                },
                Response.ErrorListener {
                    error ->  Log.v("Error", error.message)
                })


        //mInstance.addToRequestQueue(jaRequest, "CAP")


    }
}
