package com.example.junlingwang.junlingwangblockpuzzle2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class themeChoosing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_choosing);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void chooseAnimals (View view) {
        String signal = "0";
        Intent intent = new Intent();
        intent.putExtra("MESSAGE", signal);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void chooseVehicles (View view) {
        String signal = "1";
        Intent intent = new Intent();
        intent.putExtra("MESSAGE", signal);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void chooseScience (View view) {
        String signal = "2";
        Intent intent = new Intent();
        intent.putExtra("MESSAGE", signal);
        setResult(RESULT_OK, intent);
        finish();
    }

}
