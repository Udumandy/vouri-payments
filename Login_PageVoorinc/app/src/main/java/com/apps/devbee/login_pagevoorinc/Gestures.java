package com.apps.devbee.login_pagevoorinc;

import android.app.Activity;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

public class Gestures extends Activity {

    ImageView iv;
    android.graphics.Matrix matrix;
    Float scale = 1f;
    ScaleGestureDetector sgd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);

        iv = findViewById(R.id.imageview);
        matrix = new Matrix();
        sgd = new ScaleGestureDetector(this, new ScaleListener());
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector detector){
            scale = scale * detector.getScaleFactor();
            scale = Math.max(0.1f, Math.min(scale,5f));
            matrix.setScale(scale,scale);
            iv.setImageMatrix(matrix);
            return true;
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        sgd.onTouchEvent(event);
        return true;
    }
}
