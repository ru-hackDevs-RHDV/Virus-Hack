package ru.virushack.application.ui.details.interactor

import ru.virushack.application.network.ApiHelper
import ru.virushack.application.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class GreenhouseDetailsInteractor @Inject constructor(apiHelper: ApiHelper): BaseInteractor(apiHelper), GreenhouseDetailsMvpInteractor