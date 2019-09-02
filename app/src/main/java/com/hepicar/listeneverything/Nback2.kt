package com.hepicar.listeneverything

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hepicar.listeneverything.model.NBack
import com.hepicar.listeneverything.repository.LocalStorage
import kotlinx.android.synthetic.main.fragment_nback2.*
import kotlinx.android.synthetic.main.fragment_nback2.view.*
import kotlinx.android.synthetic.main.fragment_nback2.view.txtNBack2


private val TASK_TRAINING = arrayOf("A", "Q", "5", "A", "Q", "7", "A", "D", "7", "7")
private val TASK_1 = arrayOf("T", "L", "H", "C", "H", "O", "C", "Q", "L", "C", "K", "L", "H", "C", "Q", "T", "R", "R", "K", "C", "H", "R", "H", "L", "H", "H", "M", "R", "M", "T", "R", "T", "H", "Q", "S", "T", "S", "R", "T", "R", "R", "J", "N", "N", "F", "F", "F", "C", "C", "F", "H", "S", "S", "L", "L", "L", "W", "N", "C", "Q")
private val TASK_2 = arrayOf("L", "H", "S", "L", "K", "S", "S", "K", "A", "L", "K", "P", "R", "E", "L", "H", "S", "L", "H", "S", "S", "T", "S", "S", "E", "T", "T", "E", "T", "H", "R", "P", "H", "H", "T", "P", "H", "K", "A", "A", "K", "A", "H", "H", "H", "T", "L", "H", "L", "R", "K", "A", "I", "K", "A", "K", "K", "L", "T", "P", "L", "T", "P", "E", "P", "E", "P", "A", "H", "P", "P", "K", "A", "S", "K", "A", "S", "L", "H", "L", "H", "K", "H", "H", "A", "P", "E", "A", "L", "A", "A", "L", "E", "H", "L", "K", "H", "P", "P", "R", "L", "K", "T", "T")
private val TASK_3 = arrayOf("T", "L", "H", "C", "H", "O", "C", "Q", "L", "C", "K", "L", "H", "C", "Q", "T", "R", "R", "K", "C", "H", "R", "H", "L", "H", "H", "M", "R", "M", "T", "R", "T", "H", "Q", "S", "T", "S", "R", "T", "R", "R", "J", "N", "N", "F", "F", "F", "C", "C", "F", "H", "S", "S", "L", "L", "L", "W", "N", "C", "Q", "L", "H", "S", "L", "K", "S", "S", "K", "A", "L", "K", "P", "R", "E", "L", "H", "S", "L", "H", "S", "S", "T", "S", "S", "E", "T", "T", "E", "T", "H", "R", "P", "H", "H", "T", "P", "H", "K", "A", "A", "K", "A", "H", "H", "H", "T", "L", "H", "L", "R", "K", "A", "I", "K", "A", "K", "K", "L", "T", "P", "L", "T", "P", "E", "P", "E", "P", "A", "H", "P", "P", "K", "A", "S", "K", "A", "S", "L", "H", "L", "H", "K", "H", "H", "A", "P", "E", "A", "L", "A", "A", "L", "E", "H", "L", "K", "H", "P", "P", "R", "L", "K", "T", "T")

class NBack2 : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        const val NAME = "name"
        const val STATE = "state"

        fun newInstance(name: String, state : String): NBack2 {
            val fragment = NBack2()

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
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_nback2, container, false)
        val nama = arguments?.getString(TMTOne.NAME).toString()
        val state = arguments?.getString(TMTOne.STATE).toString()
        Calculate(view, nama, state)
        return view
    }

    var NBackData : MutableList<NBack> = ArrayList()

    private fun Calculate(view:View, name: String, state: String){

        var counter = 0
        var right_counter = 0
        var Nback_Task = emptyArray<String>()

        when (state){
            "0" -> Nback_Task = TASK_TRAINING
            "1" -> Nback_Task = TASK_1
            "2" -> Nback_Task = TASK_2
            "3" -> Nback_Task = TASK_3
        }

        view.txtNBack2.text = Nback_Task[counter]

        view.btnNBackTrue2.setOnClickListener { view ->
            if(counter < 2){
                counter++
                txtNBack2.text = Nback_Task[counter]
            } else {
                val temp = txtNBack2.text
                if (temp == Nback_Task[counter - 2]) {
                    //TODO : Simpan Benar
                    right_counter++
                    counter++
                    txtRight2.text = "Jumlah Benar : $right_counter"
                    NBackAddData(System.currentTimeMillis(), 1)
                } else {
                    //TODO : Simpan Salah
                    counter++
                    NBackAddData(System.currentTimeMillis(), -1)
                }
            }
            if(counter == Nback_Task.size){
                //TODO : Fragment Selanjutnya
                if(state == "0"){
                    LocalStorage.saveToCSVNBack(NBackData, "nback2_training", name)
                } else{
                    LocalStorage.saveToCSVNBack(NBackData, "nback2_$state", name)
                }
                NBackData.clear()
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment_nback, NBack3.newInstance(name, state)).commit()
            } else {
                txtNBack2.text = Nback_Task[counter]
            }
        }

        view.btnNBackFalse2.setOnClickListener { view ->
            if(counter < 2){
                counter++
                txtNBack2.text = Nback_Task[counter]
            } else {
                val temp = txtNBack2.text
                if (temp != Nback_Task[counter - 2]) {
                    //TODO : Simpan Benar
                    right_counter++
                    counter++
                    txtRight2.text = "Jumlah Benar : $right_counter"
                    NBackAddData(System.currentTimeMillis(), 1)
                } else {
                    //TODO : Simpan Salah
                    counter++
                    NBackAddData(System.currentTimeMillis(), -1)
                }
            }
            if(counter == Nback_Task.size){
                //TODO : Fragment Selanjutnya
                if(state == "0"){
                    LocalStorage.saveToCSVNBack(NBackData, "nback2_training", name)
                } else{
                    LocalStorage.saveToCSVNBack(NBackData, "nback2_$state", name)
                }
                NBackData.clear()
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.fragment_nback, NBack3.newInstance(name, state)).commit()
            } else {
                txtNBack2.text = Nback_Task[counter]
            }
        }
    }

    private fun NBackAddData(timestamp: Long, data: Int){
        var nback = NBack(timestamp)
        nback.value = data
        NBackData.add(nback)
    }
}
