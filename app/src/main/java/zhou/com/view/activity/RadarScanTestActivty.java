package zhou.com.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import zhou.com.view.R;
import zhou.com.view.view.CircleWaveDivergenceView;

public class RadarScanTestActivty extends AppCompatActivity implements View.OnClickListener{

    private CircleWaveDivergenceView search_device_view;
    private Button btn_continue,btn_pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_radarscantest);
        search_device_view = (CircleWaveDivergenceView) findViewById(R.id.search_device_view);
        btn_continue = (Button)  findViewById(R.id.btn_continue);
        btn_pause = (Button)  findViewById(R.id.btn_pause);
        search_device_view.setWillNotDraw(false);

        btn_pause.setOnClickListener(this);
        btn_continue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_continue:
                search_device_view.setSearching(true);
                break;
            case R.id.btn_pause:
                search_device_view.setSearching(false);
                break;
        }
    }
}
