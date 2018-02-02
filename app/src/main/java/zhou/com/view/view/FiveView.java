package zhou.com.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import zhou.com.view.bean.FiveBean;

/**
 * Created by zhou on 2018/2/1.
 */

public class FiveView extends View {

    private Paint mPaint = new Paint();
    private int num;//扇形数
    private int startAnim = 0;
    // 数据
    private List<FiveBean> mData;

    public FiveView(Context context) {
        this(context, null);
    }

    public FiveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FiveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getWidth() / 2, getHeight() / 2);
        RectF rectF = new RectF(100, 400, 500, 800);
        if (mData == null)
            return;
        for (int i=0;i<mData.size();i++){
            FiveBean fiveBean = mData.get(i);
            mPaint.setColor(fiveBean.getColor());
            canvas.drawArc(rectF,startAnim,fiveBean.getAnimNum(),true,mPaint);
            Log.d("---------", "onDraw: "+fiveBean.getColor()+"     "+fiveBean.getAnimNum() +"  "+startAnim);
            startAnim += fiveBean.getAnimNum();
        }

        /*mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF, 0, 40, true, mPaint);
        mPaint.setColor(Color.RED);
        canvas.drawArc(rectF, 40, 40, true, mPaint);
        mPaint.setColor(Color.GREEN);
        canvas.drawArc(rectF, 80, 90, true, mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawArc(rectF, 170, 20, true, mPaint);
        mPaint.setColor(Color.TRANSPARENT);
        canvas.drawArc(rectF, 190, 60, true, mPaint);
        mPaint.setColor(Color.GRAY);
        canvas.drawArc(rectF, 250, 100, true, mPaint);
        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(rectF, 350, 10, true, mPaint);*/
    }

    public void setData(List<FiveBean> mData){
        this.mData = mData;
        invalidate();
    }
}
