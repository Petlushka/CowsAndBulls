package com.example.user.cowsandbulls.views


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.user.cowsandbulls.R

class StatisticsFragment : Fragment() {


    companion object {

        fun newInstance() : StatisticsFragment {
            return StatisticsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }


}
