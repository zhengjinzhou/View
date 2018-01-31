package zhou.com.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

import zhou.com.view.bean.PieBean;

/**
 * Created by zhou on 2018/1/31.
 * 思路：
 * 1、构造函数           初始化
 * 2、onMeasure          测量View的大小
 * 3、onSizeChanged      确定View大小
 * 4、onLayout           确定子View布局
 * 5、onDraw             实际绘制内容
 * 6、提供接口           提供接口
 */

public class PieView extends View {

    // 颜色表(注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    private Paint mPaint = new Paint();
    private List<PieBean> mData;
    private int mWidht, mHeight;
    // 饼状图初始绘制角度
    private float mStartAngle = 0;

    public PieView(Context context) {
        this(context, null);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidht = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null == mData)
            return;
        float currentStartAngle = mStartAngle;// 当前起始角度
        canvas.translate(mWidht / 2, mHeight / 2);//将画布坐标原点移动到中心位置
        float raduis = Math.min(mWidht, mHeight) / 2;// 饼状图半径
        RectF rectF = new RectF(-raduis, -raduis, raduis, raduis);
        for (int i = 0; i < mData.size(); i++) {
            PieBean pieBean = mData.get(i);
            mPaint.setColor(pieBean.getColor());
            canvas.drawArc(rectF, currentStartAngle, pieBean.getAngle(), true, mPaint);
            currentStartAngle += pieBean.getAngle();
        }
    }

    /**
     * 设置起始角度
     * 这是暴露给用户的接口
     */

    public void setStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();
    }

    /**
     * 设置数据
     * 这是暴露给用户的接口
     */

    public void setData(List<PieBean> mData) {
        this.mData = mData;
        initData(mData);
        invalidate();
    }

    //初始化数据
    private void initData(List<PieBean> mData) {
        if (null == mData || mData.size() == 0)
            return;
        float sumValue = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieBean pieBean = mData.get(i);
            sumValue += pieBean.getValue();//计算数值和
            int j = i % mColors.length;//设置颜色
            pieBean.setColor(mColors[j]);
        }

        float sumAngle = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieBean pieBean = mData.get(i);

            float percentage = pieBean.getValue() / sumValue;   // 百分比
            float angle = percentage * 360;                 // 对应的角度
            pieBean.setPercentage(percentage); // 记录百分比
            pieBean.setAngle(angle); // 记录角度大小
            sumAngle += angle;
        }
    }
}
