package com.example.projetoprimeiroestagio

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.projetoprimeiroestagio.entities.Produto
import kotlinx.android.synthetic.main.activity_cadastrar.view.*

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar)

        editarNome = findViewById(R.id.editarNome)
        editarPreco = findViewById(R.id.editarPreco)
        editarQtd = findViewById(R.id.editarQtd)
        editarDesc = findViewById(R.id.editarDesc)

        confButton = findViewById(R.id.confButton)

        var produto = intent.getParcelableExtra<Produto>("produto")

        if(produto != null) {
            nome = produto.nome;
            preco = produto.preco;
            estoque = produto.qtdEstoque;
            descricao = produto.descricao;

            editarNome.setText(nome)
            editarPreco.setText(preco)
            editarQtd.setText(estoque)
            editarDesc.setText(descricao)
        }

        confButton.setOnClickListener{
            nome = editarNome.text.toString()
            preco = editarPreco.text.toString()
            estoque = editarQtd.text.toString()
            descricao = editarDesc.text.toString()

            var produto = Produto (nome, preco, estoque, descricao)
            var i = Intent()
            i.putExtra("produto", produto)
            setResult(Activity.RESULT_OK, i)

        }
    }


}
