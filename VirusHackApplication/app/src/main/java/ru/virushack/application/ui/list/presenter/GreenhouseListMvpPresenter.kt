package ru.virushack.application.ui.list.presenter

import ru.virushack.application.ui.base.presenter.MvpPresenter
import ru.virushack.application.ui.list.interactor.GreenhouseListMvpInteractor
import ru.virushack.application.ui.list.view.GreenhouseListView

interface GreenhouseListMvpPresenter <V: GreenhouseListView, I: GreenhouseListMvpInteractor>:
    MvpPresenter<V, I>