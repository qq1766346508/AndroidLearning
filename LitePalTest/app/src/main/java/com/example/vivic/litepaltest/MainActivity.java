package com.example.vivic.litepaltest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

import static org.litepal.LitePalApplication.getContext;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase=findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LitePal.getDatabase();
            }
        });

        Button addData=findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book=new Book();
                book.setAuthor("Dan Brown");
                book.setName("The Da Vinci Code");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("Unknow");
                book.save();
            }
        });


        Button upData=findViewById(R.id.update_data);
        upData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book=new Book();
                book.setPrice(14.95);
                book.setPress("Anchor");
                book.updateAll("name=? and author=?","The Da Vinci Code","Dan Brown");
            }
        });

        Button deleteData=findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSupport.deleteAll(Book.class,"price<?","15");
            }
        });

        Button queryButton=findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Book> books=DataSupport.findAll(Book.class);
                for(Book book:books){
//                    Log.d(TAG, "book name is "+book.getName());
                    Toast.makeText(getContext(), "book name is "+book.getName(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
