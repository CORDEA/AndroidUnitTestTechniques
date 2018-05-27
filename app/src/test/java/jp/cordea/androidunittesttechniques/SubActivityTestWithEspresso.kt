package jp.cordea.androidunittesttechniques

import android.view.View
import androidx.test.annotation.UiThreadTest
import androidx.test.rule.ActivityTestRule
import com.google.common.truth.Truth
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SubActivityTestWithEspresso {

    @get:Rule
    val activityRule = ActivityTestRule(SubActivity::class.java, false, true)

    @Test
    @UiThreadTest
    fun getItems() {
        val activity = activityRule.activity
        Truth.assertThat(activity.items).isEmpty()
        activity.findViewById<View>(R.id.fab).performClick()
//        onView(withId(R.id.fab)).perform(click())
        Truth.assertThat(activity.items.size).isEqualTo(1)
        activity.findViewById<View>(R.id.fab).performClick()
        Truth.assertThat(activity.items.size).isEqualTo(2)
    }
}
