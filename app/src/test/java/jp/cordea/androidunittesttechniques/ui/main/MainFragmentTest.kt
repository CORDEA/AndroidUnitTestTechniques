package jp.cordea.androidunittesttechniques.ui.main

import android.widget.Button
import android.widget.TextView
import com.google.common.truth.Truth
import jp.cordea.androidunittesttechniques.R
import jp.cordea.androidunittesttechniques.buildTestActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner::class)
class MainFragmentTest {

    private lateinit var fragment: MainFragment

    @Before
    fun setUp() {
        fragment = buildTestActivity<MainFragment>()
                .setup()
                .get()
                .getFragment()
    }

    @Test
    fun test() {
        val view = fragment.view!!
        val text = view.findViewById<TextView>(R.id.message)
        Truth.assertThat(text.text).isEqualTo("")
        view.findViewById<Button>(R.id.button).performClick()
        Truth.assertThat(text.text).isEqualTo("1")
        view.findViewById<Button>(R.id.button).performClick()
        Truth.assertThat(text.text).isEqualTo("2")
    }
}
