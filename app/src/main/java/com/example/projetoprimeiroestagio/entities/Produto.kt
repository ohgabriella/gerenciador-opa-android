package com.example.projetoprimeiroestagio.entities

import android.os.Parcel
import android.os.Parcelable

class Produto (var nome:String?= "", var preco: String? = "", var qtdEstoque: String? = "", var descricao: String? = ""): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun toString() : String{
        return "Nome: ${nome} \nPreço: ${preco} \nEstoque: ${qtdEstoque} \nDescrição: ${descricao}";
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeString(preco)
        parcel.writeString(qtdEstoque)
        parcel.writeString(descricao)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Produto> {
        override fun createFromParcel(parcel: Parcel): Produto {
            return Produto(parcel)
        }

        override fun newArray(size: Int): Array<Produto?> {
            return arrayOfNulls(size)
        }
    }

}