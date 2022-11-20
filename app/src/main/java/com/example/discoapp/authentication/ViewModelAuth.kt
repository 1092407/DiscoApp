package com.example.discoapp.authentication

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.discoapp.firedb.UserDB  //dataclass
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ViewModelAuth:ViewModel() {

    val userDB= UserDB()
    var _status= MutableLiveData<Boolean>()

    val status:LiveData <Boolean >
         get()=_status


    private var auth: FirebaseAuth = Firebase.auth

    suspend fun singUp(email: String, password: String): FirebaseUser? {
        return try {
            val response = auth.createUserWithEmailAndPassword(email, password).await()
            response.user
        } catch (e: Exception) {
            null
        }
    }

    suspend fun signIn(email: String, password: String): FirebaseUser? {
        return try {
            val signin = auth.signInWithEmailAndPassword(email, password).await()
            signin.user
        } catch (e: Exception) {
            null
        }
    }


    suspend fun addAuthUtenteOnDB(nome:String, cognome:String, email:String, num_cell:String
    ) {
        try {
            val user = auth.currentUser

            /*
            val profileUpdates = userProfileChangeRequest {
                displayName = nome + ' ' + cognome
            }
            user!!.updateProfile(profileUpdates)
            */

            userDB.addUtente(nome, cognome, email,num_cell)

        } catch (e: Exception) {
        }
    }

    fun checkUtenteisLoggato() : Boolean{
        if(auth.currentUser != null)
            return true
        return false
    }
}