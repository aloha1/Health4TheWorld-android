package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.rachelgrau.rachel.health4theworldstroke.App.AnalyticsApplication;
import com.rachelgrau.rachel.health4theworldstroke.R;

import static com.rachelgrau.rachel.health4theworldstroke.Activities.LearnActivity.EXTRA_PAGE_TYPE;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.LearnActivity.PAGE_TYPE_READ;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.Exercise.data;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    boolean setRating = false;
    Tracker mTracker;
    public String TAG = "GA";
    private FirebaseAnalytics firebaseAnalytics;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_new);
        setUpToolbar();
        init();
        // Obtain the shared Tracker instance.
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();
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
        View footer = findViewById(R.id.footer);
        Button bt_rating = (Button) footer.findViewById(R.id.Imbt_rating);
        Button bt_feedback = (Button) footer.findViewById(R.id.imbt_feedback);
        bt_rating.setOnClickListener(this);
        bt_feedback.setOnClickListener(this);
         bundle = new Bundle();


    }

    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.learn_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.home);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    public void onClick(View v) {

        if (v.getId() == R.id.ll_help_me_speak) {
            Intent intent = new Intent(this, HelpMeSpeakActivity.class);
            String category = "Help";
            String action = "help_me_speak";
            sendGA(category, action);

           // Bundle bundle = new Bundle();
            bundle.putInt(FirebaseAnalytics.Param.ITEM_ID, Integer.parseInt("Help me Speak"));
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Help me Speak");
            startActivity(intent);
        }
        if (v.getId() == R.id.ll_exercise) {
            Intent intent = new Intent(this, Exercise.class);
            intent.putExtra(data, "o");
            String category = "Exercise";
            String action = "Click";
            sendGA(category, action);
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Exercise");
            startActivity(intent);
        }
        if (v.getId() == R.id.ll_learn) {
            Intent intent = new Intent(this, LearnActivity.class);
            intent.putExtra(EXTRA_PAGE_TYPE, PAGE_TYPE_READ);
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Learn Activity");
            startActivity(intent);
        }
        if (v.getId() == R.id.ll_reminders) {
            Intent intent = new Intent(this, RemindersActivity.class);
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Reminder");
            startActivity(intent);
        }
        if (v.getId() == R.id.ll_general_info) {
            /*Intent intent = new Intent(this, InfoListActivity.class);*/
            Intent intent = new Intent(this, ChatBotMainActivity.class);
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "ChatBot");
            startActivity(intent);
        }
        if (v.getId() == R.id.ll_survey) {
            Intent intent = new Intent(this, password_gateway.class);
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "PasswordGateway");
            startActivity(intent);
        }
        if (v.getId() == R.id.iv_feeling_1) {
            Intent intent = new Intent(this, ChatBotMainActivity.class);
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "ChatBot Main- Feeling-1");
            intent.putExtra("Feeling","Awesome");
            startActivity(intent);
        }
        if (v.getId() == R.id.iv_feeling_2) {
            Intent intent = new Intent(MainActivity2.this, ChatBotMainActivity.class);
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "ChatBot Main- Feeling-2");

            intent.putExtra("Feeling","Happy");
            startActivity(intent);
        }
        if (v.getId() == R.id.iv_feeling_3) {
            Intent intent = new Intent(this, ChatBotMainActivity.class);
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "ChatBot Main- Feeling-3");
            intent.putExtra("Feeling","Sad");
            startActivity(intent);
        }
        if (v.getId() == R.id.iv_feeling_4) {
            Intent intent = new Intent(this, ChatBotMainActivity.class);
            intent.putExtra("Feeling","Sad");
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "ChatBot Main- Feeling-4");
            startActivity(intent);
        }
        if (v.getId() == R.id.iv_feeling_5) {
            Intent intent = new Intent(this, ChatBotMainActivity.class);
            intent.putExtra("Feeling","Very Sad");
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "ChatBot Main- Feeling-5");
            startActivity(intent);
        }
        if (v.getId() == R.id.Imbt_rating)
        {
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Rating Button Click");

            if(!setRating)
            {
                FooterActivity cdd = new FooterActivity(this);
                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                setRating = true;
                cdd.show();
            }
            else
            {

                Toast.makeText(this, "You have submitted Rating", Toast.LENGTH_SHORT).show();
            }
        }
        if(v.getId()== R.id.imbt_feedback) {
            SharedPreferences prefs = getSharedPreferences("RAting_Pref", MODE_PRIVATE);
            String restoredText = prefs.getString("rating", null);
            String comment = prefs.getString("UC", null);
            String name = "";

            String UserRating = "";
            if (restoredText != null || comment!=null) {
                name = prefs.getString("rating", "No name defined");
                if (name.equals(2)) {
                    UserRating = "Ok";
                } else if (name.equals(0)) {
                    UserRating = "Terrible";
                } else if (name.equals(1)) {
                    UserRating = "Bad";
                } else if (name.equals(3)) {
                    UserRating = "Good";
                } else if (name.equals(4)) {
                    UserRating = "Excellent";
                }
            }
            Intent send = new Intent(Intent.ACTION_SENDTO);
            String uriText = "mailto:" + Uri.encode("contact@health4theworld.org") +
                    "?subject=" + Uri.encode("Sub : We would love to hear what you think about the app and how we can make it better") +
                    "&body=" +
                    Uri.encode(String.format("Comment: %s"+comment, UserRating));
            Uri uri = Uri.parse(uriText);

            send.setData(uri);
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Feedback Button Click");

            startActivity(Intent.createChooser(send, "Send mail..."));
        }
    }

    private void sendGA(String category, String action) {

        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory(category)
                .setAction(action)
                .build());
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "Setting screen name: " + this.getClass().getSimpleName());
        mTracker.setScreenName("Screen~" + this.getClass().getSimpleName());
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        super.onResume();
    }
}