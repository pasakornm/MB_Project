package com.example.projectandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_my_info.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class my_info : AppCompatActivity() {
    var idusername =""
    var username = ""
    var password = ""
    var address = ""
    var tel = ""
    var email = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_info)
        idusername = intent.getStringExtra("1").toString()
        username = intent.getStringExtra("2").toString()
        password = intent.getStringExtra("3").toString()
        address = intent.getStringExtra("4").toString()
        tel = intent.getStringExtra("5").toString()
        email = intent.getStringExtra("6").toString()

        User_TV.setText(username)
        Pass_TV.setText(password)
        Tel_TV.setText(tel)
        Email_TV.setText(email)
        Add_TV.setText(address)
        imageView8.setOnClickListener(){
            val popup = PopupMenu(this, imageView8)
            popup.inflate(R.menu.bt_navigation)
            popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener {
                    item: MenuItem? ->
                when (item!!.itemId) {
                    R.id.item_home -> {
                        val intent = Intent(this, Home::class.java)
                        intent.putExtra("1", idusername)
                        intent.putExtra("2", username)
                        intent.putExtra("3", password)
                        intent.putExtra("4", address)
                        intent.putExtra("5", tel)
                        intent.putExtra("6", email)
                        startActivity(intent)
                        finish()
                    }
                    R.id.item_bed -> {
                        val intent = Intent(this, Bed::class.java)
                        intent.putExtra("1", idusername)
                        intent.putExtra("2", username)
                        intent.putExtra("3", password)
                        intent.putExtra("4", address)
                        intent.putExtra("5", tel)
                        intent.putExtra("6", email)
                        startActivity(intent)
                        finish()
                    }
                    R.id.item_info -> {
                        val intent = Intent(this, my_info::class.java)
                        intent.putExtra("1", idusername)
                        intent.putExtra("2", username)
                        intent.putExtra("3", password)
                        intent.putExtra("4", address)
                        intent.putExtra("5", tel)
                        intent.putExtra("6", email)
                        startActivity(intent)
                        finish()
                    }
                    R.id.item_logout -> {
                        val intent = Intent(this, Login::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
                true })
            popup.show()
        }

        info_edit.setOnClickListener(){
            if ((User_TV.text.isEmpty() && Pass_TV.text.isEmpty() && Tel_TV.text.isEmpty() && Email_TV.text.isEmpty() && Add_TV.text.isEmpty())){
                Toast.makeText(this, "กรุณากรอกข้อมูล", Toast.LENGTH_LONG).show()
            }
            else if ( User_TV.text.isEmpty()){
                Toast.makeText(this, "กรุณากรอกช่อง Username", Toast.LENGTH_LONG).show()
            }
            else if ( Pass_TV.text.isEmpty()){
                Toast.makeText(this, "กรุณากรอกช่อง Password", Toast.LENGTH_LONG).show()
            }
            else if (Tel_TV.text.isEmpty()) {
                Toast.makeText(this, "กรุณากรอกเบอร์มือถือ", Toast.LENGTH_LONG).show()
            }
            else if (Email_TV.text.isEmpty()) {
                Toast.makeText(this, "กรุณากรอกช่องอีเมล์", Toast.LENGTH_LONG).show()
            }
            else if (Add_TV.text.isEmpty()) {
                Toast.makeText(this, "กรุณากรอกที่อยู่", Toast.LENGTH_LONG).show()
            }
            else {
                val server : ClientAPI = Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:3000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ClientAPI::class.java)

                server.editinfo(idusername.toInt(),User_TV.text.toString(), Pass_TV.text.toString(),Tel_TV.text.toString(), Email_TV.text.toString() , Add_TV.text.toString())
                    .enqueue(object: Callback<Customer> {
                        override fun onResponse(
                            call: Call<Customer>,
                            response: Response<Customer>
                        ) {
                            if (response.isSuccessful) {
                                Toast.makeText(
                                    this@my_info,
                                    "แก้ไขข้อมูลสำเร็จ",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                        }

                        override fun onFailure(call: Call<Customer>, t: Throwable) {
                            return t.printStackTrace()
                        }
                    })
            }
        }
    }
}