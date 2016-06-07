package com.example.user.shooter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Drawable pict = DrawableFactory.decodeResource(getResources(), R.drawable.bg);
        ImageView bg = (ImageView) findViewById(R.id.imageView);
        bg.setImageDrawable(getResources().getDrawable(R.drawable.bd_initial));
    }

    public void onStartGameButton(View v) {
        /*Toast t = Toast.makeText(this, "Проверка", Toast.LENGTH_SHORT);
        t.show();*/
        Intent intent = new Intent(this, StartGame.class);
        startActivity(intent);
    }
}
