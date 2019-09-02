package com.hepicar.listeneverything

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_rest.*
import kotlinx.android.synthetic.main.fragment_rest.view.*


@Suppress("UsePropertyAccessSyntax", "UNREACHABLE_CODE")
class RestFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        const val NAME = "name"
        const val STATE = "state"

        fun newInstance(name: String, state :String): RestFragment {
            val fragment = RestFragment()

            val bundle = Bundle().apply {
                putString(NAME, name)
                putString(STATE, state)
            }

            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater!!.inflate(R.layout.fragment_rest, container, false)
        view.progressBarRest.setProgress(0)
        view.progressBarRest.setMax(100)
        timer.start()
        return view
    }

    val timer = object : CountDownTimer(60000, 1000){
        var i = 0
        var ProgressStatus = 0
        override fun onTick(millisUntilFinished: Long) {
            i++
            ProgressStatus = i*100/(60000/1000)
            progressBarRest.setProgress(ProgressStatus)
        }

        override fun onFinish() {
            val nama = arguments?.getString(NAME).toString()
            val state = arguments?.getString(STATE).toString()
            if(state=="4"){
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_nback, TestDetail.newInstance(nama)).commit()
            } else {
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_nback, NBack1.newInstance(nama, state)).commit()
            }
        }

    }
}
