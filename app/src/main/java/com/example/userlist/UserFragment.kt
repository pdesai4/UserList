package com.example.userlist

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.net.HttpURLConnection
import java.net.URL

class UserFragment: Fragment() {

    private lateinit var textView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.user_text)

        fetchUser()
    }

    private fun fetchUser() {
        Thread {
            val url = URL("https://api.example.com/users")
            val connection = url.openConnection() as HttpURLConnection

            val result = connection.inputStream
                .bufferedReader()
                .readText()

            activity?.runOnUiThread {
                textView.text = result.toString()
            }
        }.start()
    }
}