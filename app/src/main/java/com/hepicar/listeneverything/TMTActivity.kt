package com.hepicar.listeneverything

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import com.hepicar.listeneverything.model.HrmBlueSensor
import com.hepicar.listeneverything.model.HrmGreenSensor
import com.hepicar.listeneverything.model.HrmIrSensor
import com.hepicar.listeneverything.model.HrmRedSensor
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tmt.*
import kotlinx.android.synthetic.main.item_hrm.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class TMTActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tmt)

        val tmtTestOne = TestDetail()
        val manager = supportFragmentManager;
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_tmt, tmtTestOne)
        transaction.commit()

    }


    override fun onResume() {
        super.onResume()
        updateButton()
        //openCamera()
    }

    override fun onStop() {
        super.onStop()
    }

    fun onClickedStartButtonTMT(view: View){
        val startINtent = Intent(this,ForegroundService::class.java)
        if (!ForegroundService.isRunning){
            startINtent.action = Constants.ACTION.STARTFOREGROUND_ACTION
            txt_name.onEditorAction(EditorInfo.IME_ACTION_DONE)
            val text = txt_name.text.toString()
            val fragment = RestFragment.newInstance(text, "1")
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_tmt, fragment)
            transaction.commit()

        }else{
            startINtent.action = Constants.ACTION.STOPFOREGROUND_ACTION
        }
        startService(startINtent)

        start_button_tmt.text = "wait..."
        Handler().postDelayed({
            updateButton()
        },1000)

    }

    private fun updateButton() {
        var text = if (ForegroundService.isRunning) "STOP" else "START"
        start_button_tmt.text =text
    }

}
