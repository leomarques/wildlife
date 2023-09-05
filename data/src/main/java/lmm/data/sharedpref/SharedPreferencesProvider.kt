package lmm.data.sharedpref

import android.content.SharedPreferences

interface SharedPreferencesProvider {
    fun provide(): SharedPreferences
}
