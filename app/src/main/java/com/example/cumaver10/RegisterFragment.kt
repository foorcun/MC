package com.example.cumaver10


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment(), View.OnClickListener{
    lateinit var navControler: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navControler = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.loginfragment_register_button).setOnClickListener (this)
        view.findViewById<TextView>(R.id.loginfragment_alreadyhaveanaccount_edittext).setOnClickListener (this)



    }

    override fun onClick(v:View?){
        Log.d("RegisterFragmentLog","registerden home gitmek")
        when(v!!.id){

            R.id.loginfragment_register_button -> {
                navControler!!.navigate(R.id.action_registerFragment_to_homeFragment)
            }
            R.id.loginfragment_alreadyhaveanaccount_edittext -> navControler!!.navigate(R.id.action_registerFragment_to_alreadyHaveAnAccountFragment)

        }


    }
}
