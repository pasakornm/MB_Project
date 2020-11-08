package com.example.projectandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            if (username.text.isEmpty() and email.text.isEmpty() and password.text.isEmpty() and repassword.text.isEmpty()){
                Toast.makeText(this, "กรุณากรอกข้อมูลการสมัครสมาชิก", Toast.LENGTH_LONG).show()
            }
            else if (username.text.isEmpty()){
                Toast.makeText(this, "กรุณากรอกช่อง Username", Toast.LENGTH_LONG).show()
            }
            else if (email.text.isEmpty()) {
                Toast.makeText(this, "กรุณากรอกช่อง Email", Toast.LENGTH_LONG).show()
            }
            else if (password.text.isEmpty()) {
                Toast.makeText(this, "กรุณากรอกช่อง Password", Toast.LENGTH_LONG).show()
            }
            else if (repassword.text.isEmpty()) {
                Toast.makeText(this, "กรุณากรอกช่อง Repassword", Toast.LENGTH_LONG).show()
            }
            else {
                if (password.text.toString() == repassword.text.toString()){
                    val server: ClientAPI = Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:3000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(ClientAPI::class.java)
                    server.insertCustomer(username.text.toString(), password.text.toString(), email.text.toString())
                        .enqueue(object : Callback<Customer>{
                            override fun onResponse(
                                call: Call<Customer>,
                                response: Response<Customer>
                            ) {
                                if (response.isSuccessful){
                                    Toast.makeText(this@Register, "Successfully", Toast.LENGTH_SHORT).show()
                                    val intent = Intent(this@Register, RegisterComplete::class.java)
                                    startActivity(intent)
                                }
                            }

                            override fun onFailure(call: Call<Customer>, t: Throwable) {
                                return t.printStackTrace()
                            }
                        })
                }
                else{
                    Toast.makeText(this, "Password ไม่ตรงกัน", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}