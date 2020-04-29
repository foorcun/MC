package com.example.cumaver10


import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_control_send.*

/**
 * A simple [Fragment] subclass.
 */
class ControlSendFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_control_send, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        send_button_fragment_control_send.setOnClickListener {
            Log.d("ControlSendFragment", "send buttona tıklandı..")
            
            sendSMS()
        }


    }

    private fun sendSMS() {
        //sms göndercez
        //first check for permission
        val permission: Int = chechSMSPermission()

        if (permission == 0) {

            Log.d("ControlSendFragment", "sms permission yok")

            return
        }


    }

    private fun chechSMSPermission(): Int {

        val i = 0
        return i
    }


}
