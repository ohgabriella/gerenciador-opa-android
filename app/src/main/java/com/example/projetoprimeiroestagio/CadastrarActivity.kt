package com.example.projetoprimeiroestagio

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.projetoprimeiroestagio.entities.Produto

class CadastrarActivity : AppCompatActivity() {

    lateinit var inputNome: EditText
    lateinit var inputPreco: EditText
    lateinit var inputQtd: EditText
    lateinit var inputDesc: EditText
    lateinit var cadastrarButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)

        inputNome = findViewById(R.id.inputNome)
        inputPreco = findViewById(R.id.inputPreco)
        inputQtd = findViewById(R.id.inputQtd)
        inputDesc = findViewById(R.id.inputDesc)
        cadastrarButton = findViewById(R.id.cadastrarButton)

        cadastrarButton.setOnClickListener {
        if(inputNome.text.isNotEmpty() && inputPreco.text.isNotEmpty() && inputQtd.text.isNotEmpty() && inputDesc.text.isNotEmpty()){
            var nome = inputNome.text.toString()
            var preco = inputPreco.text.toString()
            var qtd = inputQtd.text.toString()
            var desc = inputDesc.text.toString()

            var produto =
                Produto(nome, preco, qtd, desc)

            var i = Intent()

            i.putExtra("produto", produto)

            setResult(Activity.RESULT_OK, i)
            finish()
        }else{
            Toast.makeText(CadastrarActivity@this, "Preencha os campos", Toast.LENGTH_LONG).show()
        }

        }

    }
}
