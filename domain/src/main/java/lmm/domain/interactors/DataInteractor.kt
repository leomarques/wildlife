package lmm.domain.interactors

import lmm.data.sharedpref.SharedPreferencesProvider

class DataInteractor(
    private val sharedPreferencesProvider: SharedPreferencesProvider
) {
    fun isFirstTime(): Boolean {
        return sharedPreferencesProvider.provide().getBoolean("isFirstTime", true)
    }

    fun saveNotFirstTime() {
        sharedPreferencesProvider.provide().edit().putBoolean("isFirstTime", false).apply()
    }
}
