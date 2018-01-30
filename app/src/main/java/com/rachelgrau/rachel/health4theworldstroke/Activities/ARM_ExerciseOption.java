package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.analytics.FirebaseAnalytics;
import com.rachelgrau.rachel.health4theworldstroke.R;

import static com.rachelgrau.rachel.health4theworldstroke.Activities.illustrations.illName;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.videoPlayer.videoName;

/**
 * Created by Amit on 1/4/2018.
 */

public class ARM_ExerciseOption extends AppCompatActivity{
     String option_data= "";
    TextView txt;
    private FirebaseAnalytics firebaseAnalytics;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_option);
        init();
// Obtain the Firebase Analytics instance.
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        firebaseEvent();
        bundle = new Bundle();
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
        option_data = getIntent().getStringExtra(option_data);
        setUpToolbar();
        changer(option_data);

    }

    public void changer(String name) {

        if (name.equals(getString(R.string.new_exercise))) {
            addXml(2);
            textChanger(1);
        }
        if (name.equals(getString(R.string.L_2))) {
            addXml(1);
            textChanger(11);

        }
        if (name.equals(getString(R.string.L_3))) {
            addXml(1);
            textChanger(12);
        }
        if (name.equals(getString(R.string.L_4))) {
            addXml(1);
            textChanger(13);
        }
        if (name.equals(getString(R.string.Stretching))) {
            addXml(2);
            textChanger(2);
        }
        if (name.equals(getString(R.string.Leg_Feet))) {
            addXml(1);
            textChanger(21);
        }
        if (name.equals(getString(R.string.Arms_Hands))) {
            addXml(1);
            textChanger(22);
        }
        if (name.equals(getString(R.string.Function_Mobility))) {
            addXml(1);
            textChanger(3);
        }
    }

    public void textChanger(int n) {

         txt = (TextView) findViewById(R.id.txt_opt);
      //   txt.setVisibility(View.GONE);
        TextView OptionTV1 = (TextView) findViewById(R.id.optionTV1);
        ImageView OptionIV1 = (ImageView) findViewById(R.id.optionIV1);

        TextView OptionTV2 = (TextView) findViewById(R.id.optionTV2);
        ImageView OptionIV2 = (ImageView) findViewById(R.id.optionIV2);

        TextView OptionTV3 = (TextView) findViewById(R.id.optionTV3);
        ImageView OptionIV3 = (ImageView) findViewById(R.id.optionIV3);

        TextView OptionTV4 = (TextView) findViewById(R.id.optionTV4);
        ImageView OptionIV4 = (ImageView) findViewById(R.id.optionIV4);

        TextView OptionTV5 = (TextView) findViewById(R.id.optionTV5);
        ImageView OptionIV5 = (ImageView) findViewById(R.id.optionIV5);

        TextView OptionTV6 = (TextView) findViewById(R.id.optionTV6);
        ImageView OptionIV6 = (ImageView) findViewById(R.id.optionIV6);
        TextView OptionTV7 = (TextView) findViewById(R.id.optionTV7);
        ImageView OptionIV7 = (ImageView) findViewById(R.id.optionIV7);

        LinearLayout ll2 = (LinearLayout) findViewById(R.id.option2);
        LinearLayout ll3 = (LinearLayout) findViewById(R.id.option3);
        LinearLayout ll4 = (LinearLayout) findViewById(R.id.option4);
        LinearLayout ll5 = (LinearLayout) findViewById(R.id.option5);
        LinearLayout ll6 = (LinearLayout) findViewById(R.id.option6);
        LinearLayout ll7 = (LinearLayout) findViewById(R.id.option7);

        ll5.setVisibility(View.GONE);
        ll6.setVisibility(View.GONE);
        ll7.setVisibility(View.GONE);

        ScrollView sv = (ScrollView) findViewById(R.id.optionScroll);

        switch (n) {

            case 1:
                OptionTV1.setText(getString(R.string.arm_ex));
                OptionIV1.setImageResource(R.drawable.strengthing);
                OptionTV5.setText(R.string.balance);
                OptionIV5.setImageResource(R.drawable.coordination);
                OptionTV3.setText(R.string.Functional);
                OptionIV3.setImageResource(R.drawable.functional_mobility);
                ll2.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                ll5.setVisibility(View.VISIBLE);
                ll6.setVisibility(View.GONE);
                OptionIV2.setVisibility(View.GONE);
                OptionIV2.setVisibility(View.GONE);
                break;
            case 11:
                OptionTV1.setText(getString(R.string.L2_1));
                OptionIV1.setImageResource(R.drawable.l_1_1);
                OptionTV2.setText(R.string.L2_2);
                OptionIV2.setImageResource(R.drawable.l_2_2);
                OptionTV3.setText(R.string.L2_3);
                OptionIV3.setImageResource(R.drawable.l_2_3);
                OptionTV4.setText(R.string.L2_4);
                OptionIV4.setImageResource(R.drawable.l_2_4);
                txt.setText(R.string.Level2);
               // ll4.setVisibility(View.GONE);
                break;
            case 12:
                OptionTV1.setText(getString(R.string.L3_1));
                OptionIV1.setImageResource(R.drawable.l_3_1);
                /*OptionTV2.setText(R.string.L3_2);
                OptionIV2.setImageResource(R.drawable.l_3_2);*/
                OptionTV2.setText(R.string.L3_2);
                OptionIV2.setImageResource(R.drawable.l_3_3);
               /* OptionTV4.setText(R.string.L3_4);
                OptionIV4.setImageResource(R.drawable.l_3_4);*/
                OptionTV3.setText(R.string.L3_3);
                OptionIV3.setImageResource(R.drawable.l_3_5);
                OptionTV4.setText(R.string.L3_5);
                OptionIV4.setImageResource(R.drawable.l_3_6_1);
                OptionTV5.setText(R.string.L3_6);
                OptionIV5.setImageResource(R.drawable.l_3_7);
                txt.setText(R.string.Level3);
                ll5.setVisibility(View.VISIBLE);
               // ll6.setVisibility(View.VISIBLE);
               // ll7.setVisibility(View.VISIBLE);
                //ll3.setVisibility(View.GONE);
                //ll4.setVisibility(View.GONE);
                break;
            case 13:
                OptionTV1.setText(getString(R.string.L4_1));
                OptionIV1.setImageResource(R.drawable.l_4_1);
                OptionTV3.setText(R.string.L4_2);
                OptionIV3.setImageResource(R.drawable.l_4_2);
                txt.setText(R.string.Level4);
                ll2.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                ll5.setVisibility(View.GONE);
                ll6.setVisibility(View.GONE);
                ll7.setVisibility(View.GONE);
                break;
            case 2:
                OptionTV1.setText(R.string.Leg_Feet);
                OptionIV1.setImageResource(R.drawable.legs);
                OptionTV2.setText(R.string.Arms_Hands);
                OptionIV2.setImageResource(R.drawable.strengthing);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                break;
            case 21:
                OptionTV1.setText(getString(R.string.Adductores));
                OptionIV1.setImageResource(R.drawable.rsz_adductors1);
                OptionTV2.setText(R.string.Hamstrings);
                OptionIV2.setImageResource(R.drawable.rsz_hamstrings2);
                OptionTV3.setText(R.string.Dorsiflexors);
                OptionIV3.setImageResource(R.drawable.rsz_dorsiflexors2);
                ll4.setVisibility(View.GONE);
                break;
            case 22:
                OptionTV1.setText(getString(R.string.Hand_Stretch));
                OptionIV1.setImageResource(R.drawable.rsz_hand2);
                OptionTV2.setText(R.string.Shoulder_Stretches);
                OptionIV2.setImageResource(R.drawable.rsz_1shoulder2);
                OptionTV3.setText(R.string.Arm_Stretch);
                OptionIV3.setImageResource(R.drawable.rsz_1hand2);
                ll4.setVisibility(View.GONE);
                break;
            case 3:
                OptionTV1.setText(R.string.Bridge_hip);
                OptionIV1.setImageResource(R.drawable.bridge_hip);
                OptionTV2.setText(R.string.Arm_trunk);
                OptionIV2.setImageResource(R.drawable.arm_trunk);
                OptionTV3.setText(R.string.Sittostand);
                OptionIV3.setImageResource(R.drawable.sit_to_stand);
                ll4.setVisibility(View.GONE);
                break;
        }
    }

    public void onClick(View v) {

        TextView OptionTV1 = (TextView) findViewById(R.id.optionTV1);
        TextView OptionTV2 = (TextView) findViewById(R.id.optionTV2);
        TextView OptionTV3 = (TextView) findViewById(R.id.optionTV3);
       TextView OptionTV4 = (TextView) findViewById(R.id.optionTV4);
        TextView OptionTV5 = (TextView) findViewById(R.id.optionTV5);
        TextView OptionTV6 = (TextView) findViewById(R.id.optionTV6);
        TextView OptionTV7 = (TextView) findViewById(R.id.optionTV7);

        LinearLayout L1 = (LinearLayout) findViewById(R.id.option1);

        /*for NEW Exercises*/
        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.arm_ex))) {

            Intent intent = new Intent(this, ARMExerciseActivity.class);
            intent.putExtra(option_data, "ARM");
            // Bundle bundle = new Bundle();

            startActivity(intent);
        }
        if (v.getId() == R.id.option3 && OptionTV3.getText().equals(getString(R.string.Functional))) {
           /* Intent intent = new Intent(this, ExerciseOption.class);
            intent.putExtra(option_data, getString(R.string.Functional));
            startActivity(intent);*/
            // Bundle bundle = new Bundle();

            Toast.makeText(this, "Functional Mobility", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.option5 && OptionTV5.getText().equals(getString(R.string.balance))) {
           /* Intent intent = new Intent(this, ExerciseOption.class);
            intent.putExtra(option_data, getString(R.string.balance));
            startActivity(intent);*/
            // Bundle bundle = new Bundle();

            Toast.makeText(this, "Balance Training", Toast.LENGTH_SHORT).show();
        }

      /*  *//*for streching*//*

        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.Leg_Feet))) {
            Intent intent = new Intent(this, ExerciseOption.class);
            intent.putExtra(option_data, getString(R.string.Leg_Feet));
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.Arms_Hands))) {
            Intent intent = new Intent(this, ExerciseOption.class);
            intent.putExtra(option_data, getString(R.string.Arms_Hands));
            startActivity(intent);
        }*/

         /*video Level-2*/
        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.L2_1))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.L2_1));
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.L2_2))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.L2_2));
            startActivity(intent);
        }
        if (v.getId() == R.id.option3 && OptionTV3.getText().equals(getString(R.string.L2_3))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.L2_3));
            startActivity(intent);
        }
        if (v.getId() == R.id.option4 && OptionTV4.getText().equals(getString(R.string.L2_4))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.L2_4));
            startActivity(intent);
        }
