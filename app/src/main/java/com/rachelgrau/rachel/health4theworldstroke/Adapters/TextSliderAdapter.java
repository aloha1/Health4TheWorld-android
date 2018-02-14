package com.rachelgrau.rachel.health4theworldstroke.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.R;

import java.util.ArrayList;

/**
 * Created by varun on 06-02-2018.
 */

public class TextSliderAdapter extends PagerAdapter {
    private ArrayList<Integer> quote_text;
    private ArrayList<Integer> author_text;
    private LayoutInflater inflater;
    private Context context;

    public TextSliderAdapter(Context context, ArrayList<Integer> quote_text,ArrayList<Integer> author_text) {
        this.context = context;
        this.quote_text=quote_text;
        this.author_text=author_text;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return quote_text.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myTextLayout = inflater.inflate(R.layout.slider_main_screen_textbox, view, false);
        TextView quote_tv = (TextView) myTextLayout.findViewById(R.id.whole_quote);
        TextView author_tv = (TextView) myTextLayout.findViewById(R.id.author_name);
        quote_tv.setText(quote_text.get(position));
        author_tv.setText(author_text.get(position));
        view.addView(myTextLayout, 0);
        return myTextLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

}
