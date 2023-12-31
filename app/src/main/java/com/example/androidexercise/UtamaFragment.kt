package com.example.androidexercise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UtamaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UtamaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: EmailUtamaAdapter
    private lateinit var rView: RecyclerView
    private val mailArrayList = ArrayList<EmailUtamaDataClass>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_utama, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UtamaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UtamaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        rView = view.findViewById(R.id.rv_email_utama)
        rView.layoutManager = layoutManager
        rView.setHasFixedSize(true)
        adapter = EmailUtamaAdapter(mailArrayList)
        rView.adapter = adapter
    }

    private fun dataInitialize(): ArrayList<EmailUtamaDataClass>{
        val username = resources.getStringArray(R.array.username)
        val mail = resources.getStringArray(R.array.mail)
        val pProfile = resources.obtainTypedArray(R.array.pProfile)
        for (i in username.indices){
            val userName = EmailUtamaDataClass(
                username[i],
                mail[i],
                pProfile.getResourceId(i, -1)
            )
            mailArrayList.add(userName)
        }
        return mailArrayList
    }
}