package ru.virushack.application.ui.splash.view

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash.*
import ru.virushack.application.R
import ru.virushack.application.ui.base.view.BaseActivity
import ru.virushack.application.ui.list.view.GreenhouseListActivity
import ru.virushack.application.ui.splash.interactor.SplashMvpInteractor
import ru.virushack.application.ui.splash.presenter.SplashMvpPresenter
import yanzhikai.textpath.PathAnimatorListener
import javax.inject.Inject

class SplashActivity: BaseActivity(R.layout.activity_splash), SplashMvpView {

    @Inject
    lateinit var presenter: SplashMvpPresenter<SplashMvpView, SplashMvpInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
        tv_animated.apply {
            startAnimation(0f, 1f)
            setAnimatorListener(object: PathAnimatorListener() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    startActivity(Intent(this@SplashActivity, GreenhouseListActivity::class.java)
                        .apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        })
                }
            })
        }

    }


}