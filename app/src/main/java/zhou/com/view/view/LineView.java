package zhou.com.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import zhou.com.view.R;

/**
 * Created by zhou on 2018/1/31.
 */

public class LineView extends View {

    private Paint mPaint = new Paint();
    private int mWidth;
    private int mHeight;

    public LineView(Context context) {
        this(context,null);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 将坐标系原点移动到画布正中心
        mWidth = getWidth();
        mHeight = getHeight();
        canvas.translate(mWidth/2,mHeight/2);
        canvas.drawCircle(0,0,300,mPaint);
        canvas.drawCircle(0,0,280,mPaint);
        for (int i=0; i<=360; i+=10){               // 绘制圆形之间的连接线
            canvas.drawLine(0,280,0,300,mPaint);
            canvas.rotate(10);
        }
    }
}
