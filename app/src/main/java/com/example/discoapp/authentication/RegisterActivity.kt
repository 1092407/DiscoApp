package com.example.discoapp.authentication

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.navArgs

import com.example.discoapp.databinding.ActivityRegisterBinding
import com.example.discoapp.firedb.UserDB


import com.google.firebase.auth.FirebaseAuth


import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

//queste le ho messe io
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

/**
 * Classe per la gestione della registrazione di un nuovo utente
 */

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding

    //questa era real time db
    //lateinit var database: DatabaseReference

    lateinit var mFirebaseAuth: FirebaseAuth
    val db = Firebase.firestore

    val vmodel= ViewModelAuth()
    //val userDB=UserDB()
    lateinit var name: String
    lateinit var surname: String
    lateinit var email: String
    lateinit var password: String
   lateinit var cell_number: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)





        binding.registerButton.setOnClickListener {
            set_helpers()
            check_fileds()
        }
    }

    fun set_helpers(){
        binding.EmailContainer.helperText = validEmail()
        binding.passwordContainer.helperText = validPassword()
        binding.phoneContainer.helperText = validPhone()
        binding.NameContainer.helperText = validName()
        binding.SurnameContainer.helperText = validSurame()
    }

    private fun check_fileds() {

        val validName = binding.NameContainer.helperText == null
        val validSurname = binding.SurnameContainer.helperText == null
        val validEmail = binding.EmailContainer.helperText == null
        val validPassword = binding.passwordContainer.helperText == null
       val validPhone = binding.phoneContainer.helperText == null

        //se gli helper text sono tutti null -> creo l'account
        if (validName && validSurname && validEmail && validPassword )
            createAccount()
        else
            invalidForm()
    }

    private fun createAccount() {
        name = binding.registerName.text.toString()
        surname = binding.registerSurname.text.toString()
        cell_number = binding.registerCell.text.toString()
        password = binding.registerPassword.text.toString()
        email = binding.registerEmail.text.toString()

        lifecycleScope.launch {

                if (vmodel.singUp(email, password) != null) {

                    vmodel.addAuthUtenteOnDB(name, surname, email, cell_number)

                    val intent = Intent(applicationContext, LoginActivity::class.java)

                    startActivity(intent)
                    finish()
                }

        }

        //io prova
        /*
        val addobserver=Observer<Boolean>{
            if (vmodel.status.value==true) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        vmodel.status.observe(this,addobserver)*/

        /*
        mFirebaseAuth
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                   // val user = User(name, surname, email)

                    /*
                    //inserisco l'utente nel db realtime
                    database.child(FirebaseAuth.getInstance().currentUser!!.uid).setValue(user)
                    */

                    //salva dati nel dbfirestore con scope
                   vmodel.addUtente(name, surname, email, cell_number)

                  //  val intent = Intent(this, LoginActivity::class.java)


                    /*
                    val contactViewModel : ContactViewModel = ViewModelProvider(this).get(
                        ContactViewModel::class.java)
                    contactViewModel.retrieveAndStoreToken()
                    */

                    //
                  //  startActivity(intent)
                    //finish()

                } else {
                    //Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        this@RegisterActivity, "Autenticazione fallita. Riprova di nuovo.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } */

    }

    private fun validEmail(): String?
    {
        val emailText = binding.registerEmail.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches())
        {
            return "Indirizzo email non valido"
        }
        return null
    }

    private fun validPassword(): String?
    {
        val passwordText = binding.registerPassword.text.toString()
        if(passwordText.length < 8)
        {
            return "Password di minimo 8 caratteri"
        }
        if(!passwordText.matches(".*[A-Z].*".toRegex()))
        {
            return "Deve contenere 1 carattere maiuscolo."
        }
        if(!passwordText.matches(".*[a-z].*".toRegex()))
        {
            return "Deve contenere 1 carattere minuscolo."
        }
        if(!passwordText.matches(".*[@#\$%^&+=].*".toRegex()))
        {
            return "Deve contenere 1 carattere speciale. (@#\$%^&+=)"
        }

        return null
    }


    private fun validPhone(): String?
    {
        val phoneText = binding.registerCell.text.toString()
        if(!phoneText.matches(".*[0-9].*".toRegex()))
        {
            return "Deve contenere solo cifre"
        }
        if(phoneText.length != 10)
        {
            return "Deve contenere 10 cifre"
        }
        return null
    }

    private fun validName(): String?
    {
        val nameText = binding.registerName.text.toString()
        if(nameText =="")
        {
            return "Inserire un nome"
        }
        return null
    }

    private fun validSurame(): String?
    {
        val surnameText = binding.registerSurname.text.toString()
        if(surnameText =="")
        {
            return "Inserire un cognome"
        }
        return null
    }

    private fun invalidForm()
    {
        var message = ""
        if(binding.EmailContainer.helperText != null)
            message += "\n\nEmail: " + binding.EmailContainer.helperText
        if(binding.passwordContainer.helperText != null)
            message += "\n\nPassword: " + binding.passwordContainer.helperText
      /*
        if(binding.phoneContainer.helperText != null)
            message += "\n\nPhone: " + binding.phoneContainer.helperText
        */

        if(binding.NameContainer.helperText != null)
            message += "\n\nName: " + binding.NameContainer.helperText
        if(binding.SurnameContainer.helperText != null)
            message += "\n\nSurname: " + binding.SurnameContainer.helperText

        AlertDialog.Builder(this)
            .setTitle("Invalid Form")
            .setMessage(message)
            .setPositiveButton("Okay"){ _,_ ->
                // do nothing
            }
            .show()
    }
}

