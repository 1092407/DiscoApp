package com.example.discoapp.firedb

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

//classe con metodi per lavorare sugli eventi, in particolare per recuperare tutti gli eventi e per fare
//una prenotazione

class eventofiredb {

    val db = Firebase.firestore
    var auth = FirebaseAuth.getInstance()
    private lateinit var database: DatabaseReference

    //database = Firebase.database.reference

    var databaseRemoteEvents: DatabaseReference = FirebaseDatabase.getInstance("https://discoapp-7b574-default-rtdb.firebaseio.com/")
        .getReference("evento")
    var databaseRemoteprenotazione: DatabaseReference = FirebaseDatabase.getInstance(
        "https://discoapp-7b574-default-rtdb.firebaseio.com/")
        .getReference("prenotazione")

    lateinit var dbRef : DatabaseReference

}


