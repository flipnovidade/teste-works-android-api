package uitls

import android.support.annotation.AnimRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import br.com.teste.call.R

class FragmentHelper {

    init{
    }

    fun openFragmentWithSheetStyle(fragmentManager: FragmentManager,
                                   targetViewGroup: Int,
                                   fragment: Fragment,
                                   clearStack: Boolean) {

        openFragment(fragmentManager, targetViewGroup, fragment, clearStack,
                R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
    }

    fun openFragment(fragmentManager: FragmentManager, targetViewGroup: Int,
                     fragment: Fragment, clearStack: Boolean,
                     @AnimRes enter: Int,
                     @AnimRes exit: Int,
                     @AnimRes popEnter: Int,
                     @AnimRes popExit: Int) {

        if (clearStack) {
            for (i in 0 until fragmentManager.backStackEntryCount) {
                fragmentManager.popBackStack()
            }
        }

        val currentFragment = fragmentManager.findFragmentById(targetViewGroup)
        if (currentFragment != null) {
            if (currentFragment.javaClass == fragment.javaClass) {
                return
            }
        }

        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(enter, exit, popEnter, popExit)
                .addToBackStack(null)

        if (fragment.isDetached) {
            fragmentTransaction.attach(fragment)
        } else {
            fragmentTransaction.replace(targetViewGroup, fragment)
        }

        try {
            fragmentTransaction.commit()
        } catch (e: IllegalStateException) {
            fragmentTransaction.commitAllowingStateLoss()
        }

    }

}