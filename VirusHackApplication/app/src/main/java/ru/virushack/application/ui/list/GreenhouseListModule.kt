package ru.virushack.application.ui.list

import dagger.Module
import dagger.Provides
import ru.virushack.application.ui.list.interactor.GreenhouseListInteractor
import ru.virushack.application.ui.list.interactor.GreenhouseListMvpInteractor
import ru.virushack.application.ui.list.presenter.GreenhouseListMvpPresenter
import ru.virushack.application.ui.list.presenter.GreenhouseListPresenter
import ru.virushack.application.ui.list.view.GreenhouseListView

@Module
class GreenhouseListModule {

    @Provides
    fun provideInteractor(impl: GreenhouseListInteractor): GreenhouseListMvpInteractor = impl

    @Provides
    fun providePresenter(impl: GreenhouseListPresenter<GreenhouseListView, GreenhouseListMvpInteractor>):
        GreenhouseListMvpPresenter<GreenhouseListView, GreenhouseListMvpInteractor> = impl

}