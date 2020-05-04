package ru.virushack.application.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class GreenhouseModel(
    val sensorCo2Value: List<Double>? = null,
    val waterTempValue: List<Double>? = null,
    val airTempValue: List<Double>? = null,
    val humidValue: List<Double>? = null,
    val waterDensityValue: Int? = null,
    val groupName: String? = null,
    val groundHumidValue: Double? = null,
    val dayLightValue: Int? = null,
    val dateList: SortedSet<Long>
): Parcelable