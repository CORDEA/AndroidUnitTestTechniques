package jp.cordea.androidunittesttechniques

import android.view.View
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner::class)
class SubActivityTest {

    private lateinit var activity: SubActivity

    @Before
    fun setUp() {
        activity = Robolectric.buildActivity(SubActivity::class.java)
                .setup()
                .get()
    }

    @Test
    fun getItems() {
        Truth.assertThat(activity.items).isEmpty()
        activity.findViewById<View>(R.id.fab).performClick()
        Truth.assertThat(activity.items.size).isEqualTo(1)
        activity.findViewById<View>(R.id.fab).performClick()
        Truth.assertThat(activity.items.size).isEqualTo(2)
    }
}
