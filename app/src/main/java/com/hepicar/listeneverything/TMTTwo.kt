package com.hepicar.listeneverything

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hepicar.listeneverything.model.TMT
import com.hepicar.listeneverything.repository.LocalStorage
import kotlinx.android.synthetic.main.fragment_rest.*
import kotlinx.android.synthetic.main.fragment_tmttwo.*
import kotlinx.android.synthetic.main.fragment_tmttwo.view.*


class TMTTwo : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        const val NAME = "name"
        const val STATE = "state"

        fun newInstance(name: String, state : String): TMTTwo {
            val fragment = TMTTwo()

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
        val view:View = inflater!!.inflate(R.layout.fragment_tmttwo, container, false)
        TMTView(view)
        view.progressBarTMTTwo.progress = 0
        view.progressBarTMTTwo.max = 100
        timer.start()
        return view
    }

    val timer = object : CountDownTimer(180000, 1000){
        var i = 0
        var ProgressStatus = 0
        override fun onTick(millisUntilFinished: Long) {
            i++
            ProgressStatus = i*100/(180000/1000)
            progressBarTMTTwo.progress = ProgressStatus
        }

        override fun onFinish() {
            val nama = arguments?.getString(NAME).toString()
            val state = arguments?.getString(STATE).toString()
            LocalStorage.saveToCSVTMT(tmtData, "two_notFinished_$state", nama)
            when {
                state.equals("1") -> activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment_tmt, RestFragment.newInstance(nama, "2")).commit()
                state.equals("2") -> activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment_tmt, RestFragment.newInstance(nama, "3")).commit()
                else -> activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment_tmt, TestDetail()).commit()
            }
        }

    }

    private var boolA = false
    private var boolB = false
    private var boolC = false
    private var boolD = false
    private var boolE = false
    private var boolF = false
    private var boolG = false
    private var boolH = false
    private var boolI = false
    private var boolJ = false
    private var boolK = false
    private var boolL = false
    private var boolM = false
    private var boolN = false
    private var boolO = false
    private var boolP = false
    private var boolQ = false
    private var boolR = false
    private var boolS = false
    private var boolT = false
    private var boolU = false
    private var boolV = false
    private var boolW = false
    private var boolX = false
    private var boolY = false

    var tmtData: MutableList<TMT> = ArrayList()

    fun TMTView(view:View){
        view.aa.setOnClickListener { view->
            if(!boolA){
                aa.setBackgroundResource(R.drawable.colorchange)
                boolA = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else {
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }

        view.bb.setOnClickListener { view->
            if (boolA&&!boolB) {
                bb.setBackgroundResource(R.drawable.colorchange)
                boolB = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else{
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }

        view.cc.setOnClickListener { view->
            if(boolB&&!boolC) {
                cc.setBackgroundResource(R.drawable.colorchange)
                boolC = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else{
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }

        view.dd.setOnClickListener { view->
            if(boolC&&!boolD) {
                dd.setBackgroundResource(R.drawable.colorchange)
                boolD = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else{
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }
        view.ee.setOnClickListener { view->
            if(boolD&&!boolE) {
                ee.setBackgroundResource(R.drawable.colorchange)
                boolE = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.ff.setOnClickListener { view->
            if (boolE&&!boolF) {
                ff.setBackgroundResource(R.drawable.colorchange)
                boolF = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.gg.setOnClickListener { view->
            if(boolF&&!boolG) {
                gg.setBackgroundResource(R.drawable.colorchange)
                boolG = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.hh.setOnClickListener { view->
            if (boolG&&!boolH) {
                hh.setBackgroundResource(R.drawable.colorchange)
                boolH = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.ii.setOnClickListener { view->
            if (boolH&&!boolI) {
                ii.setBackgroundResource(R.drawable.colorchange)
                boolI = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.jj.setOnClickListener { view->
            if (boolI&&!boolJ) {
                jj.setBackgroundResource(R.drawable.colorchange)
                boolJ = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }


        view.kk.setOnClickListener { view->
            if (boolJ&&!boolK) {
                kk.setBackgroundResource(R.drawable.colorchange)
                boolK = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else{
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }

        view.ll.setOnClickListener { view->
            if(boolK&&!boolL) {
                ll.setBackgroundResource(R.drawable.colorchange)
                boolL = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else{
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }

        view.mm.setOnClickListener { view->
            if(boolL&&!boolM) {
                mm.setBackgroundResource(R.drawable.colorchange)
                boolM = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else{
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }
        view.nn.setOnClickListener { view->
            if(boolM&&!boolN) {
                nn.setBackgroundResource(R.drawable.colorchange)
                boolN = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.oo.setOnClickListener { view->
            if (boolN&&!boolO) {
                oo.setBackgroundResource(R.drawable.colorchange)
                boolO = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.pp.setOnClickListener { view->
            if(boolO&&!boolP) {
                pp.setBackgroundResource(R.drawable.colorchange)
                boolP = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.qq.setOnClickListener { view->
            if (boolP&&!boolQ) {
                qq.setBackgroundResource(R.drawable.colorchange)
                boolQ = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.rr.setOnClickListener { view->
            if (boolQ&&!boolR) {
                rr.setBackgroundResource(R.drawable.colorchange)
                boolR = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.ss.setOnClickListener { view->
            if (boolR&&!boolS) {
                ss.setBackgroundResource(R.drawable.colorchange)
                boolS = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.tt.setOnClickListener { view->
            if (boolS&&!boolT) {
                tt.setBackgroundResource(R.drawable.colorchange)
                boolT = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.uu.setOnClickListener { view->
            if (boolT&&!boolU) {
                uu.setBackgroundResource(R.drawable.colorchange)
                boolU = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.vv.setOnClickListener { view->
            if (boolU&&!boolV) {
                vv.setBackgroundResource(R.drawable.colorchange)
                boolV = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.ww.setOnClickListener { view->
            if (boolV&&!boolW) {
                ww.setBackgroundResource(R.drawable.colorchange)
                boolW = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.xx.setOnClickListener { view->
            if (boolW&&!boolX) {
                next_two.visibility = View.VISIBLE
                xx.setBackgroundResource(R.drawable.colorchange)
                boolX = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }

        view.next_two.setOnClickListener { view ->
            val nama = arguments?.getString(NAME).toString()
            val state = arguments?.getString(STATE).toString()
            LocalStorage.saveToCSVTMT(tmtData, "second_$state", nama)
            tmtData.clear()
            timer.cancel()
            when {
                state.equals("1") -> activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment_tmt, RestFragment.newInstance(nama, "2")).commit()
                state.equals("2") -> activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment_tmt, RestFragment.newInstance(nama, "3")).commit()
                else -> activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment_tmt, TestDetail()).commit()
            }
        }
    }

    fun TMTAddData(timestamp: Long, data: Int){
        var tmt = TMT(timestamp)
        tmt.value = data
        tmtData.add(tmt)
    }
}
