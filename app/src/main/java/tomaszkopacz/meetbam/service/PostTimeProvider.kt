package tomaszkopacz.meetbam.service

import java.text.SimpleDateFormat
import java.util.*

object PostTimeProvider {

    const val FORMAT_MINS: String = "MINUTES"
    const val FORMAT_HOURS: String = "HOURS"
    const val FORMAT_DAYS: String = "DAYS"
    const val ERROR: String = "TIME ERROR"

    fun countTimeAgoInMin(timestamp: String): Float {

        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS")
        val timestampDate: Date
        val date = Date()
        var diff: Float

        simpleDateFormat.isLenient = false
        simpleDateFormat.format(date)

        timestampDate = simpleDateFormat.parse(timestamp)

        diff = (date.time - timestampDate.time).toFloat()
        diff /= (1000 * 60)

        return if (diff < 0) -1f else diff
    }

    fun getCustomTimeAgoText(timeAgo: Float, format: String): String {

        when (format){
            FORMAT_MINS ->
                return when {
                    timeAgo < 0 -> ERROR
                    timeAgo < 1f -> "at the moment"
                    timeAgo == 1f -> "1 minute ago"
                    timeAgo < 60f -> Math.round(timeAgo).toString() + "minutes ago"
                    timeAgo < 120f -> "1 hour ago"
                    timeAgo < 1440f -> Math.round(timeAgo / 60).toString() + " hours ago"
                    timeAgo < 2880f -> "1 day ago"
                    else -> Math.round(timeAgo / (60 * 24)).toString() + " days ago"
                }

            FORMAT_HOURS -> return ""

            FORMAT_DAYS -> return ""

            else -> return ERROR
        }
    }
}
