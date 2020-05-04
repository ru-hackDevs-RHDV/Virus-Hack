package ru.virushack.application.ui.list.interactor

import ru.virushack.application.models.GreenhouseModel
import ru.virushack.application.network.ApiHelper
import ru.virushack.application.ui.base.interactor.BaseInteractor
import java.util.concurrent.ThreadLocalRandom
import javax.inject.Inject
import kotlin.math.roundToLong

class GreenhouseListInteractor @Inject constructor(apiHelper: ApiHelper): BaseInteractor(apiHelper), GreenhouseListMvpInteractor {

    companion object {
        private const val ONE_DAY = 86400000
    }
    
    override fun getGreenhouseList(): List<GreenhouseModel> = listOf(
        GreenhouseModel(
            groupName = "Огурцы",
            sensorCo2Value = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(0.0, 1.0) * 100).roundToLong() / 10).toDouble()}.toList(),
            humidValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(0.0, 1.0) * 100).roundToLong() / 10).toDouble()}.toList(),
            airTempValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(25.0, 35.0) * 10).roundToLong() / 10).toDouble()}.toList(),
            waterTempValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(25.0, 35.0) * 10).roundToLong() / 10).toDouble()}.toList(),
            waterDensityValue = 1000,
            groundHumidValue = 35.1,
            dayLightValue = 12,
            dateList = LongArray(100) {
                ThreadLocalRandom.current().nextLong(System.currentTimeMillis() - ONE_DAY, System.currentTimeMillis())
            }.toSortedSet()),
        GreenhouseModel(
            groupName = "Помидоры",
            sensorCo2Value = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(0.0, 1.0) * 100).roundToLong() / 10).toDouble()}.toList(),
            humidValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(0.0, 1.0) * 100).roundToLong() / 10).toDouble()}.toList(),
            airTempValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(25.0, 35.0) * 10).roundToLong() / 10).toDouble()}.toList(),
            waterTempValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(25.0, 35.0) * 10).roundToLong() / 10).toDouble()}.toList(),
            waterDensityValue = 1000,
            groundHumidValue = 35.1,
            dayLightValue = 10,
            dateList = LongArray(100) {
                ThreadLocalRandom.current().nextLong(System.currentTimeMillis() - ONE_DAY, System.currentTimeMillis())
            }.toSortedSet()),
        GreenhouseModel(
            groupName = "Редис",
            sensorCo2Value = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(0.0, 1.0) * 100).roundToLong() / 10).toDouble()}.toList(),
            humidValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(0.0, 1.0) * 100).roundToLong() / 10).toDouble()}.toList(),
            airTempValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(25.0, 35.0) * 10).roundToLong() / 10).toDouble()}.toList(),
            waterTempValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(25.0, 35.0) * 10).roundToLong() / 10).toDouble()}.toList(),
            waterDensityValue = 1000,
            groundHumidValue = 36.1,
            dayLightValue = 12,
            dateList = LongArray(100) {
                ThreadLocalRandom.current().nextLong(System.currentTimeMillis() - ONE_DAY, System.currentTimeMillis())
            }.toSortedSet()),
        GreenhouseModel(
            groupName = "Помидоры",
            sensorCo2Value = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(0.0, 1.0) * 100).roundToLong() / 10).toDouble()}.toList(),
            humidValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(0.0, 1.0) * 100).roundToLong() / 10).toDouble()}.toList(),
            airTempValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(25.0, 35.0) * 10).roundToLong() / 10).toDouble()}.toList(),
            waterTempValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(25.0, 35.0) * 10).roundToLong() / 10).toDouble()}.toList(),
            waterDensityValue = 1000,
            groundHumidValue = 35.9,
            dayLightValue = 12,
            dateList = LongArray(100) {
                ThreadLocalRandom.current().nextLong(System.currentTimeMillis() - ONE_DAY, System.currentTimeMillis())
            }.toSortedSet()),
        GreenhouseModel(
            groupName = "Огурцы",
            sensorCo2Value = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(0.0, 1.0) * 100).roundToLong() / 10).toDouble()}.toList(),
            humidValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(0.0, 1.0) * 100).roundToLong() / 10).toDouble()}.toList(),
            airTempValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(25.0, 35.0) * 10).roundToLong() / 10).toDouble()}.toList(),
            waterTempValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(25.0, 35.0) * 10).roundToLong() / 10).toDouble()}.toList(),
            waterDensityValue = 1000,
            groundHumidValue = 36.8,
            dayLightValue = 12,
            dateList = LongArray(100) {
                ThreadLocalRandom.current().nextLong(System.currentTimeMillis() - ONE_DAY, System.currentTimeMillis())
            }.toSortedSet()),
        GreenhouseModel(
            groupName = "Редис",
            sensorCo2Value = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(0.0, 1.0) * 100).roundToLong() / 10).toDouble()}.toList(),
            humidValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(0.0, 1.0) * 100).roundToLong() / 10).toDouble()}.toList(),
            airTempValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(25.0, 35.0) * 10).roundToLong() / 10).toDouble()}.toList(),
            waterTempValue = DoubleArray(100) { ((ThreadLocalRandom.current().nextDouble(25.0, 35.0) * 10).roundToLong() / 10).toDouble()}.toList(),
            waterDensityValue = 1000,
            groundHumidValue = 29.1,
            dayLightValue = 8,
            dateList = LongArray(100) {
                ThreadLocalRandom.current().nextLong(System.currentTimeMillis() - ONE_DAY, System.currentTimeMillis())
            }.toSortedSet())
    )

}