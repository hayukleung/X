package com.hayukleung.x.bequiet.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.hayukleung.x.base.widget.BaseView;

public class ShyaringanView extends BaseView {

  private static final int GOGOK_COUNT = 3;
  private int mDeltaAngle = 12;
  private Paint mPaintCircle;
  private Paint mPaintGogok;
  private RectF mRectFGogok;
  private Path mPathGogok;
  private int mAngle = -mDeltaAngle;

  public ShyaringanView(Context context) {
    super(context);
  }

  public ShyaringanView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public ShyaringanView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public ShyaringanView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  /**
   * it control the speed of shyaringan
   *
   * it is suitable to be set range from 6.0 to 18.0
   *
   * @param deltaAngle
   */
  public void setDeltaAngle(int deltaAngle) {
    mDeltaAngle = deltaAngle;
  }

  @Override
  protected void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    mPathGogok = new Path();
  }

  @Override protected void onDraw(Canvas canvas) {

    int cx = getWidth() / 2;
    int cy = getHeight() / 2;
    int radius = getWidth() / 2 / 10 * 9;
    int strokeWidthUnit = getWidth() / 60;

    if (null == mPaintCircle) {
      mPaintCircle = new Paint();
      mPaintCircle.setAntiAlias(true);
    }
    // 绘制背景颜色
    {
      mPaintCircle.setStyle(Paint.Style.FILL);
      mPaintCircle.setColor(Color.argb(255, 200, 59, 68));
      canvas.drawCircle(cx, cy, radius, mPaintCircle);
    }
    // 绘制黑环
    {
      mPaintCircle.setStyle(Paint.Style.STROKE);
      mPaintCircle.setColor(Color.argb(255, 0, 0, 0));
      mPaintCircle.setStrokeWidth(strokeWidthUnit * 2);
      canvas.drawCircle(cx, cy, radius, mPaintCircle);
      mPaintCircle.setStrokeWidth(strokeWidthUnit);
      canvas.drawCircle(cx, cy, radius / 5 * 3, mPaintCircle);
    }
    // 绘制眼珠
    {
      mPaintCircle.setStyle(Paint.Style.FILL);
      mPaintCircle.setColor(Color.argb(255, 0, 0, 0));
      canvas.drawCircle(cx, cy, radius / 5, mPaintCircle);
    }
    canvas.rotate(getAngle(), cx, cy);
    // 绘制勾玉
    {
      int count = GOGOK_COUNT;
      while (count-- > 0) {

        if (null == mPaintGogok) {
          mPaintGogok = new Paint();
          mPaintGogok.setAntiAlias(true);
          mPaintGogok.setStyle(Paint.Style.FILL);
          mPaintGogok.setColor(Color.argb(255, 0, 0, 0));
          mPaintGogok.setStrokeWidth(strokeWidthUnit);
        }
        float rGogokUnit = (float) getWidth() / 1000f;
        if (null == mRectFGogok) {
          mRectFGogok = new RectF();
        }
        mPathGogok.reset();
        mRectFGogok.set(
            // l
            cx - rGogokUnit * 50,
            // t
            cy - radius / 5 * 3 - rGogokUnit * 50,
            // r
            cx + rGogokUnit * 50,
            // b
            cy - radius / 5 * 3 + rGogokUnit * 50);
        mPathGogok.arcTo(mRectFGogok, 90, 180);
        mRectFGogok.set(
            // l
            cx - rGogokUnit * 15,
            // t
            cy - radius / 5 * 3 - rGogokUnit * 50,
            // r
            cx + rGogokUnit * 15,
            // b
            cy - radius / 5 * 3 - rGogokUnit * 20);
        mPathGogok.arcTo(mRectFGogok, 270, -180);
        mRectFGogok.set(
            // l
            cx - rGogokUnit * 35,
            // t
            cy - radius / 5 * 3 - rGogokUnit * 20,
            // r
            cx + rGogokUnit * 35,
            // b
            cy - radius / 5 * 3 + rGogokUnit * 50);
        mPathGogok.arcTo(mRectFGogok, 270, 180);
        mPathGogok.close();

        canvas.save();
        canvas.rotate(360 / GOGOK_COUNT * count, cx, cy);
        canvas.rotate(30, cx, cy - radius / 5 * 3);
        canvas.drawPath(mPathGogok, mPaintGogok);
        canvas.restore();
      }
    }
    postInvalidateDelayed(50);
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    int wSize = MeasureSpec.getSize(widthMeasureSpec);
    int hSize = MeasureSpec.getSize(heightMeasureSpec);
    int size = wSize < hSize ? wSize : hSize;
    int sizeMeasureSpec = MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY);
    setMeasuredDimension(sizeMeasureSpec, sizeMeasureSpec);
  }

  private int getAngle() {
    // 6 12 18
    mAngle += mDeltaAngle;
    mAngle %= 360;
    return mAngle;
  }
}