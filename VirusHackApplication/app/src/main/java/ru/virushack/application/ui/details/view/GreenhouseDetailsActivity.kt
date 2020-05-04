package ru.virushack.application.ui.details.view

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlinx.android.synthetic.main.activity_greenhouse_details.*
import ru.virushack.application.R
import ru.virushack.application.ui.base.view.BaseActivity
import ru.virushack.application.ui.details.interactor.GreenhouseDetailsMvpInteractor
import ru.virushack.application.ui.details.presenter.GreenhouseDetailsMvpPresenter
import ru.virushack.application.ui.list.view.GreenhouseListActivity.Companion.ARG_MODEL
import javax.inject.Inject

class GreenhouseDetailsActivity : BaseActivity(R.layout.activity_greenhouse_details), GreenhouseDetailsView {

    @Inject
    lateinit var presenter: GreenhouseDetailsMvpPresenter<GreenhouseDetailsView, GreenhouseDetailsMvpInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
        presenter.prepareData(intent.getParcelableExtra(ARG_MODEL))
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        var isLightOn = true
        ic_light.setOnClickListener {
            if (isLightOn) {
                ic_light.background = getDrawable(R.drawable.ic_light_off)
                isLightOn = false
            } else {
                ic_light.background = getDrawable(R.drawable.ic_light_on)
                isLightOn = true
            }
        }
    }

    override fun showGroundHumidGraph(list: LineGraphSeries<DataPoint>) {
        humid_graph.apply {
            title = getString(R.string.air)
            addSeries(list)
            gridLabelRenderer.labelFormatter = DateAsXAxisLabelFormatter(this@GreenhouseDetailsActivity)
            gridLabelRenderer.numHorizontalLabels = 2
        }
    }

    override fun showCo2Graph(list: LineGraphSeries<DataPoint>) {
        co2_graph.apply {
            title = "Количество CO2"
            addSeries(list)
            gridLabelRenderer.labelFormatter = DateAsXAxisLabelFormatter(this@GreenhouseDetailsActivity)
            gridLabelRenderer.numHorizontalLabels = 2
        }
    }

    override fun showWaterTempGraph(list: LineGraphSeries<DataPoint>) {
        water_temp_graph.apply {
            title = "Температура воды"
            addSeries(list)
            gridLabelRenderer.labelFormatter = DateAsXAxisLabelFormatter(this@GreenhouseDetailsActivity)
            gridLabelRenderer.numHorizontalLabels = 2
        }
    }

    override fun showAirTempGraph(list: LineGraphSeries<DataPoint>) {
        air_temp_graph.apply {
            title = "Температура воздуха"
            addSeries(list)
            gridLabelRenderer.labelFormatter = DateAsXAxisLabelFormatter(this@GreenhouseDetailsActivity)
            gridLabelRenderer.numHorizontalLabels = 2
        }
    }

    override fun showSpinner(list: List<String>, position: Int) {
        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinner.setSelection(position)
    }

}