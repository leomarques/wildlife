package lmm.data.sharedpref

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesImpl(private val context: Context) : SharedPreferencesProvider {
    override fun provide(): SharedPreferences {
        return context.getSharedPreferences("", Context.MODE_PRIVATE)
    }
}
