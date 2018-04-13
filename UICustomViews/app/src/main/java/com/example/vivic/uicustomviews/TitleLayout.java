package com.example.vivic.uicustomviews;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.jar.Attributes;

public class TitleLayout extends LinearLayout{
    public TitleLayout (Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);

        Button titleBack =(Button)findViewById(R.id.button_back);
        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)getContext()).finish();
            }
        });
        Button titleEdit = (Button)findViewById(R.id.button_edit);
        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Your clicked Edit button",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
