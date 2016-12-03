package br.com.teste.call;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.com.teste.call.utils.ActivityUtils;
import br.com.teste.call.utils.LogUtils;

@SuppressWarnings("unused")
@SuppressLint("Registered")
public class AppActivity extends AppCompatActivity {
    private static final String TAG = AppActivity.class.getSimpleName();

    protected void configToolbar(boolean isDrawer) {
        configToolbar(isDrawer, true, true);
    }

    protected void configToolbar(boolean isDrawer, boolean withElevation, boolean isHome) {
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

            if (toolbar != null) {
                setSupportActionBar(toolbar);

                ActionBar actionBar = getSupportActionBar();

                if (actionBar != null) {
                    actionBar.setDisplayHomeAsUpEnabled(isHome);

                    /*if(isDrawer) {
                        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
                    }*/

                    if (withElevation) actionBar.setElevation(15);
                }
            }
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }
    }

    protected void replaceFragmentAnimation(int container, Fragment fragment) {
        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);

            fragmentTransaction.replace(container, fragment).commit();
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }
    }

    protected void replaceFragment(int container, Fragment fragment) {
        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(container, fragment).commit();
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }
    }

    /*protected void replaceFragmentTag(int container, Fragment fragment, String tag) {
        replaceFragmentTag(container, fragment, tag, false);
    }

    protected void replaceFragmentTag(int container, Fragment fragment, String tag, boolean animation) {
        replaceFragmentTag(container, fragment, tag, animation, DefaultConstant.Animation.FADE);
    }

    protected void replaceFragmentTag(int container, Fragment fragment, String tag, boolean animation, int animationType) {
        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            if(animation) {
                if (animationType == DefaultConstant.Animation.FADE)
                    fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                else if (animationType == DefaultConstant.Animation.ENTRADA)
                    fragmentTransaction.setCustomAnimations(R.anim.abc_slide_in_right, R.anim.abc_slide_out_left);
                else if (animationType == DefaultConstant.Animation.SAIDA)
                    fragmentTransaction.setCustomAnimations(R.anim.abc_slide_in_left, R.anim.abc_slide_out_right);
            }

            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.replace(container, fragment, tag).commit();

        } catch (Exception e) {
            LogExceptionUtils.log(tag, e);
        }
    }*/

    protected void removeFragment(Fragment fragment) {
        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.remove(fragment).commit();
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }
    }

    protected void popAllFragments() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        for(int i = 0; i < count; ++i) {
            getSupportFragmentManager().popBackStackImmediate();
        }
    }

    protected void onBackPressedFragment() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void startActivity(Intent intent) {
        ActivityUtils.openWithSlide(AppActivity.this);
        super.startActivity(intent);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        ActivityUtils.openWithSlide(AppActivity.this);
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    public void finish() {
        super.finish();
        ActivityUtils.closeWithSlide(AppActivity.this);
    }
}
