package com.example.restaurantpicker

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController


class UserInputActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_input)

        setupActionBarWithNavController(findNavController(R.id.userinput_fragment))

//        advancedOptionsButton();

    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.userinput_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun onSearch(view: View) {


    }

    fun advancedOptions(view: View) {

    }





//    fun advancedOptionsButton() {
//        var btn = findViewById(R.id.floatingActionButton);
//        btn.setOnClickListener(View.OnClickListener() {
//            override fun onClick(view: View) {
//                Intent intent = OptionsActivity.makeIntent(MainActivity.this);
//                startActivity(intent);
//            }
//        })
//    }
}