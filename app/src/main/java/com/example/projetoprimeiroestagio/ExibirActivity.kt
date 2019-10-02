package com.example.projetoprimeiroestagio

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.projetoprimeiroestagio.entities.Produto

class ExibirActivity : AppCompatActivity() {

    var nome : String? = null
    var preco : String? = null
    var estoque : String? = null
    var descricao : String? = null

    lateinit var textNome : TextView
    lateinit var textPreco : TextView
    lateinit var textEstoque : TextView
    lateinit var textDescricao : TextView
    lateinit var edtButton: Button
    lateinit var toolbar: Toolbar

    companion object{
        const val REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibir)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        textNome = findViewById(R.id.textNome)
        textPreco = findViewById(R.id.textPreco)
        textEstoque = findViewById(R.id.textEstoque)
        textDescricao = findViewById(R.id.textDescricao)
        edtButton = findViewById(R.id.edtButton)

        var produto = intent.getParcelableExtra<Produto>("produto")

        if(produto != null) {
            nome = produto.nome
            preco = produto.preco
            estoque = produto.qtdEstoque
            descricao = produto.descricao

            textNome.text = "Nome: ${nome}"
            textPreco.text = "Preço: ${preco}"
            textEstoque.text = "Quantidade em estoque: ${estoque}"
            textDescricao.text = "Descrição: ${descricao}"
        }


        edtButton.setOnClickListener{
            var i = Intent(ExibirActivity@ this, EditarActivity::class.java)
            i.putExtra("produto", produto)
            startActivityForResult(i, REQUEST_CODE)

            //startActivity(i)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == ListarActivity.REQUEST_CODE && resultCode == Activity.RESULT_OK){
            var produto = data?.getParcelableExtra<Produto>("produto")

            if(produto != null){
                nome = produto.nome
                preco = produto.preco
                estoque = produto.qtdEstoque
                descricao = produto.descricao

                textNome.text = "Nome: ${nome}"
                textPreco.text = "Preço: ${preco}"
                textEstoque.text = "Quantidade em estoque: ${estoque}"
                textDescricao.text = "Descrição: ${descricao}"
            }else{
                Log.e("MainActivity", "Error ao retornar uma produto")
            }
        }

    }


}
