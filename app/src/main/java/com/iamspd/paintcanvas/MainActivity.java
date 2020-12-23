package com.iamspd.paintcanvas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // variables
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * onBackPressed() method to execute operations when back button pressed
     * when variable doubleBackToExitPressedOnce is FALSE, it will be do nothing
     * and will return to the method itself
     * if it is TRUE, it will show the Toast message and get
     * exited from the {@link MainActivity}
     */
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    /**
     * method to be executed on button click
     *
     * @param view provides a click functionality to a button
     *             on {{@link MainActivity}}
     */
    public void onStartDrawingClick(View view) {
        startActivity(new Intent(this, CanvasActivity.class));
    }
}