package ru.virushack.application.ui.list.presenter

import io.reactivex.disposables.CompositeDisposable
import ru.virushack.application.ui.base.presenter.BasePresenter
import ru.virushack.application.ui.list.interactor.GreenhouseListMvpInteractor
import ru.virushack.application.ui.list.view.GreenhouseListView
import ru.virushack.application.util.SchedulerProvider
import javax.inject.Inject

class GreenhouseListPresenter<V: GreenhouseListView, I: GreenhouseListMvpInteractor> @Inject constructor(
    interactor: I,
    disposable: CompositeDisposable,
    schedulerProvider: SchedulerProvider
): BasePresenter<V, I>(
    interactor = interactor,
    compositeDisposable = disposable,
    schedulerProvider = schedulerProvider
), GreenhouseListMvpPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)
        loadList()
    }

    private fun loadList() {
        interactor?.let {
            getView()?.showGreenHouses(it.getGreenhouseList())
        }
    }

}