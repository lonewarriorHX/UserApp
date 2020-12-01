package com.example.finalapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.finalapplication.onboarding.FormPage
import com.example.finalapplication.onboarding.NewsPage


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val view =inflater.inflate(R.layout.fragment_home, container, false)
        val btn = view.findViewById<View>(R.id.text1) as TextView
        val btn2 = view.findViewById<View>(R.id.gambarrenov) as ImageView
        val btn3 = view.findViewById<View>(R.id.gambarbangun) as ImageView
        val btn4 = view.findViewById<View>(R.id.gambararsi) as ImageView
        val btn5 = view.findViewById<View>(R.id.gambarinter) as ImageView
        btn.setOnClickListener{
            requireActivity().run{
                startActivity(Intent(this, NewsPage::class.java))
                finish()
            }
        }
        btn2.setOnClickListener{
            requireActivity().run{
                startActivity(Intent(this, FormPage::class.java))
                finish()
            }
        }
        btn3.setOnClickListener{
            requireActivity().run{
                startActivity(Intent(this, FormPage::class.java))
                finish()
            }
        }
        btn4.setOnClickListener{
            requireActivity().run{
                startActivity(Intent(this, FormPage::class.java))
                finish()
            }
        }
        btn5.setOnClickListener{
            requireActivity().run{
                startActivity(Intent(this, FormPage::class.java))
                finish()
            }
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}