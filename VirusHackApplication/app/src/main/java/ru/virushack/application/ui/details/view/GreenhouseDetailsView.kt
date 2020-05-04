package ru.virushack.application.ui.details.view

import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import ru.virushack.application.ui.base.view.MvpView

interface GreenhouseDetailsView : MvpView {

    fun showGroundHumidGraph(list: LineGraphSeries<DataPoint>)
    fun showCo2Graph(list: LineGraphSeries<DataPoint>)
    fun showWaterTempGraph(list: LineGraphSeries<DataPoint>)
    fun showAirTempGraph(list: LineGraphSeries<DataPoint>)
    fun showSpinner(list: List<String>, position: Int)

}