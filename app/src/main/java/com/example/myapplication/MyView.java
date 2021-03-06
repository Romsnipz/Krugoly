package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    int N;
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];
    float[] prevx = new float[N];
    float[] prevy = new float[N];

    public MyView(Context context) {
        super(context);
    }

    boolean start = false;
    Paint paint = new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        int R = 100;

        if (!start) {
            for (int i = 0; i < N; i++){
                x[i] = (float)(Math.random() * getWidth());
                y[i] = (float)(Math.random() * getHeight());
                vx[i] = (float)(Math.random() * 6 - 3);
                vy[i] = (float)(Math.random() * 6 - 3);

                if ((x[i] - R < 0 ||  (x[i] + R) >= canvas.getWidth()) || (y[i] - R < 0 || (y[i] + R) >= canvas.getHeight())) {
                    i--;
                }
                if (i > 0) {
                    for (int j = 1; j < i+1; j++) {
                        if ((Math.abs(Math.abs(x[i]) - Math.abs(x[i-j])) <= R*2) && ((Math.abs(Math.abs(y[i]) - Math.abs(y[i-j])) <= R*2))) {
                            i--;
                            break;
                        }
                    }
                }
            }

            start = true;
        }
        super.onDraw(canvas);

        int []col = {Color.GREEN, Color.YELLOW, Color.BLUE, Color.BLACK, Color.RED, Color.GRAY, Color.DKGRAY, Color.CYAN, Color.MAGENTA, Color.LTGRAY};

        for (int i = 0; i < N; i++) {
            paint.setColor(col[i%10]);
            canvas.drawCircle(x[i], y[i], R, paint);
        }

        do {
            for (int i = 0; i < N; i++) {

                x[i] += vx[i];
                y[i] += vy[i];

                invalidate();

                float xraz = 0;
                float yraz = 0;
                float vxraz = 0;
                float vyraz = 0;

                for (int ip = 0; ip < N; ip++) {
                    if (ip == i) {
                        continue;
                    }

                    double D = Math.sqrt(Math.pow((x[i] - x[ip]),2) + Math.pow((y[i] - y[ip]),2))/2.0f;
                    double DP = Math.sqrt(Math.pow(((x[i]+vx[i]) - (x[ip]+vx[ip])),2) + Math.pow(((y[i]+vy[i]) - (y[ip]+vy[ip])),2))/2.0f;
                    double Pog = (D-DP);

                    vxraz = Math.abs((x[i]+vx[i]) - (x[ip]+vx[ip]));
                    vyraz = Math.abs((y[i]+vy[i]) - (y[ip]+vy[ip]));

                    if (((DP <= R) || (DP <= R+Pog)) && (vxraz > vyraz)) {
                        vx[i] = (vx[i]+vx[ip]) * (-1) - 0.01f;
                    }
                    if (((DP <= R) || (DP <= R+Pog)) && (vyraz > vxraz)) {
                        vy[i] = (vy[i]+vy[ip]) * (-1) - 0.01f;
                    }
                    if (((DP <= R) || (DP <= R+Pog)) && (vyraz == vxraz)) {
                        vx[i] = vx[i] * (-1) - 0.01f;
                        vy[i] = vy[i] * (-1) - 0.01f;
                    }
                }

                if (((x[i]+vx[i]) - R <= 0 || ((x[i]+vx[i]) + R) >= canvas.getWidth()) && ((y[i]+vy[i]) - R <= 0 || ((y[i]+vy[i]) + R) >= canvas.getHeight())) {
                    vx[i] = vx[i] * (-1) - 0.002f;
                    vy[i] = vy[i] * (-1) - 0.002f;
                }
                else if (x[i] - R <= 0 || (x[i]+vx[i]) - R <= 0 || (x[i]-vx[i]) - R <= 0 || ((x[i]+vx[i]) + R) >= canvas.getWidth() || ((x[i]-vx[i]) + R) >= canvas.getWidth()) {
                    vx[i] = vx[i] * (-1) - 0.002f;

                }
                else if (y[i] - R <= 0 || (y[i]+vy[i]) - R <= 0 || (y[i]-vy[i]) - R <= 0 || ((y[i]+vy[i]) + R) >= canvas.getHeight() || ((y[i]+vy[i]) + R) >= canvas.getHeight()) {
                    vy[i] = vy[i] * (-1) - 0.002f;

                }
            }
        } while (!start);

    }
    public void stopk() {
        for (int i = 0; i < N; i++) {
            if (vx[i] == 0 && vy[i] == 0){
                return;
            }
            prevx[i] = this.vx[i];
            this.vx[i] = 0;
            prevy[i] = this.vy[i];
            this.vy[i] = 0;
        }
    }

    public void resumk() {
        for (int i = 0; i < N; i++) {
        if (((prevx[i] == 0) || (vx[i] != 0)) && ((prevy[i] == 0) || (vy[i] != 0))){
            return;
        }
        this.vx[i] = prevx[i];
        this.vy[i] = prevy[i];
        }
    }

    public void setN (int n) {
        N = n;
        x  = new float[N];
        y  = new float[N];
        vx = new float[N];
        vy = new float[N];
        prevx = new float[N];
        prevy = new float[N];
    }
}
