package com.example.user.shooter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import java.util.ArrayList;

/**
 * Created by user on 6/6/2016.
 */
public class BG extends Thread {

    private boolean runFlag = false;
    private SurfaceHolder surfaceHolder;
    private Bitmap picture;
    public static NLO nlo;
    public static float H;
    public static float W;
    public static Bums babams;
    private float i = 2.0f;
    private int coord = 0;
    ArrayList<Bums> babamsList = new ArrayList<Bums>();


    public BG(SurfaceHolder surfaceHolder, Resources resources){
        this.surfaceHolder = surfaceHolder;
        // загружаем картинку, которую будем отрисовывать
        H = 50.0f;
        W = 50.0f;
        picture = BitmapFactory.decodeResource(resources, R.drawable.bg);
        nlo = new NLO(resources);
       // babams = new Bums();
    }

    public void setRunning(boolean run) {
        runFlag = run;
    }

    @Override
    public void run() {
        Canvas canvas;
       // babams.setX(nlo.getX());
      //  babams.setY(nlo.getY());
        while (runFlag) {

            canvas = null;
            try {
                // получаем объект Canvas и выполняем отрисовку
                canvas = surfaceHolder.lockCanvas(null);
                synchronized (surfaceHolder) {
                    boolean flag = true;

                    canvas.drawBitmap(picture,0,0,null);
                        //canvas.drawBitmap(nlo.getPicture(),nlo.getX(),nlo.getY(),null);
                    Paint p = new Paint();
                    p.setColor(Color.BLACK);
                    canvas.drawRect(0,0,canvas.getWidth(),canvas.getHeight(),p);
                    p.setColor(Color.CYAN);
                    canvas.drawRect(nlo.getX(), nlo.getY(),nlo.getX()+W, nlo.getY()+H,p);
                    int j = coord;
                    /*while (j > 0){
                        drawTest(canvas,j);
                        j-=50;
                    }*/
                    j = coord;
                    int a = 0;
                    while (j > 0){
                       // if (babamsList.size() / sizeof(Bums) < a) {
                            babamsList.add(babams);
                            babamsList.set(a, new Bums());
                            babamsList.get(a).setX(nlo.getX());
                            babamsList.get(a).setY(nlo.getY());
                       // }
                        p.setColor(Color.RED);
                        canvas.drawRect(babamsList.get(a).getX() + W/2 - babamsList.get(a).getW()/2, babamsList.get(a).getY()-i * j, babamsList.get(a).getX() + babamsList.get(a).getW()/2 + W/2, babamsList.get(a).getY()+ babamsList.get(a).getH()- i * j,p);
                        a++;
                        j -= 50;
                    }
                    coord++;
                }
            }
            finally {
                if (canvas != null) {
                    // отрисовка выполнена. выводим результат на экран
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }



   /* public void drawTest(Canvas canvas, int j){
        Paint p = new Paint();
        p.setColor(Color.RED);
        canvas.drawRect(babams.getX() + W/2 - babams.getW()/2,babams.getY()-i * j, babams.getX() + babams.getW()/2 + W/2, babams.getY()+ babams.getH()- i * j,p);
    }*/

}
