package com.example.projectandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_bed.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.imageView6

class Bed : AppCompatActivity() {
    var idusername =""
    var username = ""
    var password = ""
    var address = ""
    var tel = ""
    var email = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bed)
        idusername = intent.getStringExtra("1").toString()
        username = intent.getStringExtra("2").toString()
        password = intent.getStringExtra("3").toString()
        address = intent.getStringExtra("4").toString()
        tel = intent.getStringExtra("5").toString()
        email = intent.getStringExtra("6").toString()

        button_bed1.setOnClickListener(){
            val intent = Intent(this, prepayment::class.java)
            intent.putExtra("1", idusername)
            intent.putExtra("2", username)
            intent.putExtra("3", password)
            intent.putExtra("4", address)
            intent.putExtra("5", tel)
            intent.putExtra("6", email)
            startActivity(intent)
        }

        button_bed2.setOnClickListener(){
            val intent = Intent(this, prepayment2::class.java)
            intent.putExtra("1", idusername)
            intent.putExtra("2", username)
            intent.putExtra("3", password)
            intent.putExtra("4", address)
            intent.putExtra("5", tel)
            intent.putExtra("6", email)
            startActivity(intent)
        }


        imageView7.setOnClickListener(){
            val popup = PopupMenu(this, imageView7)
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
    }
}