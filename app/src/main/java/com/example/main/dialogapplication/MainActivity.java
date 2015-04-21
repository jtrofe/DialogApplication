package com.example.main.dialogapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import com.example.main.dialogapplication.customDialogs.LogInDialog;
import com.example.main.dialogapplication.customDialogs.RateDialog;
import com.example.main.dialogapplication.customDialogs.RatingInterface;


public class MainActivity extends Activity implements RatingInterface{
    private float mRating = -1;

    private RatingBar stars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = (LinearLayout) findViewById(R.id.starLayout);
        stars = (RatingBar) findViewById(R.id.stars);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RateClick(v);
            }
        });
    }

    public void RateClick(View v){
        new RateDialog(this, mRating).show();
    }

    public void LogInClick(View v){
        new LogInDialog(this).show();
    }

    public void OnRatingDone(float rating){
        mRating = rating;
        stars.setRating(rating);
    }
}
