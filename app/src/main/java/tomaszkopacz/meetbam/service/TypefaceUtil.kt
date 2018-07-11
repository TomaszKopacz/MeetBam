package tomaszkopacz.meetbam.service

import android.content.Context
import android.graphics.Typeface
import android.os.Build




object TypefaceUtil {

    fun overrideFont(context: Context, defaultFontName: String, customFontName: String) {

        val customFontTypeface = Typeface.createFromAsset(context.assets, customFontName)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val map = HashMap<String, Typeface>()
            map.put("serif", customFontTypeface)

            try {
                val staticField = Typeface::class.java
                        .getDeclaredField("sSystemFontMap")
                staticField.isAccessible = true
                staticField.set(null, map)

            } catch (e: Exception) {
            }

        } else {
            try {
                val defaultFontTypefaceField = Typeface::class.java.getDeclaredField(defaultFontName)
                defaultFontTypefaceField.isAccessible = true
                defaultFontTypefaceField.set(null, customFontTypeface)

            } catch (e: Exception) {
            }

        }
    }
}