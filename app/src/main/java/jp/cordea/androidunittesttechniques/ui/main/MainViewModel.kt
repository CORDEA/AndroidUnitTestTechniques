package jp.cordea.androidunittesttechniques.ui.main

import android.arch.lifecycle.ViewModel
import jp.cordea.androidunittesttechniques.DarknessUtils

class MainViewModel : ViewModel() {

    fun addSecret(secret: Int) {
        DarknessUtils.addSecret(secret)
    }
}
