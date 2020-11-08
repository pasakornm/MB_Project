package com.example.projectandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_admin__cancle.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Admin_Cancle : AppCompatActivity(), CancelOnClickListener {
    var reservelist = arrayListOf<Reserve>()
    var idusername =""
    var username = ""
    var password = ""
    var address = ""
    var tel = ""
    var email = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin__cancle)

        reclycleview.adapter = ReserveAdapter(this.reservelist, applicationContext, this)
        reclycleview.layoutManager = LinearLayoutManager(applicationContext)
        reclycleview.addItemDecoration(DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL))

        idusername = intent.getStringExtra("1").toString()
        username = intent.getStringExtra("2").toString()
        password = intent.getStringExtra("3").toString()
        address = intent.getStringExtra("4").toString()
        tel = intent.getStringExtra("5").toString()
        email = intent.getStringExtra("6").toString()

        onClickSearch()

        imageView31.setOnClickListener(){
            val popup = PopupMenu(this, imageView31)
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
    }
    fun onClickSearch(){
        btnSearch.setOnClickListener(){
            showreserve()
        }

    }
    fun showreserve (){
        reservelist.clear()
        val server: ClientAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ClientAPI::class.java)

        server.serch(SerchReserve.text.toString().toInt()).enqueue(object : Callback<List<Reserve>>{
            override fun onResponse(call: Call<List<Reserve>>, response: Response<List<Reserve>>) {
                response.body()?.forEach{
                    reservelist.add(Reserve(it.Reserve_ID, it.Cus_ID, it.Reserve_Date, it.Check_In_Date, it.Check_Out_Date, it.Total_Price, it.Room_Type))
                }
                reclycleview.adapter = ReserveAdapter(reservelist, applicationContext, this@Admin_Cancle)
            }

            override fun onFailure(call: Call<List<Reserve>>, t: Throwable) {
                return t.printStackTrace()
            }
        })

    }

    override fun onClickRemove(reserve: Reserve) {
        val reId = reserve.Reserve_ID.toString()
        val server: ClientAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ClientAPI::class.java)
        server.roomcancle(reId.toInt()).enqueue(object : Callback<Reserve> {
            override fun onResponse(call: Call<Reserve>, response: Response<Reserve>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@Admin_Cancle, "ยกเลิกห้องพักสำเร็จ", Toast.LENGTH_SHORT).show()
                    showreserve ()
                }
            }

            override fun onFailure(call: Call<Reserve>, t: Throwable) {
                return t.printStackTrace()
            }
        })
    }
}