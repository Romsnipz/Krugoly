package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView3 extends View {
    int N = 5;
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];

    public MyView3(Context context) {
        super(context);
    }

    boolean start = false;
    Paint paint = new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        int R = 100;
        int B = 150;
        if (!start) {
            for (int i = 0; i < N; i++){
                x[i] = (float)(Math.random() * getWidth());
                y[i] = (float)(Math.random() * getHeight());
                vx[i] = (float)(Math.random() * 6 - 3);
                vy[i] = (float)(Math.random() * 6 - 3);

                if ((x[i] - R < 0 ||  (x[i] + R) >= canvas.getWidth()) || (y[i] - R < 0 || (y[i] + R) >= canvas.getHeight())) {
                    i--;
                }
            }

            start = true;
        }
        super.onDraw(canvas);


        int []col = {Color.GREEN, Color.YELLOW, Color.BLUE, Color.BLACK, Color.RED, Color.GRAY, Color.DKGRAY, Color.CYAN, Color.MAGENTA, Color.LTGRAY};


        for (int i = 0; i < N; i++) {
            paint.setColor(col[i%10]);
            canvas.drawCircle(x[i], y[i], 100, paint);
        }

        do {
            for (int i = 0; i < N; i++) {
                x[i] += vx[i];
                y[i] += vy[i];

                invalidate();

                int xr = 0;
                int xl = 0;
                int yu = 0;
                int yd = 0;

                for (int ip = 0; ip < N; ip++) {
                    if (ip == i) {
                        continue;
                    }

                    xr = Math.abs((int) (Math.abs(x[i])+R - Math.abs(x[ip])-R));
                    xl = Math.abs((int) (Math.abs(x[i])-R - Math.abs(x[ip])+R));
                    yu = Math.abs((int) (Math.abs(y[i])+R - Math.abs(y[ip])-R));
                    yd = Math.abs((int) (Math.abs(y[i])-R - Math.abs(y[ip])+R));

                    if ((xr <= B || xl <= B) && (yu <= B || yd <= B)) {
                        vx[i] = vx[i] * (-1);
                        vy[i] = vy[i] * (-1);
                    }
                }

                if (x[i] - R < 0 ||  (x[i] + R) >= canvas.getWidth()) {
                    vx[i] = vx[i] * (-1);
                }
                else if (y[i] - R < 0 || (y[i] + R) >= canvas.getHeight()) {
                    vy[i] = vy[i] * (-1);
                }

            }
        } while (!start);

    }

}
