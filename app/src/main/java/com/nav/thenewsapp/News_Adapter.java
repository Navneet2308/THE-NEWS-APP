package com.nav.thenewsapp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.squareup.picasso.Picasso;

import java.util.List;

public class News_Adapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private Context context;
    List<NewsModel> mydata;

    //private Integer [] images = {R.drawable.banner, R.drawable.banner, R.drawable.banner};

    public News_Adapter(Context context, List<NewsModel> mydata) {
        this.context = context;
        this.mydata = mydata;
    }


    @Override
    public int getCount() {
        return mydata.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_news__adapter, null);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView title = view.findViewById(R.id.title);
        TextView source=view.findViewById(R.id.source);
        TextView date=view.findViewById(R.id.date);
        CardView cardView=view.findViewById(R.id.card);
       // imageView.setImageResource(imagenew[position]);
        //title.setText(title1[position]);

       title.setText(mydata.get(position).getTitle());
       date.setText(mydata.get(position).getDate());
        source.setText(mydata.get(position).getSource());

        Picasso.with(context)
                .load(mydata.get(position).getImage())
                .placeholder(R.drawable.newspaper)
                .error(R.drawable.newspaper)
                // To fit image into imageView
                .fit()
                // To prevent fade animation
                .noFade()
                .into(imageView);


           cardView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   Intent i = new Intent(context, Webview.class);
                   i.putExtra("url",""+mydata.get(position).getNewsapi());
                   i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   context.startActivity(i);

               }
           });

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
