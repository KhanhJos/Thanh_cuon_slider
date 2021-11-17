package com.example.slider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout dotslayout;
    sliderAdapter adapter;
    ViewPager2 pager2;
    int list[];
    //array textview
    TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dotslayout = findViewById(R.id.dots_container);
        pager2 = findViewById(R.id.viewPager2);

        list = new int[6];
        list[0] = getResources().getColor(R.color.purple_200);
        list[1] = getResources().getColor(R.color.purple_500);
        list[2] = getResources().getColor(R.color.teal_200);
        list[3] = getResources().getColor(R.color.teal_700);
        list[4] = getResources().getColor(R.color.red);
        list[5] = getResources().getColor(R.color.green);


        adapter = new sliderAdapter(list);
        pager2.setAdapter(adapter);
        dots = new TextView[6];
        dotsIndicator();

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                selectedIndicator(position);
                super.onPageSelected(position);
            }
        });

    }

    private void selectedIndicator(int position) {
        for (int i = 0; i < dots.length; i++){
            if (i == position){
                dots[i].setTextColor(list[position]);
            }
            else{
                dots[i].setTextColor(getResources().getColor(R.color.grey));
            }
        }

    }

    private void dotsIndicator() {
        for (int i = 0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#9679"));
            dots[i].setTextSize(18);
            dotslayout.addView(dots[i]);

        }
    }
}