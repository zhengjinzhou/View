package zhou.com.view.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import zhou.com.view.R;
import zhou.com.view.view.CheckView;

public class ThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        Button uncheck = findViewById(R.id.uncheck);
        Button check = findViewById(R.id.check);
        final CheckView checkView = findViewById(R.id.checkView);
        //checkView.setBackgroundColor(Color.BLUE);
        checkView.setAnimDuration(500);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkView.check();
            }
        });
        uncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkView.unCheck();
            }
        });
    }
}
