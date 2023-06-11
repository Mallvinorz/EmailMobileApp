package com.example.androidexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.androidexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(EmailFragment())

        //navigation bar
        binding.apply {
            toggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {
                when (it.itemId){
                    R.id.berbintang -> {
                        Toast.makeText(this@MainActivity, "Email Berbintang", Toast.LENGTH_SHORT).show()
                    }
                    R.id.ditunda -> {
                        Toast.makeText(this@MainActivity, "Email Ditunda", Toast.LENGTH_SHORT).show()
                    }
                    R.id.penting -> {
                        Toast.makeText(this@MainActivity, "Email Penting", Toast.LENGTH_SHORT).show()
                    }
                    R.id.terkirim -> {
                        Toast.makeText(this@MainActivity, "Email Terkirim", Toast.LENGTH_SHORT).show()
                    }
                    R.id.terjadwal -> {
                        Toast.makeText(this@MainActivity, "Email Terjadwal", Toast.LENGTH_SHORT).show()
                    }
                    R.id.kotak_keluar -> {
                        Toast.makeText(this@MainActivity, "Kotak keluar Email", Toast.LENGTH_SHORT).show()
                    }
                    R.id.draf -> {
                        Toast.makeText(this@MainActivity, "Draf Email", Toast.LENGTH_SHORT).show()
                    }
                    R.id.semua_email -> {
                        Toast.makeText(this@MainActivity, "Tampil semua Email", Toast.LENGTH_SHORT).show()
                    }
                    R.id.spam -> {
                        Toast.makeText(this@MainActivity, "Email Spam", Toast.LENGTH_SHORT).show()
                    }
                    R.id.sampah -> {
                        Toast.makeText(this@MainActivity, "Sampah Email", Toast.LENGTH_SHORT).show()
                    }
                    R.id.setelan -> {
                        Toast.makeText(this@MainActivity, "Setelan", Toast.LENGTH_SHORT).show()
                    }
                    R.id.bantuan -> {
                        Toast.makeText(this@MainActivity, "Bantuan & Masukan", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
        }

        //bottom navigation bar
        binding.botNavBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bn_icon_email -> replaceFragment(EmailFragment())
                R.id.bn_icon_meet -> replaceFragment(MeetFragment())
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fl_main, fragment)
        fragmentTransition.commit()
    }

}