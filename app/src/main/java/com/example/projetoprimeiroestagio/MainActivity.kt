package com.example.projetoprimeiroestagio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var user: EditText
    lateinit var password: EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user = findViewById(R.id.user)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener{
            if(user.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()){
                val intent = Intent(MainActivity@this, ListarActivity::class.java)
                startActivity(intent)
            }else{
                //mensagem que não é possivel entrar com login vazio
            }
        }
    }
}
