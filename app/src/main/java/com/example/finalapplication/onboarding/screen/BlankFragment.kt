package com.example.finalapplication.onboarding.screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.finalapplication.DashboardActivity
import com.example.finalapplication.R
import com.example.finalapplication.onboarding.FormPage

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_blank, container, false)
        val btn5 = view.findViewById<View>(R.id.btn5) as TextView
        Handler().postDelayed({
            if(onBoardingFinished()){
                findNavController().navigate(R.id.action_blankFragment_to_mainActivity)
            }
            else{
                findNavController().navigate(R.id.action_blankFragment_to_viewPagerFragment)
            }
        }, 3000)

        // Inflate the layout for this fragment
        return view
    }

    private fun onBoardingFinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }
}