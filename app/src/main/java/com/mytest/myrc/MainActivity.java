package com.mytest.myrc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.activity_main_multi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent multipIntent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(multipIntent);
            }
        });
        findViewById(R.id.activity_main_screenfull).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent screenfullIntent = new Intent(MainActivity.this,FullscreenActivity.class);
                startActivity(screenfullIntent);
            }
        });
        findViewById(R.id.activity_main_backgroundtab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main3ActivityIntent = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(main3ActivityIntent);
            }
        });
    }
}
