package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.rachelgrau.rachel.health4theworldstroke.R;

import static com.rachelgrau.rachel.health4theworldstroke.Activities.videoPlayer.videoName;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.ImageActivity.imageName;

/**
 * Created by Amit on 1/4/2018.
 */

public class BalanceTraining_ExerciseOption extends AppCompatActivity{
    String option_data= "";
    public static String sub_data ="";
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
        option_data = getIntent().getStringExtra(sub_data);
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
        if (name.equals(getString(R.string.Sitting))) {
            addXml(3);
            textChanger(71);
        }
        if (name.equals(getString(R.string.Standing))) {
            addXml(3);
            textChanger(72);
        }
        if (name.equals(getString(R.string.sitting_and_leaning_in_different_directions))) {
            addXml(3);
            textChanger(711);
        }
        if (name.equals(getString(R.string.standing_practice))) {
            addXml(1);
            textChanger(721);
        }
        if (name.equals(getString(R.string.standing_and_shifting_weight_side_to_side))) {
            addXml(1);
            textChanger(722);
        }
        if (name.equals(getString(R.string.step_tap))) {
            addXml(1);
            textChanger(723);
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
            case 71:
                OptionTV1.setText(getString(R.string.sitting_with_one_hand_support));
                OptionTV2.setText(getString(R.string.sitting_with_no_hand_support));
                OptionTV3.setText(getString(R.string.sitting_and_leaning_in_different_directions));
                OptionIV1.setImageResource(R.drawable.sitting_with_one_hand_support);
                OptionIV2.setImageResource(R.drawable.sitting_with_no_hand_support);
                OptionIV3.setImageResource(R.drawable.shifting_direction);
                ll4.setVisibility(View.GONE);
                break;
            case 72:
                OptionTV1.setText(getString(R.string.standing_practice));
                OptionTV2.setText(getString(R.string.standing_and_shifting_weight_side_to_side));
                OptionTV3.setText(getString(R.string.step_tap));
                OptionIV1.setImageResource(R.drawable.standing_3729);
                OptionIV2.setImageResource(R.drawable.standing_3730);
                OptionIV3.setImageResource(R.drawable.shifting_direction);
                ll4.setVisibility(View.GONE);
                break;
            case 711:
                OptionTV1.setText(getString(R.string.video_3571));
                OptionTV2.setText(getString(R.string.video_3572));
                OptionIV1.setImageResource(R.drawable.video_3571);
                OptionIV2.setImageResource(R.drawable.video_3572);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                break;
            case 721:
                OptionTV1.setText(getString(R.string.standing_3729));
                OptionTV2.setText(getString(R.string.standing_3730));
                OptionTV3.setText(getString(R.string.standing_3731));
                OptionTV4.setText(getString(R.string.standing_3732));
                OptionIV1.setImageResource(R.drawable.standing_3729);
                OptionIV2.setImageResource(R.drawable.standing_3730);
                OptionIV3.setImageResource(R.drawable.standing_3731);
                OptionIV4.setImageResource(R.drawable.standing_3732);
                break;
            case 722:
                OptionTV1.setText(getString(R.string.video_3574));
                OptionTV2.setText(getString(R.string.video_3580));
                OptionIV1.setImageResource(R.drawable.video_3574);
                OptionIV2.setImageResource(R.drawable.video_3580);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                break;
            case 723:
                OptionTV1.setText(getString(R.string.video_3575));
                OptionTV2.setText(getString(R.string.video_3576));
                OptionTV3.setText(getString(R.string.video_3578));
                OptionIV1.setImageResource(R.drawable.video_3575);
                OptionIV2.setImageResource(R.drawable.video_3576);
                OptionIV3.setImageResource(R.drawable.video_3578);
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
            Intent intent = new Intent(this, FunctionMobilityActivity.class);
            intent.putExtra(option_data, getString(R.string.Functional));
            startActivity(intent);
            // Bundle bundle = new Bundle();

            //Toast.makeText(this, "Functional Mobility", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.option5 && OptionTV5.getText().equals(getString(R.string.balance))) {
            Intent intent = new Intent(this, BalanceTrainingActivity.class);
            intent.putExtra(option_data, getString(R.string.balance));
            startActivity(intent);
            // Bundle bundle = new Bundle();

//            Toast.makeText(this, "Balance Training", Toast.LENGTH_SHORT).show();
        }

