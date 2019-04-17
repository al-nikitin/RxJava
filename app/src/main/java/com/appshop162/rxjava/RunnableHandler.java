package com.appshop162.rxjava;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class RunnableHandler extends AppCompatActivity {

    private static final String TAG = "RunnableHandler";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runnable);
        final TextView textView = findViewById(R.id.text_runnable);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {

            int elapsedTime = 0;

            @Override
            public void run() {
                if (elapsedTime >= 10) {
                    handler.removeCallbacks(this);
                } else {
                    elapsedTime++;
                    handler.postDelayed(this, 1000);
                    Log.d(TAG, "run: " + elapsedTime);
                    textView.setText("Seconds elapsed: " + elapsedTime);
                }
            }
        };
        handler.postDelayed(runnable, 1000);
    }


}
