package jp.cordea.androidunittesttechniques.ui.main

import com.google.common.truth.Truth
import jp.cordea.androidunittesttechniques.DarknessUtils
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.Implementation
import org.robolectric.annotation.Implements
import org.robolectric.shadow.api.Shadow

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner::class)
class MainViewModelTest {

    private val viewModel = MainViewModel()

    @Test
    @Config(shadows = [ShadowDarknessUtils::class])
    fun addSecret() {
        val shadow = Shadow.extract<ShadowDarknessUtils>(DarknessUtils)
        Truth.assertThat(shadow.secrets).isEmpty()
        viewModel.addSecret(0)
        Truth.assertThat(shadow.secrets.size).isEqualTo(1)
        viewModel.addSecret(0)
        Truth.assertThat(shadow.secrets.size).isEqualTo(2)
    }

    @Implements(DarknessUtils::class)
    class ShadowDarknessUtils {
        val secrets = mutableListOf<Int>()

        @Implementation
        fun addSecret(secret: Int) {
            secrets.add(secret)
        }
    }
}