         /*Balance Training*/
        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.sitting_with_one_hand_support))) {

            Intent intent = new Intent(this, ImageActivity.class);
            intent.putExtra(imageName,  getString(R.string.sitting_with_one_hand_support));
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.sitting_with_no_hand_support))) {
            Intent intent = new Intent(this, ImageActivity.class);
            intent.putExtra(imageName,  getString(R.string.sitting_with_no_hand_support));
            startActivity(intent);
        }
        if (v.getId() == R.id.option3 && OptionTV3.getText().equals(getString(R.string.sitting_and_leaning_in_different_directions))) {
            Intent intent = new Intent(this, ARM_ExerciseOption.class);
            intent.putExtra(option_data, getString(R.string.sitting_and_leaning_in_different_directions));
            startActivity(intent);
        }

        /*Sitting in different directions*/
        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.video_3571))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.video_3571));
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.video_3572))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.video_3572));
            startActivity(intent);
        }

        /*Standing Practice*/
//        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.standing_practice))) {
//
//            Intent intent = new Intent(this, BalanceTraining_ExerciseOption.class);
//            intent.putExtra(sub_data,  getString(R.string.standing_practice));
//            startActivity(intent);
//        }
//        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.standing_and_shifting_weight_side_to_side))) {
//            Intent intent = new Intent(this, BalanceTraining_ExerciseOption.class);
//            intent.putExtra(sub_data,  getString(R.string.standing_and_shifting_weight_side_to_side));
//            startActivity(intent);
//        }
//        if (v.getId() == R.id.option3 && OptionTV3.getText().equals(getString(R.string.step_tap))) {
//
//            Intent intent = new Intent(this, BalanceTraining_ExerciseOption.class);
//            intent.putExtra(sub_data,  getString(R.string.step_tap));
//            startActivity(intent);
//        }

        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.standing_3729))) {
            Intent intent = new Intent(this, ImageActivity.class);
            intent.putExtra(imageName,  getString(R.string.standing_3729));
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.standing_3730))) {
            Intent intent = new Intent(this, ImageActivity.class);
            intent.putExtra(imageName,  getString(R.string.standing_3730));
            startActivity(intent);
        }
        if (v.getId() == R.id.option3 && OptionTV3.getText().equals(getString(R.string.standing_3731))) {
            Intent intent = new Intent(this, ImageActivity.class);
            intent.putExtra(imageName,  getString(R.string.standing_3731));
            startActivity(intent);
        }
        if (v.getId() == R.id.option4 && OptionTV4.getText().equals(getString(R.string.standing_3732))) {
            Intent intent = new Intent(this, ImageActivity.class);
            intent.putExtra(imageName,  getString(R.string.standing_3732));
            startActivity(intent);
        }

        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.video_3574))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName,  getString(R.string.video_3574));
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.video_3580))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName,  getString(R.string.video_3580));
            startActivity(intent);
        }
        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.video_3575))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName,  getString(R.string.video_3575));
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.video_3576))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName,  getString(R.string.video_3576));
            startActivity(intent);
        }
        if (v.getId() == R.id.option3 && OptionTV3.getText().equals(getString(R.string.video_3578))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName,  getString(R.string.video_3578));
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
        if (info == 3) {
            ScrollView sv = (ScrollView) findViewById(R.id.optionScroll);
            LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            sv.addView(layoutInflater.inflate(R.layout.levels_linear, null));
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
