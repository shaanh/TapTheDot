package shoda.tapthedot;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Shaan on 7/27/2017.
 */

public class Circle extends View {

    private List<Point> points = new ArrayList<>();
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    static int counter;

    public Circle(Context context) {
        super(context);
    }

    Random random = new Random();
    int r = random.nextInt(255);
    int g = random.nextInt(255);
    int b = random.nextInt(255);

    protected void onDraw(Canvas canvas){
        int randColor = Color.rgb(b, g, r);
        canvas.drawColor(randColor);
        super.onDraw(canvas);
        //int randomColor = Color.rgb(r, g, b);
        paint.setColor(Color.BLACK);
        for(Point p: points){
            canvas.drawCircle(p.x, p.y, 50, paint);
        }
        invalidate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Point p = new Point();
            p.x = (int) event.getX();
            p.y = (int) event.getY();
            points.add(p);
            counter++;
            //TextView textView = (TextView) findViewById(R.id.my_text);
            //textView.setText("Score: " + counter);
            invalidate();
            System.out.println("score: " + counter);
        }
        return false;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        Circle.counter = counter;
    }


    /*private final int interval = 10000; // 1 Second
    Handler handler = new Handler();
    Runnable runnable = new Runnable(){
        public void run() {
            Toast.makeText(getContext(), "C'Mom no hands!", Toast.LENGTH_SHORT).show();
        }
    };

    handler.postAtTime(runnable, interval);
    handler.postDelayed(runnable, interval);
    */

}

