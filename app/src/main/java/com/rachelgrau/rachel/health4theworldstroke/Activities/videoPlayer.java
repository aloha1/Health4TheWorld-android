package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.rachelgrau.rachel.health4theworldstroke.R;

public class videoPlayer extends AppCompatActivity {

    public static String videoName = "";
    public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        name = this.getIntent().getStringExtra(videoName);
        setUpToolbar();
        playVideo();
    }

    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(name);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    public void playVideo() {
        VideoView view = (VideoView) findViewById(R.id.videoView);
        MediaController controller = new MediaController(this);
        if (name.equals(getString(R.string.Toe)) ) {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.toe_flection;
            view.setVideoURI(Uri.parse(path));
        }
        if (name.equals(getString(R.string.Knee))) {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.knee_flection;
            view.setVideoURI(Uri.parse(path));
        }
        if (name.equals(getString(R.string.Hip))) {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.hip_flection;
            view.setVideoURI(Uri.parse(path));
        }
        if (name.equals(getString(R.string.Elbow))) {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.elbow_flection;
            view.setVideoURI(Uri.parse(path));
        }
        if (name.equals(getString(R.string.Shoulder))) {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.shoulder_flection;
            view.setVideoURI(Uri.parse(path));
        }
        if (name.equals(getString(R.string.Leg_1))) {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.leg_control_1;
            view.setVideoURI(Uri.parse(path));
        }
        if (name.equals(getString(R.string.Leg_2))) {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.leg_control_2;
            view.setVideoURI(Uri.parse(path));
        }
        if (name.equals(getString(R.string.Bridge_hip))) {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.bridge_hip;
            view.setVideoURI(Uri.parse(path));
        }
        if (name.equals(getString(R.string.Arm_trunk))) {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.arm_and_trunk;
            view.setVideoURI(Uri.parse(path));
        }
        if (name.equals(getString(R.string.Sittostand))) {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.sit_and_stand;
            view.setVideoURI(Uri.parse(path));
        }
        if (name.equals(getResources().getString(R.string.L2_1)))
        {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.img_3561;
            view.setVideoURI(Uri.parse(path));
        }
        if (name.equals(getResources().getString(R.string.L2_2)))
        {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.img_3562;
            view.setVideoURI(Uri.parse(path));
        }
        if (name.equals(getResources().getString(R.string.L2_3)))
        {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.img_3563;
            view.setVideoURI(Uri.parse(path));
        }
        if(name.equals(getResources().getString(R.string.L2_4)))
        {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.img_3565;
            view.setVideoURI(Uri.parse(path));
        }
        if(name.equals(getResources().getString(R.string.L3_1)))
        {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.img_3710;
            view.setVideoURI(Uri.parse(path));
        }
        if(name.equals(getResources().getString(R.string.L3_2)))
        {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.can_exerices_img_3711;
            view.setVideoURI(Uri.parse(path));
        }
        if(name.equals(getResources().getString(R.string.L3_3)))
        {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.img_3712;
            view.setVideoURI(Uri.parse(path));
        }
        if(name.equals(getResources().getString(R.string.L3_4)))
        {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.can_exerices_img_3713;
            view.setVideoURI(Uri.parse(path));
        }
        if(name.equals(getResources().getString(R.string.L3_5)))
        {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.img_3714;
            view.setVideoURI(Uri.parse(path));
        }
        if(name.equals(getResources().getString(R.string.L3_6)))
        {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.img_3566;
            view.setVideoURI(Uri.parse(path));
        }
        if(name.equals(getResources().getString(R.string.L3_7)))
        {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.img_3567;
            view.setVideoURI(Uri.parse(path));
        }
        if(name.equals(getResources().getString(R.string.L4_1)))
        {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.img_3569;
            view.setVideoURI(Uri.parse(path));
        }
        if(name.equals(getResources().getString(R.string.L4_2)))
        {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.img_3720;
            view.setVideoURI(Uri.parse(path));
        }
            view.start();
            view.setMediaController(controller);
            view.setOnPreparedListener (new MediaPlayer.OnPreparedListener() {
        public void onPrepared(MediaPlayer mp) {
            mp.setLooping(true);
        }
    });}

    }
