@file:Suppress("UNREACHABLE_CODE")

package com.example.projetoprimeiroestagio

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.projetoprimeiroestagio.entities.Produto

class ExibirActivity : AppCompatActivity() {

    var nome: String? = null
    var preco: String? = null
    var estoque: String? = null
    var descricao: String? = null

    lateinit var produto: Produto

    lateinit var textNome: TextView
    lateinit var textPreco: TextView
    lateinit var textEstoque: TextView
    lateinit var textDescricao: TextView
    lateinit var edtButton: Button
    lateinit var toolbar: Toolbar

    companion object {
        const val REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibir)

        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        textNome = findViewById(R.id.textNome)
        textPreco = findViewById(R.id.textPreco)
        textEstoque = findViewById(R.id.textEstoque)
        textDescricao = findViewById(R.id.textDescricao)
        edtButton = findViewById(R.id.edtButton)

        produto = intent.getParcelableExtra<Produto>("produto")

        if (produto != null) {
            nome = produto.nome
            preco = produto.preco
            estoque = produto.qtdEstoque
            descricao = produto.descricao

            textNome.text = "Nome: ${nome}"
            textPreco.text = "Preço: ${preco}"
            textEstoque.text = "Quantidade em estoque: ${estoque}"
            textDescricao.text = "Descrição: ${descricao}"
        }

        edtButton.setOnClickListener {
            var i = Intent(ExibirActivity@ this, EditarActivity::class.java)
            i.putExtra("produto", produto)
            startActivity(i)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return (when (item.itemId) {
            android.R.id.home -> {
                retornarPagina()
                true
            }
            else -> {super.onOptionsItemSelected(item)}
        })

    }

    fun retornarPagina() {
        var i = Intent(ExibirActivity@ this, ListarActivity::class.java)
        i.putExtra("produto", produto)
        setResult(Activity.RESULT_OK, i)
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
