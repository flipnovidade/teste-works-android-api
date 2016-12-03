package br.com.teste.call.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ProgressBar;

import br.com.teste.call.AppActivity;
import br.com.teste.call.R;
import br.com.teste.call.utils.ActivityUtils;
import br.com.teste.call.utils.LogUtils;

public class SplashActivity extends AppActivity {
    private static final String TAG = SplashActivity.class.getSimpleName();
    private static int SPLASH_TIME_OUT = 1500;
    private boolean isTempoEncerrado;
    private boolean isExecutando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_splash);

        isTempoEncerrado = false;

        new LauncherTask().execute();

        new CountDownTimer(SPLASH_TIME_OUT, SPLASH_TIME_OUT) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                try {
                    if (isTempoEncerrado) {
                        goToNextScreen();
                    } else {
                        isTempoEncerrado = true;
                        ProgressBar pbLoading = (ProgressBar) findViewById(R.id.pbLoading);
                        pbLoading.setVisibility(View.VISIBLE);
                        pbLoading.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(SplashActivity.this, R.color.amarelo_claro), PorterDuff.Mode.SRC_IN);
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, e.getMessage());
                }
            }
        }.start();

    }

    private void goToNextScreen() {
        if (isExecutando) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                        ActivityUtils.openWithSlide(SplashActivity.this);
                        finish();

                    } catch (Exception e) {
                        LogUtils.e(TAG, e.getMessage());
                    }
                }
            });
        } else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            });
        }
    }

    class LauncherTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected Void doInBackground(Void... params) {
            Thread.currentThread().setName(this.getClass().getSimpleName());
            try {

            } catch (Exception e) {
                LogUtils.e(TAG, e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void voids) {
            try {
                if (isTempoEncerrado) {
                    goToNextScreen();
                } else {
                    isTempoEncerrado = true;
                }
            } catch (Exception e) {
                LogUtils.e(TAG, e.getMessage());
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            isExecutando = true;
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            isExecutando = true;
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        isExecutando = false;
    }

    @Override
    protected void onStop() {
        super.onStop();

        try {
            isExecutando = false;
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        try {
            isExecutando = false;
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());;
        }
    }

    @Override
    public void onBackPressed() {
    }
}
