package com.example.androidexercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import com.example.androidexercise.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var inEmail: EditText
    private lateinit var inPword: EditText
    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inEmail = binding.etInputEmail
        inPword = binding.etInputPassword
        dbHelper = DBHelper(this)

        binding.btnLogin.setOnClickListener {
            val userInEmail = inEmail.text.toString()
            val userInPword = inPword.text.toString()

            if (TextUtils.isEmpty(userInEmail) || TextUtils.isEmpty(userInPword)){
                Toast.makeText(this, "Masukkan Email dan Password!", Toast.LENGTH_SHORT).show()
            } else {
                val check = dbHelper.checkUserPass(userInEmail, userInPword)
                if (check == true){
                    Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Email dan Password Salah!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        //move to register page
        binding.tvRegister.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

}