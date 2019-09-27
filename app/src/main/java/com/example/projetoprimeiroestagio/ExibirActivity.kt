package com.example.projetoprimeiroestagio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_exibir.*

class ExibirActivity : AppCompatActivity() {

    var nome : String? = null
    var preco : String? = null
    var estoque : String? = null
    var descricao : String? = null

    lateinit var textNome : TextView
    lateinit var textPreco : TextView
    lateinit var textEstoque : TextView
    lateinit var textDescricao : TextView
    lateinit var botaoVoltar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibir)

        textNome = findViewById(R.id.textNome)
        textPreco = findViewById(R.id.textPreco)
        textEstoque = findViewById(R.id.textEstoque)
        textDescricao = findViewById(R.id.textDescricao)
        botaoVoltar = findViewById(R.id.botaoVoltar)

        var produto = intent.getParcelableExtra<Produto>("produto")

        if(produto != null) {
            nome = produto.nome;
            preco = produto.preco;
            estoque = produto.qtdEstoque;
            descricao = produto.descricao;

            textNome.text = "Nome: ${nome}"
            textPreco.text = "Preço: ${preco}"
            textEstoque.text = "Quantidade em estoque: ${estoque}"
            textDescricao.text = "Descrição: ${descricao}"
        }

        botaoVoltar.setOnClickListener {
            var intent = Intent(ExibirActivity@this, ListarActivity::class.java)
            startActivity(intent)
        }

        //Toast.makeText(ExibirActivity@this, produto.toString(), Toast.LENGTH_LONG).show()
    }
}
