package com.slider.devsoftware.slidersample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context ctx) {
        this.context = ctx;
    }

    //Arrays
    public int[] slide_images = {R.drawable.eat_icon, R.drawable.sleep_icon, R.drawable.work_icon};
    public String[] slide_heading = {"Eat", "Sleep", "Work"};
    public String[] slide_discription = {"Eating", "Sleeping", "Working"};


    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.slidelayout, container , false);

        ImageView slideImage = view.findViewById(R.id.slide_image);
        TextView slideHeading = view.findViewById(R.id.textHeading);
        TextView slideDescription = view.findViewById(R.id.textDescription);

        slideImage.setImageResource(slide_images[position]);
        slideHeading.setText(slide_heading[position]);
        slideDescription.setText(slide_discription[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
