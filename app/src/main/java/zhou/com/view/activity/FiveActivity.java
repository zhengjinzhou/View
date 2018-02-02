package zhou.com.view.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import zhou.com.view.R;
import zhou.com.view.bean.FiveBean;
import zhou.com.view.view.FiveView;

public class FiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        FiveView fiveView = findViewById(R.id.fiveView);
        List<FiveBean> mData = new ArrayList<>();
        mData.add(new FiveBean(30, Color.YELLOW));
        mData.add(new FiveBean(60,Color.RED));
        mData.add(new FiveBean(30,Color.BLACK));
        mData.add(new FiveBean(80,Color.GREEN));
        mData.add(new FiveBean(50,Color.BLUE));
        mData.add(new FiveBean(60,Color.MAGENTA));
        mData.add(new FiveBean(50,Color.CYAN));
        fiveView.setData(mData);
    }
}
