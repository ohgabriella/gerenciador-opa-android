package com.example.projetoprimeiroestagio

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.projetoprimeiroestagio.entities.Produto
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListarActivity : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var addButton: FloatingActionButton
    lateinit var listProdutos : ArrayList<Produto>
    lateinit var arrayAdapterProduto: ArrayAdapter<Produto>

    companion object{
        const val REQUEST_CODE = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)

        listView = findViewById(R.id.listView)
        addButton = findViewById(R.id.addButton)

        listProdutos = ArrayList<Produto>()
        listProdutos.add(Produto("Coxinha", "4.0", "5", "Flango"))

        arrayAdapterProduto = ArrayAdapter(ListarActivity@this, android.R.layout.simple_list_item_1, listProdutos)

        listView.adapter = arrayAdapterProduto

        listView.setOnItemClickListener { parent, view, position, id ->
            var produto = listProdutos[position]
            var i = Intent(ListarActivity@ this, ExibirActivity::class.java)
            i.putExtra("produto", produto)
            startActivity(i)
        }

        addButton.setOnClickListener {
            var i = Intent(ListarActivity@ this, CadastrarActivity::class.java)
            startActivityForResult(i, REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            var produto = data?.getParcelableExtra<Produto>("produto")
            if(produto != null){
                listProdutos.add(produto)
                arrayAdapterProduto.notifyDataSetChanged()
            }else{
                Log.e("MainActivity", "Error ao retornar uma produto")
            }
        }
    }

}
