package com.example.restaurantpicker

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager



/**
 * A simple [Fragment] subclass.
 * Use the [UserInputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserInputFragment : Fragment() {
    // TODO: Rename and change types of parameters

    var tv_signature: TextView? = null
    var tv_reply: TextView? = null
    var tv_sync: TextView? = null
    var tv_notifications: TextView? = null
    var pb_volume: ProgressBar? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_input, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val fab: View? = getView()?.findViewById(R.id.fab_settings)
        if (fab != null) {
            fab.setOnClickListener {
                getView()?.findViewById<View>(R.id.editTextTextPostalAddress)?.visibility = View.GONE
                findNavController().navigate(R.id.action_userInputFragment_to_settingsFragment)
            }
        }
        tv_signature = getView()?.findViewById(R.id.tv_signature)
        tv_reply = getView()?.findViewById(R.id.tv_reply)
        tv_sync = getView()?.findViewById(R.id.tv_sync)
        tv_notifications = getView()?.findViewById(R.id.tv_notifications)
        pb_volume = getView()?.findViewById(R.id.pb_volume)
        settings()
    }


    @RequiresApi(Build.VERSION_CODES.N)
    private fun settings() {
        val sp = PreferenceManager.getDefaultSharedPreferences(context)

        val signature = sp.getString("signature", "")
        val defaultReplyAction = sp.getString("reply", "")
        val sync = sp.getBoolean("sync", true)
        val notifications = sp.getBoolean("notifications", true)
        val volume = sp.getInt("volume_notifications", 0)

        tv_signature?.text = "Signature: $signature"
        tv_reply?.text = "Default reply: $defaultReplyAction"
        tv_sync?.text = "Sync: $sync"
        tv_notifications?.text = "Disable notifications: $notifications"

        pb_volume?.setProgress(volume, true)

    }
}