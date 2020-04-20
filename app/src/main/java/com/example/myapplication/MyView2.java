package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView2 extends View {
    public MyView2(Context context) {
        super(context);
    }

    Paint paint = new Paint();
    int N = 2;
    float x = 0;
    int y;
    float n = 10.5f;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        y=0;
        while (y < canvas.getHeight()+100) {
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(x, y, 100, paint);
            paint.setColor(Color.CYAN);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(20);
            canvas.drawCircle(x, y, 100, paint);
            y += 350;
        }

            do {
                x += n;
                invalidate();
                if (x < 0 || x >= canvas.getWidth()) {
                    n = n * (-1);
                }
            } while (x > canvas.getWidth());

    }
}
