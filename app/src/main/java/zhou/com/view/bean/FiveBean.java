package zhou.com.view.bean;

/**
 * Created by zhou on 2018/2/1.
 * 个人思路，不知道行不行
 * 需要暴露给用户以下信息
 * 每块旋转角度
 * 每块扇形颜色
 */

public class FiveBean {
    private int animNum;//每块旋转角度
    private int color;//每块扇形颜色

    public FiveBean(int animNum, int color) {
        this.animNum = animNum;
        this.color = color;
    }

    public int getAnimNum() {
        return animNum;
    }

    public void setAnimNum(int animNum) {
        this.animNum = animNum;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