//        Video Level 3
        if(v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.L3_1)))
        {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.L3_1));
            startActivity(intent);
        }
        if(v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.L3_2)))
        {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.L3_2));
            startActivity(intent);
        }
        if(v.getId() == R.id.option3 && OptionTV3.getText().equals(getString(R.string.L3_3)))
        {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.L3_3));
            startActivity(intent);
        }
        if(v.getId() == R.id.option4 && OptionTV4.getText().equals(getString(R.string.L3_4)))
        {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.L3_4));
            startActivity(intent);
        }
        if(v.getId() == R.id.option5 && OptionTV5.getText().equals(getString(R.string.L3_5)))
        {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.L3_5));
            startActivity(intent);
        }
        if(v.getId() == R.id.option6 && OptionTV6.getText().equals(getString(R.string.L3_6)))
        {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.L3_6));
            startActivity(intent);
        }
        if(v.getId() == R.id.option7 && OptionTV7.getText().equals(getString(R.string.L3_7)))
        {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.L3_7));
            startActivity(intent);
        }
        /* Video Level 4
        * */
        if(v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.L4_1)))
        {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.L4_1));
            startActivity(intent);
        }
        if(v.getId() == R.id.option3 && OptionTV3.getText().equals(getString(R.string.L4_2)))
        {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.L4_2));
            startActivity(intent);
        }
        // end Level 4

        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.Shoulder))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.Shoulder));
            startActivity(intent);
        }
        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.Leg_1))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.Leg_1));
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.Leg_2))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.Leg_2));
            startActivity(intent);
        }

       /* //video streching
        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.Adductores))) {
            Intent intent = new Intent(this, illustrations.class);
            intent.putExtra(illName, R.string.Adductores);
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.Hamstrings))) {
            Intent intent = new Intent(this, illustrations.class);
            intent.putExtra(illName, R.string.Hamstrings);
            startActivity(intent);
        }
        if (v.getId() == R.id.option3 && OptionTV3.getText().equals(getString(R.string.Dorsiflexors))) {
            Intent intent = new Intent(this, illustrations.class);
            intent.putExtra(illName, R.string.Dorsiflexors);
            startActivity(intent);
        }
        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.Hand_Stretch))) {
            Intent intent = new Intent(this, illustrations.class);
            intent.putExtra(illName, R.string.Hand_Stretch);
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.Shoulder_Stretches))) {
            Intent intent = new Intent(this, illustrations.class);
            intent.putExtra(illName, R.string.Shoulder_Stretches);
            startActivity(intent);
        }
        if (v.getId() == R.id.option3 && OptionTV3.getText().equals(getString(R.string.Arm_Stretch))) {
            Intent intent = new Intent(this, illustrations.class);
            intent.putExtra(illName, R.string.Arm_Stretch);
            startActivity(intent);
        }*/

        /*functional mobility*/
        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.Bridge_hip))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.Bridge_hip));
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.Arm_trunk))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.Arm_trunk));
            startActivity(intent);
        }
        if (v.getId() == R.id.option3 && OptionTV3.getText().equals(getString(R.string.Sittostand))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.Sittostand));
            startActivity(intent);
        }
    }
    public void addXml(int info) {
        if (info == 1) {
            ScrollView sv = (ScrollView) findViewById(R.id.optionScroll);
            LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            sv.addView(layoutInflater.inflate(R.layout.levels, null));

        }
        if (info == 2) {
            ScrollView sv = (ScrollView) findViewById(R.id.optionScroll);
            LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            sv.addView(layoutInflater.inflate(R.layout.newexercises_box, null));
        }

    }
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.learn_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(option_data);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }
}
