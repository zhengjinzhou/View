package zhou.com.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import zhou.com.view.activity.CircleWaveActivity;
import zhou.com.view.activity.FiveActivity;
import zhou.com.view.activity.LeafLoadingActivity;
import zhou.com.view.activity.OneActivity;
import zhou.com.view.activity.PathActivity;
import zhou.com.view.activity.ThreeActivity;
import zhou.com.view.activity.TwoActivity;
import zhou.com.view.utils.windowUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), OneActivity.class));
            }
        });
        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TwoActivity.class));
            }
        });
        Log.d("", "onCreate: " + windowUtil.getWindow(getApplicationContext()));
        findViewById(R.id.bt3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ThreeActivity.class));
            }
        });
        findViewById(R.id.bt4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PathActivity.class));
            }
        });
        findViewById(R.id.bt6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FiveActivity.class));
            }
        });

        findViewById(R.id.bt5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LeafLoadingActivity.class));
            }
        });
        findViewById(R.id.bt7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CircleWaveActivity.class));
            }
        });
    }
}