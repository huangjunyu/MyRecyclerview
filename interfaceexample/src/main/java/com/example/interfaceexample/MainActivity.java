package com.example.interfaceexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.activity_main_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginHelper.login(MainActivity.this, new LoginSussecce() {
                    @Override
                    public void onSuccess(String url) {
                        Toast.makeText(MainActivity.this,"login successe",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
