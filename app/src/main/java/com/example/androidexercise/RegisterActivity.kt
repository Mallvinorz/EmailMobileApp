package com.example.androidexercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import com.example.androidexercise.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var cpassword: EditText
    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        email = binding.etInputEmail
        password = binding.etInputPassword
        cpassword = binding.etConfirmPassword
        dbHelper = DBHelper(this)

        binding.btnRegister.setOnClickListener {
            val emailText = email.text.toString()
            val pwordText = password.text.toString()
            val cpwordText = cpassword.text.toString()
            val saveData = dbHelper.insertData(emailText, pwordText)

            if(TextUtils.isEmpty(emailText) || TextUtils.isEmpty(pwordText) || TextUtils.isEmpty(cpwordText)){
                Toast.makeText(this, "Masukkan Email atau Password & Konfirmasi Password!", Toast.LENGTH_SHORT).show()
            } else {
                if(pwordText.equals(cpwordText)){
                    if(saveData == true){
                        Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Email sudah ada", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Password tidak sama!!", Toast.LENGTH_SHORT).show()
                }
            }
        }


        //move to login page
        binding.tvLogin.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}