package ru.virushack.application.ui.splash.presenter

import ru.virushack.application.ui.base.presenter.MvpPresenter
import ru.virushack.application.ui.splash.interactor.SplashMvpInteractor
import ru.virushack.application.ui.splash.view.SplashMvpView

interface SplashMvpPresenter<V: SplashMvpView, I: SplashMvpInteractor>: MvpPresenter<V, I>