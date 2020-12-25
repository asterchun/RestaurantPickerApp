package com.example.restaurantpicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openQuiz(view: View) {
        // start new activity for quiz
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }

    fun openFriends(view: View) {
        // start new activity for swipe
        val intent = Intent(this, FriendsActivity::class.java)
        startActivity(intent)
    }

    fun openUserInput(view: View) {
        // start new activity for user input
        val intent = Intent(this, UserInputActivity::class.java)
        startActivity(intent)
    }
}