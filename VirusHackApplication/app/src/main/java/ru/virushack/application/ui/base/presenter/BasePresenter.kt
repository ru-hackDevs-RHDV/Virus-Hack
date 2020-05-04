package ru.virushack.application.ui.base.presenter

import io.reactivex.disposables.CompositeDisposable
import ru.virushack.application.ui.base.interactor.MvpInteractor
import ru.virushack.application.ui.base.view.MvpView
import ru.virushack.application.util.SchedulerProvider

abstract class BasePresenter<V: MvpView, I: MvpInteractor> internal constructor(
    protected var interactor: I?,
    protected var schedulerProvider: SchedulerProvider,
    protected val compositeDisposable: CompositeDisposable): MvpPresenter<V, I> {


    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.clear()
        view?.hideProgress()
        view = null
    }

}