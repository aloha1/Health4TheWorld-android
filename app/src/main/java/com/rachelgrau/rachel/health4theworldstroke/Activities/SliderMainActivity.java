package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.rachelgrau.rachel.health4theworldstroke.Adapters.TextSliderAdapter;
import com.rachelgrau.rachel.health4theworldstroke.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class SliderMainActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] quote = //list of all quots
            {R.string.quote_text1, R.string.quote_text2, R.string.quote_text3, R.string.quote_text4, R.string.quote_text5, R.string.quote_text6};
    private static final Integer[] author = //name of authors corresponding quots
            {R.string.quote_author1, R.string.quote_author2, R.string.quote_author3, R.string.quote_author4, R.string.quote_author5, R.string.quote_author6};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();
    private ArrayList<Integer> XMENArray2 = new ArrayList<Integer>();
    Spinner spinner;
    String language, lang_selected;
    static String current_lang = "";
    Locale myLocale;
    private ArrayList<Integer> quote_array = new ArrayList<>();
    private ArrayList<Integer> author_array = new ArrayList<>();

    PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_main);
        init();
        lang_selected = getIntent().getStringExtra(current_lang);
        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                ((TextView) spinner.getChildAt(0)).setTextColor(Color.BLACK);
                ((TextView) spinner.getChildAt(0)).setTextSize(20);
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        Toast.makeText(SliderMainActivity.this, "Language:English", Toast.LENGTH_SHORT).show();
                        setLocale("en");
                        language = "en";
                        break;
                    case 2:
                        Toast.makeText(SliderMainActivity.this, "Idioma:Español", Toast.LENGTH_SHORT).show();
                        setLocale("es");
                        language = "es";
                        break;
                    case 3:
                        Toast.makeText(SliderMainActivity.this, "La langue:Français", Toast.LENGTH_SHORT).show();
                        setLocale("fr");
                        language = "fr";
                        break;
                    case 4:
                        Toast.makeText(SliderMainActivity.this, "Wika:Filipino", Toast.LENGTH_SHORT).show();
                        setLocale("fil");
                        language = "fil";
                        break;
                    case 5:
                        Toast.makeText(SliderMainActivity.this, "Language:Nepali", Toast.LENGTH_SHORT).show();
                        setLocale("ne");
                        language = "ne";
                        break;
                    case 6:
                        Toast.makeText(SliderMainActivity.this, "语言:中文", Toast.LENGTH_SHORT).show();
                        setLocale("zh");
                        language = "zh";
                        break;
                    case 7:
                        Toast.makeText(SliderMainActivity.this, "Language:Swahili", Toast.LENGTH_SHORT).show();
                        setLocale("sw");
                        language = "sw";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        List<String> list = new ArrayList<String>();

        list.add("Select language     ");
        list.add("English");
        list.add("Español");
        list.add("Français");
        list.add("Filipino");
        list.add("Nepali");
        list.add("Chinese");
        list.add("Swahili");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, SliderMainActivity.class);
        startActivity(refresh);
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
    public void onPoint(View v){
        Intent intent= new Intent(SliderMainActivity.this, MainActivity2.class);
        startActivity(intent);
    }

    private void init() {
        for (int i = 0; i < quote.length; i++) {
            quote_array.add(quote[i]);
            author_array.add(author[i]);
        }
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new TextSliderAdapter(SliderMainActivity.this, quote_array, author_array));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == quote.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }

}