package ru.virushack.application.ui.details.presenter

import ru.virushack.application.models.GreenhouseModel
import ru.virushack.application.ui.base.presenter.MvpPresenter
import ru.virushack.application.ui.details.interactor.GreenhouseDetailsMvpInteractor
import ru.virushack.application.ui.details.view.GreenhouseDetailsView

interface GreenhouseDetailsMvpPresenter <V: GreenhouseDetailsView, I: GreenhouseDetailsMvpInteractor> : MvpPresenter<V, I> {

    fun prepareData(model: GreenhouseModel?)

}