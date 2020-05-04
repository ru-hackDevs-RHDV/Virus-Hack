package ru.virushack.application.ui.splash.interactor

import ru.virushack.application.network.ApiHelper
import ru.virushack.application.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class SplashInteractor @Inject constructor(apiHelper: ApiHelper):
        BaseInteractor(apiHelper = apiHelper), SplashMvpInteractor {

}