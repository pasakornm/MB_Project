package com.example.projectandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectandroid.R
import kotlinx.android.synthetic.main.activity_mainframe.*


class Mainframe : AppCompatActivity() {
    var username = ""
    var password = ""
    var address = ""
    var tel = ""
    var email = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainframe)
        username = intent.getStringExtra("1").toString()
        password = intent.getStringExtra("2").toString()
        address = intent.getStringExtra("3").toString()
        tel = intent.getStringExtra("4").toString()
        email = intent.getStringExtra("5").toString()


    }

}