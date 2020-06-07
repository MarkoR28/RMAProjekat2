package rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rn7417.marko_radojevic_rn7417.R
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.viewPager.PagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class BottomNavigationActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initNavigation()
        initViewPager()
    }

    private fun initViewPager() {
        viewPager.adapter =
            PagerAdapter(
                supportFragmentManager
            )
    }

    private fun initNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_1 -> {viewPager.setCurrentItem(PagerAdapter.FRAGMENT_1, false)}
                R.id.navigation_2-> {viewPager.setCurrentItem(PagerAdapter.FRAGMENT_2, false)}
                R.id.navigation_3-> {viewPager.setCurrentItem(PagerAdapter.FRAGMENT_3, false)}
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}
