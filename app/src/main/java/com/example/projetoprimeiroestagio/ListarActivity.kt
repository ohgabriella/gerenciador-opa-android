package com.example.projetoprimeiroestagio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListarActivity : AppCompatActivity() {

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)


        var produtos = ArrayList<Produto>()
        produtos.add(Produto("Coxinha", "4.00", "5", "Sabor frango"))

        listView = findViewById(R.id.listView)

        var arrayAdapter = ArrayAdapter<Produto>(ListarActivity@ this, android.R.layout.simple_list_item_1, produtos)

        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            var produto = produtos.get(position)
            var i = Intent(ListarActivity@this, ExibirActivity::class.java)
            i.putExtra("produto", produto)
            startActivity(i)
        }
    }
}
