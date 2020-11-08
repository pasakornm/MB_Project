package com.example.projectandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.password1
import kotlinx.android.synthetic.main.activity_main.username1
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        btn_login.setOnClickListener{
            if (username1.text.isEmpty() and password1.text.isEmpty() ) {
                Toast.makeText(this, "กรุณาใส่ไอดีและพาสเวิร์ด", Toast.LENGTH_LONG).show()
            }
            else if (username1.text.isEmpty()){
                Toast.makeText(this, "กรุณากรอกช่อง Username", Toast.LENGTH_LONG).show()
            }
            else if (password1.text.isEmpty()) {
                Toast.makeText(this, "กรุณากรอกช่อง Password", Toast.LENGTH_LONG).show()
            }
            else{
                val server: ClientAPI = Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:3000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ClientAPI::class.java)

                server.login123(username1.text.toString(), password1.text.toString()).enqueue(object: Callback<Customer>{
                    override fun onResponse(call: Call<Customer>, response: Response<Customer>) {
                        if (response.isSuccessful){
                            if (response.body()?.Cus_type == 1){
                                Toast.makeText(this@Login, "Admin", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this@Login, Admin_Home::class.java)
                                intent.putExtra("1", response.body()?.Cus_ID.toString())
                                intent.putExtra("2", response.body()?.Cus_username)
                                intent.putExtra("3", response.body()?.Cus_password)
                                intent.putExtra("4", response.body()?.Cus_address)
                                intent.putExtra("5", response.body()?.Cus_Tel)
                                intent.putExtra("6", response.body()?.Cus_email)
                                startActivity(intent)
                                finish()
                            }
                            else {
                                Toast.makeText(this@Login, "Success", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this@Login, Home::class.java)
                                intent.putExtra("1", response.body()?.Cus_ID.toString())
                                intent.putExtra("2", response.body()?.Cus_username)
                                intent.putExtra("3", response.body()?.Cus_password)
                                intent.putExtra("4", response.body()?.Cus_address)
                                intent.putExtra("5", response.body()?.Cus_Tel)
                                intent.putExtra("6", response.body()?.Cus_email)
                                startActivity(intent)
                                finish()
                            }
                        }
                        else {
                            Toast.makeText(this@Login, "Fail", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<Customer>, t: Throwable) {
                        return t.printStackTrace()
                    }
                })
            }

        }

        register.setOnClickListener{
            val intent = Intent(this, Register:: class.java)
            startActivity(intent)
        }

    }
}

