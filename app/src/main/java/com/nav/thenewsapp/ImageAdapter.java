package com.nav.thenewsapp;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class ImageAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private Context context;

    Integer[] imagenew ={R.drawable.newspaper,R.drawable.newspaper2,R.drawable.reporter,R.drawable.reporter2};
    String[] title1 ={"This is a api based application.","Here i am using webview,api,viewpager etc","it ia a template of news applications","Please stay hone "};

    //private Integer [] images = {R.drawable.banner, R.drawable.banner, R.drawable.banner};

    public ImageAdapter(Context context) {
        this.context = context;

    }



    @Override
    public int getCount() {
        return imagenew.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.image_slider_layout, null);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView title = view.findViewById(R.id.title);

        imageView.setImageResource(imagenew[position]);
        title.setText(title1[position]);



        // imageView.setImageResource(images.get(position));


        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
