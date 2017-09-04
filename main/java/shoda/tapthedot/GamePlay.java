package shoda.tapthedot;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class GamePlay extends AppCompatActivity {

    Circle circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        circle = new Circle(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game_play);
        setContentView(new Circle(this));

        final AlertDialog.Builder dialog = new AlertDialog.Builder(GamePlay.this);
        dialog.setTitle("TIME'S UP!");
        dialog.setMessage("Calculating your score...");
        dialog.setCancelable(false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isFinishing()) {
                    dialog.show();
                } else {
                    Circle.counter = 0;
                    finish();
                }
            }
        }, 10000);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if (this != null && !isFinishing()) {
                    /*final ProgressDialog dialog = ProgressDialog.show(GamePlay.this,
                            "Your score: ", "" + circle.getCounter(), false, false);
                    dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    dialog.show();*/
                   /* final AlertDialog dialog = new AlertDialog.Builder(GamePlay.this).create();
                    dialog.setTitle("Final Score");
                    dialog.setMessage("Your score: " + Circle.counter);
                    dialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Play Again",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    finish();
                                    Circle.counter = 0;
                                    startActivity(getIntent());
                                }
                            });
                    dialog.show();
                    dialog.setCancelable(false); */
                    //AlertDialog.Builder timeUp = new AlertDialog.Builder(GamePlay.this);
                    //timeUp.setMessage("Calculating your score...")
                    //      .setCancelable(false);

                    AlertDialog.Builder builder = new AlertDialog.Builder(GamePlay.this);

                    builder.setMessage("Your score:  " + Circle.counter)
                            .setCancelable(false)
                            .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                    GamePlay.this.finish();
                                    Circle.counter = 0;
                                    startActivity(getIntent());
                                }
                            })
                            .setNeutralButton("High Scores", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                    GamePlay.this.finish();
                                    Circle.counter = 0;
                                    Intent intent = new Intent(GamePlay.this, HighScores.class);
                                    startActivity(intent);
                                }
                            });
                           /* .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                    GamePlay.this.finish();
                                    Circle.counter = 0;
                                    System.exit(1);
                                }
                            }); */


                    AlertDialog alert = builder.create();
                    alert.show();
                }

                SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("SCORE", Circle.counter);
                editor.commit();

                //Intent intent = new Intent(getApplicationContext(), HighScores.class);
                //intent.putExtra("SCORE", Circle.counter);
                //startActivity(intent);
            }
        }, 13000);
        //TextView textView = (TextView) findViewById(R.id.my_text);
        //textView.setText("Score: " + circle.getCounter());
        //System.out.println("Score: " + circle.getCounter());
    }
}
