package com.example.discoapp.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.discoapp.R
import com.example.discoapp.MainActivity
import com.example.discoapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

import com.example.discoapp.NavDrawActivity

/**
 * Classe per la gestione del login dell'utente
 */
class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var email: String
    lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        // per mantenere l'utente loggato
        var auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        if (currentUser !=null){
            //commento per vedere se resta su quella con menu
           // startActivity(Intent(this, MainActivity::class.java))

            startActivity(Intent(this, NavDrawActivity::class.java))


            finish()
        }

        binding.registerFromLoginButton.setOnClickListener {
            val register_intent = Intent(this, RegisterActivity::class.java)
            startActivity(register_intent)


        }

        binding.loginButton.setOnClickListener {
            email = binding.loginEmail.text.toString()
            password = binding.loginPassword.text.toString()
            if (checkFields()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) { //se l'account esiste

                            /*
                            val contactViewModel : ContactViewModel= ViewModelProvider(this).get(ContactViewModel::class.java)
                            //i contatti in locale vengono cancellati per evitare conflitti in caso di
                            //login di utenti diversi sullo stesso device
                            contactViewModel.deleteAll()
                            //sincronizzazione con il db remoto
                            contactViewModel.putFavFromRemoteToLocal()
                             */

                            //prova per vedere se va verso il menu
                            //val MoveToMain = Intent(this, MainActivity::class.java)

                            val MoveToMain = Intent(this, NavDrawActivity::class.java)

                            // salvataggio registration token
                            //contactViewModel.retrieveAndStoreToken()
                            //

                            startActivity(MoveToMain)
                            finish()
                        } else Toast.makeText(
                            this,
                            "Inserire correttamente email e password.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            } else Toast.makeText(this, "Compilare i campi.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkFields(): Boolean {
        return email != "" && password != ""
    }


}