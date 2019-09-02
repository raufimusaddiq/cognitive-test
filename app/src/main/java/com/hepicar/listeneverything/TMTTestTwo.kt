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
import kotlinx.android.synthetic.main.fragment_tmttest_two.*
import kotlinx.android.synthetic.main.fragment_tmttest_two.view.*


class TMTTestTwo : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        const val NAME = "name"
        const val STATE = "state"

        fun newInstance(name: String, state : String): TMTTestTwo {
            val fragment = TMTTestTwo()

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
        val view:View = inflater!!.inflate(R.layout.fragment_tmttest_two, container, false)
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
        view.aa_test.setOnClickListener { view ->
            if (!boolA) {
                aa_test.setBackgroundResource(R.drawable.colorchange)
                boolA = true
                TMTAddData(System.currentTimeMillis(), 1)
            } else {
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }

        view.bb_test.setOnClickListener { view ->
            if (boolA && !boolB) {
                bb_test.setBackgroundResource(R.drawable.colorchange)
                boolB = true
                TMTAddData(System.currentTimeMillis(), 1)
            } else {
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }
        view.cc_test.setOnClickListener { view ->
            if (boolB && !boolC) {
                cc_test.setBackgroundResource(R.drawable.colorchange)
                boolC = true
                TMTAddData(System.currentTimeMillis(), 1)
            } else {
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }

        view.dd_test.setOnClickListener { view ->
            if (boolC && !boolD) {
                dd_test.setBackgroundResource(R.drawable.colorchange)
                boolD = true
                TMTAddData(System.currentTimeMillis(), 1)
            } else {
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }
        view.ee_test.setOnClickListener { view ->
            if (boolD && !boolE) {
                ee_test.setBackgroundResource(R.drawable.colorchange)
                boolE = true
                TMTAddData(System.currentTimeMillis(), 1)
            } else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.ff_test.setOnClickListener { view ->
            if (boolE && !boolF) {
                ff_test.setBackgroundResource(R.drawable.colorchange)
                boolF = true
                TMTAddData(System.currentTimeMillis(), 1)
            } else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.gg_test.setOnClickListener { view ->
            if (boolF && !boolG) {
                gg_test.setBackgroundResource(R.drawable.colorchange)
                boolG = true
                TMTAddData(System.currentTimeMillis(), 1)
            } else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.hh_test.setOnClickListener { view ->
            if (boolG && !boolH) {
                next_test_two.visibility = View.VISIBLE
                hh_test.setBackgroundResource(R.drawable.colorchange)
                boolH = true
                TMTAddData(System.currentTimeMillis(), 1)
            } else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.next_test_two.setOnClickListener { view ->
            val nama = arguments?.getString(NAME).toString()
            val state = arguments?.getString(STATE).toString()
            LocalStorage.saveToCSVTMT(tmtData, "testsecond_$state", nama)
            tmtData.clear()
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment_tmt, TMTTwo.newInstance(nama, state)).commit()
        }
    }

    fun TMTAddData(timestamp: Long, data: Int){
        var tmt = TMT(timestamp)
        tmt.value = data
        tmtData.add(tmt)
    }
}
