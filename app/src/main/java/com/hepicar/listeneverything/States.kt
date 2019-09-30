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
import kotlinx.android.synthetic.main.fragment_states.*
import kotlinx.android.synthetic.main.fragment_states.view.*
import kotlinx.android.synthetic.main.fragment_states.view.progressBarState

@Suppress("UsePropertyAccessSyntax", "UNREACHABLE_CODE")
class States : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        const val NAME = "name"
        const val STATE = "state"
        const val NBACK = "nback"

        fun newInstance(name: String, state :String, nback:String): States{
            val fragment = States()

            val bundle = Bundle().apply {
                putString(NAME, name)
                putString(STATE, state)
                putString(NBACK, nback)
            }

            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater!!.inflate(R.layout.fragment_states, container, false)
        view.progressBarState.setProgress(0)
        view.progressBarState.setMax(100)
        timer.start()
        return view
    }


    val timer = object : CountDownTimer(5000, 1000){
        var i = 0
        var ProgressStatus = 0
        override fun onTick(millisUntilFinished: Long) {
            i++
            ProgressStatus = i*100/(5000/1000)
            progressBarState.setProgress(ProgressStatus)
        }

        override fun onFinish() {
            val name = arguments?.getString(NAME).toString()
            val state = arguments?.getString(STATE).toString()
            val nback = arguments?.getString(NBACK).toString()
            if (nback == "1") {
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment_nback, NBack2.newInstance(name, state)).commit()
            } else {
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment_nback, NBack3.newInstance(name, state)).commit()
            }
        }

    }
}
