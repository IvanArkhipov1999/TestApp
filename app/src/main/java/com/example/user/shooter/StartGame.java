package com.example.user.shooter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class StartGame extends Activity implements View.OnTouchListener {
    private static boolean wasTouched = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SV sv = new SV(this);
        setContentView(sv);
        sv.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                if ((BG.nlo.getX()<=x && BG.nlo.getX()+BG.W>=x) && (BG.nlo.getY()<=y && BG.nlo.getY()+BG.H>=y)) {
                    BG.nlo.setX(x);
                    BG.nlo.setY(y);
                    wasTouched = true;
                }
                break;
            case MotionEvent.ACTION_MOVE: // движение
                if (wasTouched) {
                    BG.nlo.setX(x);
                    BG.nlo.setY(y);
                }
                break;
            case MotionEvent.ACTION_UP: // отпускание
                if (wasTouched) {
                    BG.nlo.setX(x);
                    BG.nlo.setY(y);
                    wasTouched = false;
                }
                break;
            case MotionEvent.ACTION_CANCEL:
                /*sMove = "";
                sUp = "Up: " + x + "," + y;*/
                break;
        }
        //tv.setText(sDown + "\n" + sMove + "\n" + sUp);
        return true;
    }
}
