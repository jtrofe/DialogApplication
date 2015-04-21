package com.example.main.dialogapplication.customDialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.main.dialogapplication.R;


public class RateDialog extends Dialog{
    private RatingInterface mInterface;
    private RatingBar mRatingBar;

    public RateDialog(Context context, float rating){
        super(context);
        setContentView(R.layout.dialog_rating);

        mInterface = (RatingInterface) context;

        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        mRatingBar = (RatingBar) findViewById(R.id.ratingBar);
        if(rating != -1){
            mRatingBar.setRating(rating);
        }

        TextView okBtn = (TextView) findViewById(R.id.btn_save_rating);
        TextView cancelBtn = (TextView) findViewById(R.id.btn_cancel_rating);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInterface.OnRatingDone(mRatingBar.getRating());
                dismiss();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
