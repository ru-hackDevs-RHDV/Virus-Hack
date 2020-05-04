package ru.virushack.application.ui.details

import dagger.Module
import dagger.Provides
import ru.virushack.application.ui.details.interactor.GreenhouseDetailsInteractor
import ru.virushack.application.ui.details.interactor.GreenhouseDetailsMvpInteractor
import ru.virushack.application.ui.details.presenter.GreenhouseDetailsMvpPresenter
import ru.virushack.application.ui.details.presenter.GreenhouseDetailsPresenter
import ru.virushack.application.ui.details.view.GreenhouseDetailsView

@Module
class GreenhouseDetailsModule {

    @Provides
    fun provideInteractor(impl: GreenhouseDetailsInteractor): GreenhouseDetailsMvpInteractor = impl

    @Provides
    fun providePresenter(impl: GreenhouseDetailsPresenter<GreenhouseDetailsView, GreenhouseDetailsMvpInteractor>):
        GreenhouseDetailsMvpPresenter<GreenhouseDetailsView, GreenhouseDetailsMvpInteractor> = impl

}