package ru.virushack.application.ui.splash

import dagger.Module
import dagger.Provides
import ru.virushack.application.ui.splash.interactor.SplashInteractor
import ru.virushack.application.ui.splash.interactor.SplashMvpInteractor
import ru.virushack.application.ui.splash.presenter.SplashMvpPresenter
import ru.virushack.application.ui.splash.presenter.SplashPresenter
import ru.virushack.application.ui.splash.view.SplashMvpView

@Module
class SplashActivityModule {

    @Provides
    fun providesSplashInteractor(interactor: SplashInteractor): SplashMvpInteractor = interactor

    @Provides
    fun providesSplashPresenter(presenter: SplashPresenter<SplashMvpView, SplashMvpInteractor>):
        SplashMvpPresenter<SplashMvpView, SplashMvpInteractor> = presenter

}