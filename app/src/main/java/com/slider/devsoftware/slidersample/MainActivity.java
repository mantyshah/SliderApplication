package com.slider.devsoftware.slidersample;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    private int currentPage;
    private Button nextButton, previousButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewPager = findViewById(R.id.viewPager);
        mDotLayout = findViewById(R.id.dotsLayout);

        nextButton = findViewById(R.id.next);
        previousButton = findViewById(R.id.previous);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);


        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListner);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(currentPage + 1);
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(currentPage - 1);
            }
        });

    }

    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for(int i = 0 ; i < mDots.length ; i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransperantWhite));

            mDotLayout.addView(mDots[i]);

        }
        if(mDots.length > 0){

            mDots[position].setTextColor(getResources().getColor(R.color.white));

        }
    }

    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);
            currentPage = position;

            if(position == 0){
                nextButton.setEnabled(true);
                previousButton.setEnabled(false);
                previousButton.setVisibility(View.INVISIBLE);

                nextButton.setText("Next");
            }else if(position == mDots.length - 1){
                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
                previousButton.setVisibility(View.VISIBLE);
                nextButton.setText("Finish");
                previousButton.setText("Back");
            }else{
                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
                previousButton.setVisibility(View.VISIBLE);
                nextButton.setText("Next");
                previousButton.setText("Back");

            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
