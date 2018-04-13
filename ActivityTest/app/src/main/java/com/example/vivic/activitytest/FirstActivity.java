package com.example.vivic.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {
    //重写方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    //重写方法
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item :
                Toast.makeText(this,"add button",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item :
                Toast.makeText(this,"remove button",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
    //重写方法

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1 :
                if(resultCode==RESULT_OK){
                    Log.d("FirstActivity",data.getStringExtra("data_return"));
                }
                break;
            default:
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fist_layout);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(FirstActivity.this,"hello",
//                        Toast.LENGTH_SHORT).show();
                //显式Intent启动活动2
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                //隐式Intent启动活动2
                Intent intent = new Intent("com.example.vivic.activitytest.ACTION_START");
                //添加独自的CATEGORY，若不对应则程序崩溃。
//                intent.addCategory("com.example.vivic.activitytest.MY_CATEGORY");
//                intent.putExtra("extra_data","hello man!");
//                startActivity(intent);
        //返回数据给上一个活动
                startActivityForResult(intent,1);
            }
        });
        Button button999 = (Button) findViewById(R.id.button_999);
        button999.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button button1_1 = (Button) findViewById(R.id.button_1_1);
        button1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        Button button1_2 = (Button)findViewById(R.id.button_1_2);
        button1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10010"));
                startActivity(intent);
            }
        });
    }
}
