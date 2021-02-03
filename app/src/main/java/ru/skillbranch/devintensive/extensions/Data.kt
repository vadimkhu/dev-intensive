package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(patten:String = "HH:mm:ss dd.MM.yy"): String {
    val dataFormat = SimpleDateFormat(patten, Locale("ru"))
    return dataFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND) : Date {
    var time = this.time
    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    return this
}

fun Date.humanizeDiff(date: Date = Date()) : String {
    val diff = abs(this.time -  date.time)
    val isPast = this.time < date.time

    return when {
        diff <= TimeUnits.SECOND.value -> "только что"
        diff <= TimeUnits.SECOND.value * 45 -> getTenseForm(
            "несколько секунд",
            isPast
        )
        diff <= TimeUnits.SECOND.value * 75 -> getTenseForm(
            "минуту",
            isPast
        )
        diff <= TimeUnits.MINUTE.value * 45 -> getTenseForm(
            TimeUnits.MINUTE.plural((diff / TimeUnits.MINUTE.value).toInt()),
            isPast
        )
        diff <= TimeUnits.MINUTE.value * 75 -> getTenseForm(
            "час",
            isPast
        )
        diff <= TimeUnits.HOUR.value * 22 -> getTenseForm(
            TimeUnits.HOUR.plural((diff / TimeUnits.HOUR.value).toInt()),
            isPast
        )
        diff <= TimeUnits.HOUR.value * 26 -> getTenseForm(
            "день",
            isPast
        )
        diff <= TimeUnits.DAY.value * 360 -> getTenseForm(
            TimeUnits.DAY.plural((diff / TimeUnits.DAY.value).toInt()),
            isPast
        )
        else -> if(isPast) "более года назад" else "более чем через год"
    }
}

fun getTenseForm(interval: String, isPast: Boolean): String {
    val prefix = if (isPast) "" else "через"
    val postfix = if (isPast) "назад" else ""
    return "$prefix $interval $postfix".trim()
}

fun getPluralForm(amount: Int, units: TimeUnits): String {
    val posAmount = abs(amount) % 100

    return when(posAmount){
        1 -> Plurals.ONE.get(units)
        in 2..4 -> Plurals.FEW.get(units)
        0, in 5..19 -> Plurals.MANY.get(units)
        else -> getPluralForm(posAmount % 10, units)
    }
}

enum class Plurals(private val second: String, private val minute: String, private val hour: String, private val day: String){
    ONE("секунду", "минуту", "час", "день"),
    FEW("секунды", "минуты", "часа", "дня"),
    MANY("секунд","минут", "часов", "дней");

    fun get(unit: TimeUnits): String {
        return when(unit) {
            TimeUnits.SECOND -> second
            TimeUnits.MINUTE -> minute
            TimeUnits.HOUR -> hour
            TimeUnits.DAY -> day
        }
    }
}

enum class TimeUnits(val value:Long){
    SECOND(1000L),
    MINUTE(60 * SECOND.value),
    HOUR(60 * MINUTE.value),
    DAY(24 * HOUR.value);

    /*
    Реализуй метод plural для всех перечислений TimeUnits следующего вида
    TimeUnits.SECOND.plural(value:Int) возвращающую значение в виде строки с праильно склоненной
    единицей измерения
Пример:
TimeUnits.SECOND.plural(1) //1 секунду
TimeUnits.MINUTE.plural(4) //4 минуты
TimeUnits.HOUR.plural(19) //19 часов
TimeUnits.DAY.plural(222) //222 дня
     */
    fun plural(value: Int): String{
        return "$value ${getPluralForm(value, this)}"
    }
}
