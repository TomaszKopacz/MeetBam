package tomaszkopacz.meetbam.service

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

object DateTimeCounter {

    const val FORMAT_MINUTES: String = "MINUTES"
    const val FORMAT_HOURS: String = "HOURS"
    const val FORMAT_DAYS: String = "DAYS"
    const val ERROR: String = "TIME ERROR"

    fun countTimeAgo(timestamp: String, unit: String): Float {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        simpleDateFormat.isLenient = false

        val timestampDate: Date
        val date = Date()

        try {
            timestampDate = simpleDateFormat.parse(timestamp)
            simpleDateFormat.format(date)

        } catch (e: Exception) {
            Log.e("MeetBam", "Cannot parse timestamp. Use format yyyy-MM-dd HH:mm:ss")
            return -1f
        }

        var diff = (date.time - timestampDate.time).toFloat()

        when (unit) {
            FORMAT_MINUTES -> {
                diff /= (1000 * 60)
            }
        }

        return if (diff < 0) -1f else diff
    }

    fun getTimeAgoText(timeAgo: Float, unit: String): String {

        when (unit){
            FORMAT_MINUTES ->
                return when {
                    timeAgo < 0 -> ERROR
                    timeAgo < 1f -> "at the moment"
                    timeAgo == 1f -> "1 minute ago"
                    timeAgo < 60f -> Math.round(timeAgo).toString() + " minutes ago"
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
