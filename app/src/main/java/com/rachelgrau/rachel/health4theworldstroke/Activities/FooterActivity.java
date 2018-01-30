package com.rachelgrau.rachel.health4theworldstroke.Activities;


import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.AccountPicker;
import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;
import com.rachelgrau.rachel.health4theworldstroke.R;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;

/**
 * Created by Amit on 1/17/2018.
 */

public class FooterActivity extends Dialog implements View.OnClickListener, SmileRating.OnSmileySelectionListener, SmileRating.OnRatingSelectedListener {

    SmileRating smileRating;
    Button bt_cancel, bt_submit;
    EditText et_comment;
    FooterActivity context;
    String comment;


    public FooterActivity(Context context) {

        super(context);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.detail_footer);
        //context = FooterActivity.this;
        init();

    }

    private void init() {

        smileRating = (SmileRating) findViewById(R.id.smile_rating);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);
        bt_submit = (Button) findViewById(R.id.bt_submit);
        et_comment = (EditText) findViewById(R.id.editText_comment);
        Typeface tf = Typeface.DEFAULT_BOLD;
        smileRating.setTypeface(tf);
        smileRating.setPlaceHolderSmileColor(Color.BLACK);
        smileRating.setPlaceholderBackgroundColor(Color.YELLOW);

        bt_cancel.setOnClickListener(this);


        bt_submit.setEnabled(false);
        et_comment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.toString().trim().length() == 0 && !bt_submit.isEnabled()) {
                    Toast.makeText(getContext(), "Please select rating", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ((s.toString().trim().length() == 0) && TAG.equals("Non selection")) {
                    Log.e("Edit text", "Empty");
                    Toast.makeText(getContext(), "Please select rating", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void afterTextChanged(Editable s) {
                 comment = s.toString();
                bt_submit.setEnabled(true);
                bt_submit.setOnClickListener(FooterActivity.this);
            }
        });
        smileRating.setOnSmileySelectionListener(this);
        smileRating.setOnRatingSelectedListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_cancel:
                dismiss();
                break;

            case R.id.bt_submit:

                AccountManager manager = AccountManager.get(getContext());
                Account[] accounts = manager.getAccountsByType("com.google");
                List<String> username = new LinkedList<String>();

                for (Account account : accounts) {
                    username.add(account.name);
                }
                saveRating(smileRating);


                Log.e("Submit bt", "Click");

                break;

            default:
                Log.e("DEfaut", "Click");

        }

    }

    public void getEmail() {
        AccountManager manager = AccountManager.get(getContext());
        Account[] accounts = manager.getAccountsByType("com.google");
        List<String> username = new LinkedList<String>();

        for (Account account : accounts) {
            username.add(account.name);
        }
    }


    private void saveRating(SmileRating smileRating) {

        SharedPreferences settings = getContext().getSharedPreferences("RAting_Pref", 0);
        SharedPreferences.Editor editor = settings.edit();
        String rating = String.valueOf(smileRating.getSelectedSmile());

        editor.putString("rating", rating);
        editor.putString("UC", comment);

// Apply the edits!
        editor.apply();
        Log.e("Sharedpref", rating);
        Toast.makeText(getContext(), "Thank You", Toast.LENGTH_SHORT).show();
        dismiss();

    }


    @Override
    public void onSmileySelected(int smiley, boolean reselected) {

        switch (smiley) {
            case SmileRating.TERRIBLE:
                Log.i(TAG, "Terrible");
                break;
            case SmileRating.BAD:
                Log.i(TAG, "Bad");
                break;
            case SmileRating.OKAY:
                Log.i(TAG, "Okay");
                break;
            case SmileRating.GOOD:
                Log.i(TAG, "Good");
                break;
            case SmileRating.GREAT:
                Log.i(TAG, "Great");
                break;


        }

    }

    @Override
    public void onRatingSelected(int level, boolean reselected) {

        Log.i(TAG, "Rated as: " + level + " - " + reselected);

    }
}
