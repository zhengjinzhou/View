package zhou.com.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import zhou.com.view.R;
import zhou.com.view.bean.PieBean;
import zhou.com.view.view.PieView;

public class OneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        PieView pieView = findViewById(R.id.pieView);
        PieBean pieBean = new PieBean("zhou",4);
        PieBean pieBean1 = new PieBean("zhou",2);
        PieBean pieBean2 = new PieBean("zhou",1);
        PieBean pieBean3 = new PieBean("zhou",3);
        PieBean pieBean4 = new PieBean("zhou",5);
        PieBean pieBean5 = new PieBean("zhou",6);


        List<PieBean> data = new ArrayList<>();
        data.add(pieBean);
        data.add(pieBean1);
        data.add(pieBean2);
        data.add(pieBean3);
        data.add(pieBean4);
        data.add(pieBean5);

        data.add(pieBean);
        data.add(pieBean1);
        data.add(pieBean2);
        data.add(pieBean3);
        data.add(pieBean4);
        data.add(pieBean5);
        pieView.setData(data);
    }
}
