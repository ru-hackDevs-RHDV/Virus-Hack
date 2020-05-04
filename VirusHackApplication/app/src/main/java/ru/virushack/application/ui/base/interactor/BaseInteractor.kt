package ru.virushack.application.ui.base.interactor

import ru.virushack.application.network.ApiHelper


open class BaseInteractor(): MvpInteractor {

    lateinit var apiHelper: ApiHelper

    constructor(apiHelper: ApiHelper): this() {
        this.apiHelper = apiHelper
    }
}