package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        int y;
        int x;
        for (x=0; x<this.getWidth()+200; x+=50){
            y=0;
            while (y < canvas.getHeight()+100){

                paint.setColor(Color.BLUE);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawCircle(x, y, 200, paint);
                paint.setColor(Color.CYAN);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(20);
                canvas.drawCircle(x, y, 200, paint);
                y+=100;
            }
        }
    }
}
