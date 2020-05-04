package ru.virushack.application.ui.base.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection


abstract class BaseActivity(open var layout_id: Int): AppCompatActivity(), MvpView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout_id)
        performDI()
    }

    private fun performDI() = AndroidInjection.inject(this)

    override fun hideProgress() {}

    override fun showProgress() {}

}