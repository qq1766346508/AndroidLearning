package com.example.vivic.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class SecondActivity extends BaseActivity {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello First");
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Button button2 = (Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
//向上一个活动传递数据
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("data_return","Hello First");
                setResult(RESULT_OK,intent);
                finish();
            }
        });

//向下一个活动传递数据
//        Intent intent = getIntent();
//        String data = intent.getStringExtra("extra_data");
//        Log.d(TAG,data);








    }


}
