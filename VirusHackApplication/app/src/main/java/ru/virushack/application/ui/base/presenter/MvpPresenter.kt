package ru.virushack.application.ui.base.presenter

import ru.virushack.application.ui.base.interactor.MvpInteractor
import ru.virushack.application.ui.base.view.MvpView

interface MvpPresenter<V: MvpView, I: MvpInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}