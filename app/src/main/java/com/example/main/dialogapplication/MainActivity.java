package com.example.main.dialogapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.main.dialogapplication.customDialogs.LogInDialog;
import com.example.main.dialogapplication.customDialogs.RateDialog;
import com.example.main.dialogapplication.customDialogs.RatingInterface;


public class MainActivity extends Activity implements RatingInterface{
    private float mRating = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void RateClick(View v){
        new RateDialog(this, mRating).show();
    }

    public void LogInClick(View v){
        new LogInDialog(this).show();
    }

    public void OnRatingDone(float rating){
        mRating = rating;
    }
}
