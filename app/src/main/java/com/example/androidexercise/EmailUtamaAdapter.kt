package com.example.androidexercise

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailUtamaAdapter(private val emailUtama: ArrayList<EmailUtamaDataClass>):
    RecyclerView.Adapter<EmailUtamaAdapter.EmailUtamaViewHolder>(){
        class EmailUtamaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val username: TextView = itemView.findViewById(R.id.tv_user_name)
            val mail: TextView = itemView.findViewById(R.id.tv_mail)
            val pProfile: ImageView = itemView.findViewById(R.id.civ_email_utama)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailUtamaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_email_utama, parent, false)
        return EmailUtamaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return emailUtama.size
    }

    override fun onBindViewHolder(holder: EmailUtamaViewHolder, position: Int) {
        val (username, mail, pProfile) = emailUtama[position]
        holder.username.text = username
        holder.mail.text = mail
        holder.pProfile.setImageResource(pProfile)
    }
}