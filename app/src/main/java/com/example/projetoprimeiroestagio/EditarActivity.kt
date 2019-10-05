package com.example.projetoprimeiroestagio

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.projetoprimeiroestagio.entities.Produto

class EditarActivity : AppCompatActivity() {

    var nome : String? = null
    var preco : String? = null
    var estoque : String? = null
    var descricao : String? = null

    lateinit var editarNome: EditText
    lateinit var editarPreco: EditText
    lateinit var editarQtd: EditText
    lateinit var editarDesc: EditText
    lateinit var confButton: Button
    lateinit var toolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        editarNome = findViewById(R.id.editarNome)
        editarPreco = findViewById(R.id.editarPreco)
        editarQtd = findViewById(R.id.editarQtd)
        editarDesc = findViewById(R.id.editarDesc)

        confButton = findViewById(R.id.confButton)

        var produto = intent.getParcelableExtra<Produto>("produto")

        if(produto != null) {
            editarNome.setText(produto.nome)
            editarPreco.setText(produto.preco)
            editarQtd.setText(produto.qtdEstoque)
            editarDesc.setText(produto.descricao)
        }

        confButton.setOnClickListener{
            produto = Produto (editarNome.text.toString(), editarPreco.text.toString(), editarQtd.text.toString(), editarDesc.text.toString())
            Toast.makeText(EditarActivity@this, "Produto atualizado com sucesso!", Toast.LENGTH_LONG).show()
            var i = Intent(EditarActivity@this, ExibirActivity::class.java)
            i.putExtra("produto", produto)
            startActivity(i)
            finish()
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
