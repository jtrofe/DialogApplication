package com.example.main.dialogapplication.customDialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.main.dialogapplication.R;

public class LogInDialog extends Dialog{

    //Progress spinner
    private ProgressBar spinner;

    //Headers
    private LinearLayout logInHeader;
    private LinearLayout signUpHeader;

    //Icons
    private ImageView iconLogIn;
    private ImageView iconSignUp;

    //Inputs
    private EditText logInUsername;
    private EditText logInPassword;

    private EditText signUpUsername;
    private EditText signUpPassword1;
    private EditText signUpPassword2;

    //Button
    private TextView submitButton;

    //State variables
    private boolean loggingIn;
    private boolean loading;

    public LogInDialog(Context context){
        super(context);
        setContentView(R.layout.dialog_log_in);

        getWindow().setBackgroundDrawableResource(R.drawable.dialog_background);
        setTitle("You are not logged in!");//TODO replace with string reference

        //-------------//
        //--Get views--//
        //-------------//
        spinner = (ProgressBar) findViewById(R.id.spinner);

        //Get headers
        logInHeader = (LinearLayout) findViewById(R.id.header_log_in);
        signUpHeader = (LinearLayout) findViewById(R.id.header_sign_up);

        //Get icons
        iconLogIn = (ImageView) logInHeader.findViewById(R.id.icon_log_in);
        iconSignUp = (ImageView) signUpHeader.findViewById(R.id.icon_sign_up);

        //Get input fields
        logInUsername = (EditText) findViewById(R.id.input_log_in_username);
        logInPassword = (EditText) findViewById(R.id.input_log_in_pass);

        signUpUsername = (EditText) findViewById(R.id.input_sign_up_username);
        signUpPassword1 = (EditText) findViewById(R.id.input_sign_up_pass1);
        signUpPassword2 = (EditText) findViewById(R.id.input_sign_up_pass2);


        submitButton = (TextView) findViewById(R.id.btn_submit);

        //Set password typefaces
        logInPassword.setTypeface(Typeface.DEFAULT);
        signUpPassword1.setTypeface(Typeface.DEFAULT);
        signUpPassword2.setTypeface(Typeface.DEFAULT);

        //Set state variables
        loggingIn = true;
        loading = false;

        //-----------------------//
        //--Set event listeners--//
        //-----------------------//
        logInHeader.setOnClickListener(OnHeaderClick);
        signUpHeader.setOnClickListener(OnHeaderClick);
        setOnKeyListener(OnKeyClick);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(loggingIn){
                    LogIn();
                }else{
                    SignUp();
                }
            }
        });
    }

    private View.OnClickListener OnHeaderClick = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            switch(v.getTag().toString()){
                case "log_in":
                    if(loggingIn) return;
                    loggingIn = true;
                    SetVisibilities();

                    break;
                case "sign_up":
                    if(!loggingIn) return;
                    loggingIn = false;
                    SetVisibilities();

                    break;
            }
        }
    };

    private OnKeyListener OnKeyClick = new OnKeyListener() {
        @Override
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            //If the dialog is signing up/logging in
            // (progress bar is showing) then disable the back button
            return (keyCode == KeyEvent.KEYCODE_BACK && loading);
        }
    };

    private void SetVisibilities(){
        int logVisibility;
        int signVisibility;
        if(loggingIn){
            logVisibility = View.VISIBLE;
            signVisibility = View.GONE;
            iconLogIn.setScaleY(-1);
            iconSignUp.setScaleY(1);
        }else{
            logVisibility = View.GONE;
            signVisibility = View.VISIBLE;
            iconLogIn.setScaleY(1);
            iconSignUp.setScaleY(-1);
        }

        logInUsername.setVisibility(logVisibility);
        logInPassword.setVisibility(logVisibility);

        signUpUsername.setVisibility(signVisibility);
        signUpPassword1.setVisibility(signVisibility);
        signUpPassword2.setVisibility(signVisibility);
    }

    private void SetLoading(){
        setCanceledOnTouchOutside(false);
        loading = true;
        spinner.setVisibility(View.VISIBLE);

        logInHeader.setVisibility(View.GONE);
        logInUsername.setVisibility(View.GONE);
        logInPassword.setVisibility(View.GONE);

        signUpHeader.setVisibility(View.GONE);
        signUpUsername.setVisibility(View.GONE);
        signUpPassword1.setVisibility(View.GONE);
        signUpPassword2.setVisibility(View.GONE);

        submitButton.setVisibility(View.GONE);
    }

    private void LogIn(){
        //TODO handle logging in
        setTitle("Logging in");//TODO replace with string reference
        SetLoading();
    }

    private void SignUp(){
        //TODO handle signing up
        setTitle("Signing up");//TODO replace with string reference
        SetLoading();
    }
}