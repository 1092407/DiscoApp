package com.example.discoapp.firedb

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class UserDB :FireDB (){

    val utenti_collection = db.collection("users")
  var status=false

    suspend fun addUtente(
        name: String,
        surname : String,
        cell:String,
        email: String
      ) :Boolean{

        Log.d("db",utenti_collection.toString())
        val utente = hashMapOf<String, Any>(
            "name" to name,
            "surname" to surname,
            "email" to email,
        "cell" to cell

        )
        withContext(Dispatchers.IO){
            utenti_collection
                .document(email)
                .set(utente)
                .addOnSuccessListener { status=true }
                .addOnFailureListener {status=false}
                .await()
        }
return status
    }

}

// .add se se esiste errore
// .set crea o sovrascrive