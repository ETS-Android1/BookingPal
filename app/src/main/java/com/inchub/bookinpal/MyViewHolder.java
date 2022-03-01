package com.inchub.bookinpal;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    ImageView imageView2;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    View v;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.media_image);
        imageView2 = itemView.findViewById(R.id.avatar_image);
        textView1 = itemView.findViewById(R.id.title_text);
        textView2 = itemView.findViewById(R.id.subtitle_text);
        textView3 = itemView.findViewById(R.id.textView2);
        textView4 = itemView.findViewById(R.id.textView3);
        textView5 = itemView.findViewById(R.id.supporting_text);

        v = itemView;
    }

}
