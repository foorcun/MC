package com.example.cumaver10

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val REQUEST_SMS_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setpermission()
    }

    private fun setpermission() {

        val permission =
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS)

        if (permission != PackageManager.PERMISSION_GRANTED) {

            Log.d("Permission", "permission denied.")
        }

        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                android.Manifest.permission.SEND_SMS
            )
        ) {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("sms permission required..")
            builder.setTitle("Permission required")
            builder.setPositiveButton("OK")
            { dialog, which ->
                Log.d("Permission", "Clicked")
                makeRequest()

            }
            val dialog = builder.create()
            dialog.show()
        } else {
            makeRequest()
        }

    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(
            this, arrayOf(android.Manifest.permission.SEND_SMS),
            REQUEST_SMS_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_SMS_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Log.d("Permission","permission is denied by user")

                }
                else{
                    Log.d("Permission","permission has been granted by user")
                }
            }

        }
    }
}
