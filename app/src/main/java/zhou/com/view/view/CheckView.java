package zhou.com.view.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import zhou.com.view.R;


/**
 * Created by zhou on 2018/1/31.
 *  自定义动画机制
 *  勾选框，主要是在init初始化的地方有点难
 *
 */

public class CheckView extends View {

    Context mContext;
    private int animDuration = 500;         // 动画时长
    private int mWidht;
    private int mHeight;
    private Paint mPaint;
    private Bitmap bitmap;
    private Handler mHandler;
    private int animCurrentPage = -1;
    private int animMaxPage = 13;
    private boolean isCheck = false;

    private static final int ANIM_NULL = 0;         //动画状态-没有
    private static final int ANIM_CHECK = 1;        //动画状态-开启
    private static final int ANIM_UNCHECK = 2;      //动画状态-结束
    private int animState = ANIM_NULL;      // 动画状态

    public CheckView(Context context) {
        this(context,null);
    }

    public CheckView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CheckView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * chushihua
     */
    private void init(Context context) {
        mContext = context;

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);

        bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.mark);
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (animCurrentPage < animMaxPage && animCurrentPage >= 0){
                    invalidate();
                    if (animState == ANIM_NULL)
                        return;
                    if (animState == ANIM_UNCHECK)
                        animCurrentPage--;
                    if (animState == ANIM_CHECK)
                        animCurrentPage++;
                    this.sendEmptyMessageDelayed(0,animDuration / animMaxPage);
                }else {
                    if (isCheck){
                        animCurrentPage = animMaxPage -1;
                    }else {
                        animCurrentPage = -1;
                    }
                    invalidate();
                    animState = ANIM_NULL;
                }
            }
        };
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
        canvas.translate(mWidht/2,mHeight/2);
        canvas.drawCircle(0,0,200,mPaint);
        int sideLength = bitmap.getHeight();
        Rect src = new Rect(sideLength * animCurrentPage, 0, sideLength * (animCurrentPage + 1), sideLength);
        Rect dst = new Rect(-200, -200, 200, 200);
        canvas.drawBitmap(bitmap,src,dst,null);
    }

    public void check(){
        if (animState != ANIM_NULL || isCheck){
            return;
        }
        animState = ANIM_CHECK;
        animCurrentPage = 0;
        mHandler.sendEmptyMessageDelayed(0, animDuration / animMaxPage);
        isCheck = true;
    }

    public void unCheck() {
        if (animState != ANIM_NULL || (!isCheck))
            return;
        animState = ANIM_UNCHECK;
        animCurrentPage = animMaxPage - 1;
        mHandler.sendEmptyMessageDelayed(0, animDuration / animMaxPage);
        isCheck = false;
    }

    /**
     * 设置动画时长
     * @param animDuration
     */
    public void setAnimDuration(int animDuration) {
        if (animDuration <= 0)
            return;
        this.animDuration = animDuration;
    }

    /**
     * 设置背景圆形颜色
     * @param color
     */
    public void setBackgroundColor(int color){
        mPaint.setColor(color);
    }
}