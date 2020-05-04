package ru.virushack.application.ui.list.view

import ru.virushack.application.models.GreenhouseModel
import ru.virushack.application.ui.base.view.MvpView

interface GreenhouseListView : MvpView {

    fun showGreenHouses(data: List<GreenhouseModel>)

}