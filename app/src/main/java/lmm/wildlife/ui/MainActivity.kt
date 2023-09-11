package lmm.wildlife.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import lmm.wildlife.ui.animals.AnimalsView
import lmm.wildlife.ui.setup.SetupView
import lmm.wildlife.ui.theme.WildlifeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WildlifeTheme {
                SetupView {
                    AnimalsView()
                }
            }
        }
    }
}
