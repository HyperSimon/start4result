package com.roselism.start4result

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import java.util.*

open class RoselismActivity : AppCompatActivity() {

    private val requestMap: ArrayList<Pair<Int, (data: Intent, resultCode: Int) -> Unit>> = ArrayList()

    fun startActivityForResult(intent: Intent, requestCode: Int, backData: (data: Intent, resultCode: Int) -> Unit) {
        this.startActivityForResult(intent, requestCode)
        requestMap.add(Pair(requestCode, backData))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        requestMap.forEach { pair ->
            if (pair.first == requestCode) {
                data?.let { pair.second.invoke(it, resultCode) }
            }
        }
    }
}
