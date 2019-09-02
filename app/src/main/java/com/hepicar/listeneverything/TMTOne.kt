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
import kotlinx.android.synthetic.main.fragment_tmtone.*
import kotlinx.android.synthetic.main.fragment_tmtone.view.*


class TMTOne : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        const val NAME = "name"
        const val STATE = "state"

        fun newInstance(name: String, state : String): TMTOne {
            val fragment = TMTOne()

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
        val view:View = inflater!!.inflate(R.layout.fragment_tmtone, container, false)
        TMTView(view)
        view.progressBarTMTOne.progress = 0
        view.progressBarTMTOne.max = 100
        timer.start()
        return view
    }

    val timer = object : CountDownTimer(180000, 1000){
        var i = 0
        var ProgressStatus = 0
        override fun onTick(millisUntilFinished: Long) {
            i++
            ProgressStatus = i*100/(180000/1000)
            progressBarTMTOne.progress = ProgressStatus
        }

        override fun onFinish() {
            val nama = arguments?.getString(NAME).toString()
            val state = arguments?.getString(STATE).toString()
            LocalStorage.saveToCSVTMT(tmtData, "first_notFinished", nama)
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment_tmt, TMTTestTwo.newInstance(nama, state)).commit()
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
        view.a.setOnClickListener { view->
            if(!boolA){
                a.setBackgroundResource(R.drawable.colorchange)
                boolA = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else {
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }

        view.b.setOnClickListener { view->
            if (boolA&&!boolB) {
                b.setBackgroundResource(R.drawable.colorchange)
                boolB = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else{
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }

        view.c.setOnClickListener { view->
            if(boolB&&!boolC) {
                c.setBackgroundResource(R.drawable.colorchange)
                boolC = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else{
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }

        view.d.setOnClickListener { view->
            if(boolC&&!boolD) {
                d.setBackgroundResource(R.drawable.colorchange)
                boolD = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else{
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }
        view.e.setOnClickListener { view->
            if(boolD&&!boolE) {
                e.setBackgroundResource(R.drawable.colorchange)
                boolE = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.f.setOnClickListener { view->
            if (boolE&&!boolF) {
                f.setBackgroundResource(R.drawable.colorchange)
                boolF = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.g.setOnClickListener { view->
            if(boolF&&!boolG) {
                g.setBackgroundResource(R.drawable.colorchange)
                boolG = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.h.setOnClickListener { view->
            if (boolG&&!boolH) {
                h.setBackgroundResource(R.drawable.colorchange)
                boolH = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.i.setOnClickListener { view->
            if (boolH&&!boolI) {
                i.setBackgroundResource(R.drawable.colorchange)
                boolI = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.j.setOnClickListener { view->
            if (boolI&&!boolJ) {
                j.setBackgroundResource(R.drawable.colorchange)
                boolJ = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }


        view.k.setOnClickListener { view->
            if (boolJ&&!boolK) {
                k.setBackgroundResource(R.drawable.colorchange)
                boolK = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else{
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }

        view.l.setOnClickListener { view->
            if(boolK&&!boolL) {
                l.setBackgroundResource(R.drawable.colorchange)
                boolL = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else{
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }

        view.m.setOnClickListener { view->
            if(boolL&&!boolM) {
                m.setBackgroundResource(R.drawable.colorchange)
                boolM = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else{
                TMTAddData(System.currentTimeMillis(), -1)
            }
        }
        view.n.setOnClickListener { view->
            if(boolM&&!boolN) {
                n.setBackgroundResource(R.drawable.colorchange)
                boolN = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.o.setOnClickListener { view->
            if (boolN&&!boolO) {
                o.setBackgroundResource(R.drawable.colorchange)
                boolO = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.p.setOnClickListener { view->
            if(boolO&&!boolP) {
                p.setBackgroundResource(R.drawable.colorchange)
                boolP = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.q.setOnClickListener { view->
            if (boolP&&!boolQ) {
                q.setBackgroundResource(R.drawable.colorchange)
                boolQ = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.r.setOnClickListener { view->
            if (boolQ&&!boolR) {
                r.setBackgroundResource(R.drawable.colorchange)
                boolR = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.s.setOnClickListener { view->
            if (boolR&&!boolS) {
                s.setBackgroundResource(R.drawable.colorchange)
                boolS = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.t.setOnClickListener { view->
            if (boolS&&!boolT) {
                t.setBackgroundResource(R.drawable.colorchange)
                boolT = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.u.setOnClickListener { view->
            if (boolT&&!boolU) {
                u.setBackgroundResource(R.drawable.colorchange)
                boolU = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.v.setOnClickListener { view->
            if (boolU&&!boolV) {
                v.setBackgroundResource(R.drawable.colorchange)
                boolV = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.w.setOnClickListener { view->
            if (boolV&&!boolW) {
                w.setBackgroundResource(R.drawable.colorchange)
                boolW = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.ex.setOnClickListener { view->
            if (boolW&&!boolX) {
                ex.setBackgroundResource(R.drawable.colorchange)
                boolX = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }
        view.ye.setOnClickListener { view->
            if (boolX&&!boolY) {
                next_one.visibility = View.VISIBLE
                ye.setBackgroundResource(R.drawable.colorchange)
                boolY = true
                TMTAddData(System.currentTimeMillis(), 1)
            }
            else TMTAddData(System.currentTimeMillis(), -1)
        }

        view.next_one.setOnClickListener { view ->
            val nama = arguments?.getString(NAME).toString()
            val state = arguments?.getString(STATE).toString()
            LocalStorage.saveToCSVTMT(tmtData, "first_$state", nama)
            timer.cancel()
            tmtData.clear()
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment_tmt, TMTTestTwo.newInstance(nama,state)).commit()
        }
    }

    fun TMTAddData(timestamp: Long, data: Int){
        var tmt = TMT(timestamp)
        tmt.value = data
        tmtData.add(tmt)
    }
}
