package com.example.android4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android4a.R
import com.example.android4a.domain.entity.User
import kotlinx.android.synthetic.main.creation_compte.*
import org.koin.android.ext.android.inject

class Create : AppCompatActivity() {



    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.creation_compte)


        Create_account.setOnClickListener(){
            val monIntentRetour =  Intent(this,MainActivity::class.java)
            val user = User((loginAccount_edit.text.toString().trim()),passwordAccount_edit.text.toString())
            if(user.email !="" && user.password != "") {
                mainViewModel.onClickedLoginAccount(user)
                startActivity(monIntentRetour)
            }else{
                Toast.makeText(applicationContext,"add a password or a user",Toast.LENGTH_SHORT).show()
            }
        }
    }
}