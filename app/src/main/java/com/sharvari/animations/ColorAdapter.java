package com.sharvari.animations;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sharvari on 12-Jul-18.
 */

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.MyViewHolder> {

    private List<colorLayout> moviesList;
    private int lastPosition=-1;
    private Context context;
    private int delay = 100;
    private boolean initiate = true;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView color;
        private RelativeLayout layout;

        public MyViewHolder(View view) {
            super(view);
            color = (TextView) view.findViewById(R.id.color);
            layout = (RelativeLayout) view.findViewById(R.id.layout);
        }
    }

    public ColorAdapter(Context context, List<colorLayout> moviesList) {
        this.context = context;
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_recyclerview_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull MyViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        colorLayout movie = moviesList.get(position);
        holder.layout.setBackgroundColor(Color.parseColor(movie.color));
        holder.color.setText(movie.color);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ContentActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    context.startActivity(i);
                }
            }
        });

//
//        if(position>lastPosition){
//            Animation animation = AnimationUtils.loadAnimation(context,
//                    R.anim.reverse_animate);
////            holder.itemView.startAnimation(animation);
//            Animation slide = AnimationUtils.loadAnimation(context,R.anim.slide_left_to_right);
//            if(initiate){
//                delay += 100;
//                slide.setStartOffset(delay);
//            }
//
//            holder.layout.setAnimation(slide);
//            lastPosition = position;
//        }
        Animation animation = AnimationUtils.loadAnimation(context,
                (position > lastPosition) ? R.anim.up_from_bottom
                        : R.anim.down_from_top);
        holder.itemView.startAnimation(animation);
        lastPosition = position;
    }



    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}