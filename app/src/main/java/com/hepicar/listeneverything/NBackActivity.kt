package com.hepicar.listeneverything

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.inputmethod.EditorInfo
import kotlinx.android.synthetic.main.activity_nback.*

class NBackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nback)

        val NbackTestDetail = TestDetail()
        val manager = supportFragmentManager;
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_nback, NbackTestDetail)
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

    fun onClickedStartButtonNBack(view: View){
        val startINtent = Intent(this,ForegroundService::class.java)
        if (!ForegroundService.isRunning){
            startINtent.action = Constants.ACTION.STARTFOREGROUND_ACTION
            txt_name_nback.onEditorAction(EditorInfo.IME_ACTION_DONE)

            val text = txt_name_nback.text.toString()
            txt_name_nback.isEnabled = false
            val fragment = RestFragment.newInstance(text, "0")
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_nback, fragment)
            transaction.commit()

        }else{
            startINtent.action = Constants.ACTION.STOPFOREGROUND_ACTION
        }
        startService(startINtent)

        start_button_nback.text = "wait..."
        Handler().postDelayed({
            updateButton()
        },1000)

    }

    private fun updateButton() {
        var text = if (ForegroundService.isRunning) "STOP" else "START"
        start_button_nback.text =text
    }
}
