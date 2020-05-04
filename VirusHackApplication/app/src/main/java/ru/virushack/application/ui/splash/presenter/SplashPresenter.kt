package ru.virushack.application.ui.splash.presenter

import io.reactivex.disposables.CompositeDisposable
import ru.virushack.application.ui.base.presenter.BasePresenter
import ru.virushack.application.ui.splash.interactor.SplashMvpInteractor
import ru.virushack.application.ui.splash.view.SplashMvpView
import ru.virushack.application.util.SchedulerProvider
import javax.inject.Inject

class SplashPresenter<V: SplashMvpView, I: SplashMvpInteractor> @Inject constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable):
    BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
    SplashMvpPresenter<V, I> {


}