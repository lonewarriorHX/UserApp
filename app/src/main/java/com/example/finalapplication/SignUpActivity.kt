package com.example.finalapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.editPassword
import kotlinx.android.synthetic.main.activity_main.editUser
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = FirebaseAuth.getInstance()
        val myTxt = findViewById<TextView>(R.id.signUp)
        val cancel = findViewById<TextView>(R.id.Cancel)
        editPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        editPassword.setSelection(editPassword.text.toString().length)
        confirmPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        confirmPassword.setSelection(editPassword.text.toString().length)

        cancel.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        myTxt.setOnClickListener{
            signUpUser()
        }
    }

    private fun signUpUser(){
        if (editUser.text.toString().isEmpty()){
            editUser.error = "Please enter email"
            editUser.requestFocus()
            return
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(editUser.text.toString()).matches()) {
            editUser.error = "Please enter a valid email"
            editUser.requestFocus()
            return
        }
        if (editPassword.text.toString().isEmpty()){
            editPassword.error = "Please enter password"
            editPassword.requestFocus()
            return
        }
        if (editPassword.text.toString() != confirmPassword.text.toString()){
            editPassword.error = "Password not matched!"
            confirmPassword.error="Password not matched!"
            editPassword.requestFocus()
            confirmPassword.requestFocus()
            return
        }
        auth.createUserWithEmailAndPassword(editUser.text.toString(), editPassword.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    user!!.sendEmailVerification()
                        .addOnCompleteListener { task1 ->
                            if (task1.isSuccessful) {
                                //Log.d(TAG, "createUserWithEmail:success")
                                startActivity(Intent(this,MainActivity::class.java))
                                finish()
                            }
                        }
                } else {
                    Toast.makeText(baseContext, "Sign Up failed. Try again after some time",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}