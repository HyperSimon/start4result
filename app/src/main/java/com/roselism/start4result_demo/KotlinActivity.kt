package com.roselism.start4result_demo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.roselism.start4result.RoselismActivity

class KotlinActivity : RoselismActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, KotlinActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        val button = findViewById(R.id.button) as Button
        val javaButton = findViewById(R.id.java) as Button

        button.setOnClickListener {
            val intent = Intent(this, TargetActivity::class.java)
            startActivityForResult(intent, Constants.Main.REQUEST_CODE_4_DEMO) {
                Toast.makeText(this, it.getStringExtra(Constants.Target.ARG_DEMO), Toast.LENGTH_SHORT).show()
            }
        }

        javaButton.setOnClickListener {
            startActivity(Intent(this, JavaActivity::class.java))
            finish()
        }
    }
}
