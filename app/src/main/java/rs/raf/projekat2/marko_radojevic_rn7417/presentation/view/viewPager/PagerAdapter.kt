package rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.fragments.PisanjeBeleskiFragment
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.fragments.PisanjeStatistikeFragment
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.fragments.RasproredCasovaFragment

class PagerAdapter (fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 3
        const val FRAGMENT_1 = 0
        const val FRAGMENT_2 = 1
        const val FRAGMENT_3 = 2
    }


    override fun getItem(position: Int): Fragment {
        return when(position){
            FRAGMENT_1 -> RasproredCasovaFragment()
            FRAGMENT_2 -> PisanjeBeleskiFragment()
            else -> PisanjeStatistikeFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            FRAGMENT_1 -> "1"
            FRAGMENT_2 -> "2"
            else -> "3"
        }
    }

}