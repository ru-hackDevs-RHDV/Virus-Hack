package ru.virushack.application.ui.list.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_greenhouse.view.*
import ru.virushack.application.R
import ru.virushack.application.models.GreenhouseModel
import java.text.SimpleDateFormat
import java.util.*

class GreenhouseListRvAdapter (
    private val data: List<GreenhouseModel>,
    private val onItemClick: (GreenhouseModel) -> Unit): RecyclerView.Adapter<GreenhouseListRvAdapter.GreenhouseListViewHolder>() {

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: GreenhouseListViewHolder, position: Int) = holder.bind(data[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GreenhouseListViewHolder =
        GreenhouseListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_greenhouse,  parent, false))


    inner class GreenhouseListViewHolder(view: View): RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n", "SimpleDateFormat")
        fun bind(item: GreenhouseModel) {
            itemView.apply {
                setOnClickListener { onItemClick.invoke(item) }
                tv_last_update.text = "Обновлено ${SimpleDateFormat("HH:mm:ss").format(Date())}"
                tv_greenhouse_group.text = item.groupName
                tv_humid.text = "${item.humidValue?.last()}%"
                tv_water_temp.text = "${item.waterTempValue?.last()}°C"
                ground_humid.text = "${item.groundHumidValue}%"
                tv_air_temp.text = "${item.airTempValue?.last()}°C"
            }
        }
    }

}