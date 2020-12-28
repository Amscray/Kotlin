package com.example.android4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.android4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.connexion_user.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {


    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.connexion_user)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Connection")
                        .setMessage("Compte existant")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                    val monIntent : Intent =  Intent(this, GoAPI::class.java)
                    startActivity(monIntent)

                }
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Erreur")
                        .setMessage("Veuillez créer un compte")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })
        login_button.setOnClickListener(){
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
        }
        create_account_button.setOnClickListener(){
            val monIntent : Intent =  Intent(this,Create::class.java)
            startActivity(monIntent)
        }
    }
}