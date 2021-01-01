package com.example.restaurantpicker

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import kotlin.random.Random


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
        //get data from textviews and advanced settings
        //put into hashmap
        //call apiCall
        //apiCall will then either display error message or success
        val test = HashMap<String, String>()
        test["location"] = "berkeley"

        apiCall(test)
    }

    private fun apiCall(
            args : MutableMap<String, *>
            ) {
        if (args.isEmpty()) {
            return
        }
        if (!args.containsKey("location") && !args.containsKey("longitude") && !args.containsKey("latitude")) {
            return
        }
        val urlBuilder = Uri.Builder()
        urlBuilder.apply{
            scheme("https")
            authority("api.yelp.com")
            appendPath("v3")
            appendPath("businesses")
            appendPath("search")

            for (key in args.keys) {
                appendQueryParameter(key, args[key].toString())
            }

            build()
        }
        val url = urlBuilder.toString()
        val request = object : JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                val listOfRestaurants = response.getJSONArray("businesses")
                if (listOfRestaurants.length() == 0) {

                } else {
                    val randNum = Random(System.currentTimeMillis()).nextInt(listOfRestaurants.length())
                    val restaurant = listOfRestaurants.getJSONObject(randNum)
                    displayResult(restaurant)
                }

            },
            Response.ErrorListener { error ->
                Log.d("error", error.toString())
            }) {
            override fun getHeaders() : MutableMap<String, String> {
                var headers = HashMap<String, String> ()
                headers.put("Authorization", "Bearer pMyU4lwJqoTts45HfM_Usp6iD1xXxTDbIOiks_kNt-Z-RsQbWL_Kmprl_pm0Ufni90tDzCGCO-JgNFPOI53fYuYGa5xaczSpAAy0lJZCEtnE_jjvIiptf2pGh9LrX3Yx")
                return headers
            }
        }

        val queue = Volley.newRequestQueue(this)
        queue.add(request)
    }

    private fun displayResult(restaurant: JSONObject?) {
        //launch some new display with restaurant details
        //use restaurant.getString or get___ to get attributes from restaurant object depending on type
        Log.d("success", restaurant.toString())
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