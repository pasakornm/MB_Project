package com.example.projectandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_payment_complete.*
import kotlinx.android.synthetic.main.activity_prepayment.*
import kotlinx.android.synthetic.main.activity_prepayment.button_prepayment

class PaymentComplete : AppCompatActivity() {
    var idusername =""
    var username = ""
    var password = ""
    var address = ""
    var tel = ""
    var email = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_complete)
        idusername = intent.getStringExtra("1").toString()
        username = intent.getStringExtra("2").toString()
        password = intent.getStringExtra("3").toString()
        address = intent.getStringExtra("4").toString()
        tel = intent.getStringExtra("5").toString()
        email = intent.getStringExtra("6").toString()

        button_paymentComplete.setOnClickListener(){
            val intent = Intent(this@PaymentComplete, Home::class.java)
            intent.putExtra("1", idusername)
            intent.putExtra("2", username)
            intent.putExtra("3", password)
            intent.putExtra("4", address)
            intent.putExtra("5", tel)
            intent.putExtra("6", email)
            startActivity(intent)
            finish()
        }
    }
}