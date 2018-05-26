package jp.cordea.androidunittesttechniques

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import org.robolectric.android.controller.ActivityController
import org.robolectric.util.ReflectionHelpers

inline fun <reified F : Fragment> buildTestActivity(): ActivityController<FragmentTestActivity<F>> =
        ActivityController.of(FragmentTestActivity(F::class.java))

class FragmentTestActivity<F : Fragment>(
        private val fragmentClass: Class<F>
) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {

            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ReflectionHelpers.callConstructor(fragmentClass))
                    .commit()
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun getFragment(): F = supportFragmentManager.findFragmentById(R.id.container) as F
}
