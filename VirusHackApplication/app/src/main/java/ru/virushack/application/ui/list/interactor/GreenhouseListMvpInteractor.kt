package ru.virushack.application.ui.list.interactor

import ru.virushack.application.models.GreenhouseModel
import ru.virushack.application.ui.base.interactor.MvpInteractor

interface GreenhouseListMvpInteractor : MvpInteractor {

    fun getGreenhouseList(): List<GreenhouseModel>

}