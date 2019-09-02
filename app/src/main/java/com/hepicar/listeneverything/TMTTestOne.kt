package com.hepicar.listeneverything

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hepicar.listeneverything.model.TMT
import com.hepicar.listeneverything.repository.LocalStorage
import kotlinx.android.synthetic.main.fragment_tmttest_one.*
import kotlinx.android.synthetic.main.fragment_tmttest_one.view.*


class TMTTestOne : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        const val NAME = "name"
        const val STATE = "state"

        fun newInstance(name: String, state : String): TMTTestOne {
            val fragment = TMTTestOne()

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
        val view:View = inflater!!.inflate(R.layout.fragment_tmttest_one, container, false)
        TMTView(view)
        return view
    }

    private var boolA = false
    private var boolB = false
    private var boolC = false
    private var boolD = false
    private var boolE = false
    private var boolF = false
    private var boolG = false
    private var boolH = false

    var tmtData: MutableList<TMT> = ArrayList()

    fun TMTView(view:View) {
        view.a_test.setOnClickListener { view ->
            if (!boolA) {
                a_test.setBackgroundResource(R.drawable.colorchange)
                boolA = true
                TMTAddData(System.currentTimeMillis(), 1)
            } else {
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }

        view.b_test.setOnClickListener { view ->
            if (boolA && !boolB) {
                b_test.setBackgroundResource(R.drawable.colorchange)
                boolB = true
                TMTAddData(System.currentTimeMillis(), 1)
            } else {
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }
        view.c_test.setOnClickListener { view ->
            if (boolB && !boolC) {
                c_test.setBackgroundResource(R.drawable.colorchange)
                boolC = true
                TMTAddData(System.currentTimeMillis(), 1)
            } else {
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }

        view.d_test.setOnClickListener { view ->
            if (boolC && !boolD) {
                d_test.setBackgroundResource(R.drawable.colorchange)
                boolD = true
                TMTAddData(System.currentTimeMillis(), 1)
            } else {
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }
        view.e_test.setOnClickListener { view ->
            if (boolD && !boolE) {
                e_test.setBackgroundResource(R.drawable.colorchange)
                boolE = true
                TMTAddData(System.currentTimeMillis(), 1)
            } else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.f_test.setOnClickListener { view ->
            if (boolE && !boolF) {
                f_test.setBackgroundResource(R.drawable.colorchange)
                boolF = true
                TMTAddData(System.currentTimeMillis(), 1)
            } else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.g_test.setOnClickListener { view ->
            if (boolF && !boolG) {
                g_test.setBackgroundResource(R.drawable.colorchange)
                boolG = true
                TMTAddData(System.currentTimeMillis(), 1)
            } else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.h_test.setOnClickListener { view ->
            if (boolG && !boolH) {
                next_test_one.visibility = View.VISIBLE
                h_test.setBackgroundResource(R.drawable.colorchange)
                boolH = true
                TMTAddData(System.currentTimeMillis(), 1)
            } else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.next_test_one.setOnClickListener { view ->
            val nama = arguments?.getString(NAME).toString()
            val state = arguments?.getString(STATE).toString()
            LocalStorage.saveToCSVTMT(tmtData, "testfirst_$state", nama)
            tmtData.clear()
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment_tmt, TMTOne.newInstance(nama, state)).commit()
        }
    }

    fun TMTAddData(timestamp: Long, data: Int){
        var tmt = TMT(timestamp)
        tmt.value = data
        tmtData.add(tmt)
    }
}
