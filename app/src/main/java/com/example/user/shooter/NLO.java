package com.example.user.shooter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by user on 6/6/2016.
 */
public class NLO {
    private Bitmap picture;
    private float x = 1000;
    private float y = 1000;

    NLO(Resources resources) {
        picture = BitmapFactory.decodeResource(resources, R.drawable.nlo);
    }

    public Bitmap getPicture() {
        return picture;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
