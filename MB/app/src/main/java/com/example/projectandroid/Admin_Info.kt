package com.example.projectandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin__info.*
import kotlinx.android.synthetic.main.activity_my_info.*
import kotlinx.android.synthetic.main.activity_my_info.Add_TV
import kotlinx.android.synthetic.main.activity_my_info.Email_TV
import kotlinx.android.synthetic.main.activity_my_info.Pass_TV
import kotlinx.android.synthetic.main.activity_my_info.Tel_TV
import kotlinx.android.synthetic.main.activity_my_info.User_TV
import kotlinx.android.synthetic.main.activity_my_info.imageView8
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Admin_Info : AppCompatActivity() {
    var idusername =""
    var username = ""
    var password = ""
    var address = ""
    var tel = ""
    var email = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin__info)
        idusername = intent.getStringExtra("1").toString()
        username = intent.getStringExtra("2").toString()
        password = intent.getStringExtra("3").toString()
        address = intent.getStringExtra("4").toString()
        tel = intent.getStringExtra("5").toString()
        email = intent.getStringExtra("6").toString()

        User_Admin.setText(username)
        Pass_Admin.setText(password)
        Tel_Admin.setText(tel)
        Email_Admin.setText(email)
        Add_Admin.setText(address)
        imageViewAdmin.setOnClickListener(){
            val popup = PopupMenu(this, imageViewAdmin)
            popup.inflate(R.menu.bt_navigation2)
            popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener {
                    item: MenuItem? ->
                when (item!!.itemId) {
                    R.id.item_cus -> {
                        val intent = Intent(this, Admin_Home::class.java)
                        intent.putExtra("1", idusername)
                        intent.putExtra("2", username)
                        intent.putExtra("3", password)
                        intent.putExtra("4", address)
                        intent.putExtra("5", tel)
                        intent.putExtra("6", email)
                        startActivity(intent)
                        finish()
                    }
                    R.id.item_cuscancle -> {
                        val intent = Intent(this, Admin_Cancle::class.java)
                        intent.putExtra("1", idusername)
                        intent.putExtra("2", username)
                        intent.putExtra("3", password)
                        intent.putExtra("4", address)
                        intent.putExtra("5", tel)
                        intent.putExtra("6", email)
                        startActivity(intent)
                        finish()
                    }
                    R.id.item_admininfo -> {
                        val intent = Intent(this, Admin_Info::class.java)
                        intent.putExtra("1", idusername)
                        intent.putExtra("2", username)
                        intent.putExtra("3", password)
                        intent.putExtra("4", address)
                        intent.putExtra("5", tel)
                        intent.putExtra("6", email)
                        startActivity(intent)
                        finish()
                    }
                    R.id.item_adminlogout -> {
                        val intent = Intent(this, Login::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
                true })
            popup.show()
        }

        Admin_edit.setOnClickListener(){
            if ((User_Admin.text.isEmpty() && Pass_Admin.text.isEmpty() && Tel_Admin.text.isEmpty() && Email_Admin.text.isEmpty() && Add_Admin.text.isEmpty())){
                Toast.makeText(this, "กรุณากรอกข้อมูล", Toast.LENGTH_LONG).show()
            }
            else if ( User_Admin.text.isEmpty()){
                Toast.makeText(this, "กรุณากรอกช่อง Username", Toast.LENGTH_LONG).show()
            }
            else if ( Pass_Admin.text.isEmpty()){
                Toast.makeText(this, "กรุณากรอกช่อง Password", Toast.LENGTH_LONG).show()
            }
            else if (Tel_Admin.text.isEmpty()) {
                Toast.makeText(this, "กรุณากรอกเบอร์มือถือ", Toast.LENGTH_LONG).show()
            }
            else if (Email_Admin.text.isEmpty()) {
                Toast.makeText(this, "กรุณากรอกช่องอีเมล์", Toast.LENGTH_LONG).show()
            }
            else if (Add_Admin.text.isEmpty()) {
                Toast.makeText(this, "กรุณากรอกที่อยู่", Toast.LENGTH_LONG).show()
            }
            else {
                val server : ClientAPI = Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:3000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ClientAPI::class.java)

                server.editinfo(idusername.toInt(),User_Admin.text.toString(), Pass_Admin.text.toString(),Tel_Admin.text.toString(), Email_Admin.text.toString() , Add_Admin.text.toString())
                    .enqueue(object: Callback<Customer> {
                        override fun onResponse(
                            call: Call<Customer>,
                            response: Response<Customer>
                        ) {
                            if (response.isSuccessful) {
                                Toast.makeText(
                                    this@Admin_Info,
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