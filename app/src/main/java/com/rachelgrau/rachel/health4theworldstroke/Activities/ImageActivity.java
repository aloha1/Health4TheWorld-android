package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.rachelgrau.rachel.health4theworldstroke.R;

public class ImageActivity extends AppCompatActivity {

    public static String imageName = "";
    public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        name = this.getIntent().getStringExtra(imageName);
        setUpToolbar();
        setImage();
    }

    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(name);
        Log.d("Image","name is: " +name);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    public void setImage() {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        MediaController controller = new MediaController(this);
        if (name.equals(getString(R.string.sitting_with_one_hand_support)) ) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.sitting_with_one_hand_support));
        }
        if (name.equals(getString(R.string.sitting_with_no_hand_support)) ) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.sitting_with_no_hand_support));
        }
        if (name.equals(getString(R.string.standing_3729)) ) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.standing_3729));
        }
        if (name.equals(getString(R.string.standing_3730)) ) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.standing_3730));
        }
        if (name.equals(getString(R.string.standing_3731)) ) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.standing_3731));
        }
        if (name.equals(getString(R.string.standing_3732)) ) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.standing_3732));
        }


    }
}
