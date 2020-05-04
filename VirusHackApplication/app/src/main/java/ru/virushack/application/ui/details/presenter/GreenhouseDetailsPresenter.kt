package ru.virushack.application.ui.details.presenter

import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import io.reactivex.disposables.CompositeDisposable
import ru.virushack.application.models.GreenhouseModel
import ru.virushack.application.ui.base.presenter.BasePresenter
import ru.virushack.application.ui.details.interactor.GreenhouseDetailsMvpInteractor
import ru.virushack.application.ui.details.view.GreenhouseDetailsView
import ru.virushack.application.util.SchedulerProvider
import java.util.*
import javax.inject.Inject


class GreenhouseDetailsPresenter<V: GreenhouseDetailsView, I: GreenhouseDetailsMvpInteractor> @Inject constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable
): BasePresenter<V, I> (
    interactor = interactor,
    schedulerProvider = schedulerProvider,
    compositeDisposable = disposable
), GreenhouseDetailsMvpPresenter<V, I> {

    private val spinnerList = listOf("Редис", "Огурцы", "Помидоры")

    override fun prepareData(model: GreenhouseModel?) {
        val co2PointList = mutableListOf<DataPoint>()
        model?.dateList?.forEachIndexed { index, date -> co2PointList.add(DataPoint(Date(date), model.sensorCo2Value!![index])) }
        getView()?.showCo2Graph(LineGraphSeries(co2PointList.toTypedArray()))

        val waterTempPointList = mutableListOf<DataPoint>()
        model?.dateList?.forEachIndexed { index, date -> waterTempPointList.add(DataPoint(Date(date), model.waterTempValue!![index])) }
        getView()?.showWaterTempGraph(LineGraphSeries(waterTempPointList.toTypedArray()))

        val airTempPointList = mutableListOf<DataPoint>()
        model?.dateList?.forEachIndexed { index, date -> airTempPointList.add(DataPoint(Date(date), model.airTempValue!![index])) }
        getView()?.showAirTempGraph(LineGraphSeries(airTempPointList.toTypedArray()))

        val humidDataPointList = mutableListOf<DataPoint>()
        model?.dateList?.forEachIndexed { index, date -> humidDataPointList.add(DataPoint(Date(date), model.humidValue!![index])) }
        getView()?.showGroundHumidGraph(LineGraphSeries(humidDataPointList.toTypedArray()))

        getView()?.showSpinner(spinnerList, spinnerList.indexOf(model?.groupName))
    }

}
