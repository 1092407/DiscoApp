package com.example.discoapp.firedb

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

 open class FireDB {

        protected var db = FirebaseFirestore.getInstance()
        protected  var auth = FirebaseAuth.getInstance().currentUser?.email.toString()

}