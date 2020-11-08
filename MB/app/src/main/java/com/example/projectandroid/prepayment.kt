package com.example.projectandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_prepayment.*
import kotlinx.android.synthetic.main.activity_prepayment.button_prepayment
import kotlinx.android.synthetic.main.activity_prepayment2.*

class prepayment : AppCompatActivity() {
    var idusername =""
    var username = ""
    var password = ""
    var address = ""
    var tel = ""
    var email = ""
    var price = ""
    var date =""
    var datecheck = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prepayment)

        idusername = intent.getStringExtra("1").toString()
        username = intent.getStringExtra("2").toString()
        password = intent.getStringExtra("3").toString()
        address = intent.getStringExtra("4").toString()
        tel = intent.getStringExtra("5").toString()
        email = intent.getStringExtra("6").toString()
        price = textView_bed20.text.toString()


        btn_date.setOnClickListener() {
            val newDateFragment = DatePickerFragment()
            newDateFragment.show(supportFragmentManager, "Date Picker")

        }

        btn_date2.setOnClickListener() {
            val newDateFragment = DatePickerFragment2()
            newDateFragment.show(supportFragmentManager, "Date Picker")
        }

        button_prepayment.setOnClickListener() {
            if (datafragment.text.isEmpty() and datafragment2.text.isEmpty()) {
                Toast.makeText(this, "กรุณาใส่วันเช็คอินและวันเช็คเอาท์", Toast.LENGTH_LONG).show()
            } else if (datafragment.text.isEmpty()) {
                Toast.makeText(this, "กรุณาใส่วันเช็คอิน", Toast.LENGTH_LONG).show()
            } else if (datafragment2.text.isEmpty()) {
                Toast.makeText(this, "กรุณาใส่วันเช็คเอาท์", Toast.LENGTH_LONG).show()
            } else {

                val intent = Intent(this@prepayment, Qrpayment::class.java)
                intent.putExtra("1", idusername)
                intent.putExtra("2", username)
                intent.putExtra("3", password)
                intent.putExtra("4", address)
                intent.putExtra("5", tel)
                intent.putExtra("6", email)
                intent.putExtra("7", datafragment.text.toString())
                intent.putExtra("8", datafragment2.text.toString())
                intent.putExtra("9", price)
                intent.putExtra("10", "1")
                startActivity(intent)
                finish()
            }
        }

    }
}