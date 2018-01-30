package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.rachelgrau.rachel.health4theworldstroke.R;

import static android.view.Gravity.CENTER_VERTICAL;

public class ARMExerciseActivity extends AppCompatActivity implements View.OnClickListener{
    public TextView txt_Level1,txt_Level2, txt_Level3, txt_Level4 ;
    public LinearLayout ll_Level1,ll_Level2,ll_Level3,ll_Level4;

    String option_data="" ;
    private FirebaseAnalytics firebaseAnalytics;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_arm);
     init();
        // Obtain the Firebase Analytics instance.
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        firebaseEvent();

    }
    private void firebaseEvent() {
        //Logs an app event.
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        //Sets whether analytics collection is enabled for this app on this device.
        firebaseAnalytics.setAnalyticsCollectionEnabled(true);

        //Sets the minimum engagement time required before starting a session. The default value is 10000 (10 seconds). Let's make it 20 seconds just for the fun
        firebaseAnalytics.setMinimumSessionDuration(20000);

        //Sets the duration of inactivity that terminates the current session. The default value is 1800000 (30 minutes).
        firebaseAnalytics.setSessionTimeoutDuration(500);

    }

    private void init() {
        setUpToolbar();
        bundle = new Bundle();
        txt_Level1 = (TextView)findViewById(R.id.txt_L1);
        ll_Level1 = (LinearLayout)findViewById(R.id.ll_Level1);
        ll_Level2 = (LinearLayout)findViewById(R.id.ll_Level2);
        ll_Level3 = (LinearLayout)findViewById(R.id.ll_Level3);
        ll_Level4 = (LinearLayout)findViewById(R.id.ll_Level4);

        txt_Level2 = (TextView)findViewById(R.id.txt_L2);
        txt_Level3 = (TextView)findViewById(R.id.txt_L3);
        txt_Level4 = (TextView)findViewById(R.id.txt_L4);
        txt_Level1.setOnClickListener(this);
        txt_Level2.setOnClickListener(this);
        txt_Level3.setOnClickListener(this);
        txt_Level4.setOnClickListener(this);
        ll_Level1.setOnClickListener(this);
        ll_Level2.setOnClickListener(this);
        ll_Level3.setOnClickListener(this);
        ll_Level4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(findViewById((R.id.txt_L1))))
        {
            getToast();


        }
        else if(v.equals(findViewById(R.id.txt_L2))  )
        {
            Intent L2 = new Intent(this, ARM_ExerciseOption.class);
            L2.putExtra(option_data,"Level 2"/*getResources().getString(R.string.L_2)*/);

            System.out.println(L2.getExtras());
            startActivity(L2);


        }
        else if(v.equals(findViewById(R.id.txt_L3)) )
        {
            Intent L3 = new Intent(this, ARM_ExerciseOption.class);
            L3.putExtra(option_data,getResources().getString(R.string.L_3));
            startActivity(L3);
        }
        else if(v.equals(findViewById(R.id.txt_L4)) )
        {
            Intent i = new Intent(this, ARM_ExerciseOption.class);
            i.putExtra(option_data,getResources().getString(R.string.L_4));
            startActivity(i);
        }

       else if(v.equals(findViewById(R.id.ll_Level1)))
        {
            getToast();
        }
        else if(v.equals(findViewById(R.id.ll_Level2)))
        {
            Intent L2 = new Intent(this, ARM_ExerciseOption.class);
            L2.putExtra(option_data,"Level 2"/*getResources().getString(R.string.L_2)*/);
            System.out.println(L2.getExtras());
            startActivity(L2);

        }
        else if(v.equals(findViewById(R.id.ll_Level3)))
        {
            Intent L3 = new Intent(this, ARM_ExerciseOption.class);
            L3.putExtra(option_data,"Level 3"/*getResources().getString(R.string.L_2)*/);
            System.out.println(L3.getExtras());
            startActivity(L3);

        }
        else if(v.equals(findViewById(R.id.ll_Level4)))
        {
            Intent L4 = new Intent(this, ARM_ExerciseOption.class);
            L4.putExtra(option_data,"Level 4"/*getResources().getString(R.string.L_2)*/);
            System.out.println(L4.getExtras());
            startActivity(L4);

        }

    }

    private void getToast() {
        Context context = this;
        CharSequence text = "No Voluntary Movement";
        int duration = Toast.LENGTH_SHORT;
        SpannableStringBuilder biggerText = new SpannableStringBuilder(text);
        biggerText.setSpan(new RelativeSizeSpan(1.35f), 0, text.length(), 0);
        Toast toast = Toast.makeText(context, biggerText, duration);
        toast.setGravity(CENTER_VERTICAL, 0, 0);
        toast.show();
    }
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.learn_toolbar);
       myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText("ARM Exercises");
        toolbarTitle.setTextColor(Color.WHITE);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

}
