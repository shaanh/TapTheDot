package shoda.tapthedot;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Shaan on 8/14/2017.
 */
public class HighScores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        TextView highscoretext1 = (TextView) findViewById(R.id.highScore1);
        TextView highscoretext2 = (TextView) findViewById(R.id.highScore2);
        TextView highscoretext3 = (TextView) findViewById(R.id.highScore3);
        TextView highscoretext4 = (TextView) findViewById(R.id.highScore4);
        TextView highscoretext5 = (TextView) findViewById(R.id.highScore5);


        //int score = getIntent().getIntExtra("SCORE", 0);
        int score = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE).getInt("SCORE", 0);

        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        int highScore1 = settings.getInt("HIGH_SCORE1", 0);
        int highScore2 = settings.getInt("HIGH_SCORE2", 0);
        int highScore3 = settings.getInt("HIGH_SCORE3", 0);
        int highScore4 = settings.getInt("HIGH_SCORE4", 0);
        int highScore5 = settings.getInt("HIGH_SCORE5", 0);

        if (score > highScore1) {
            highscoretext1.setText("1.  " + score + " taps");

            highscoretext2.setText("2.  " + highScore1 + " taps");
            editor.putInt("HIGH_SCORE2", highScore1);


            highscoretext3.setText("3.  " + highScore2  + " taps");
            editor.putInt("HIGH_SCORE3", highScore2);


            highscoretext4.setText("4.  " + highScore3  + " taps");
            editor.putInt("HIGH_SCORE4", highScore3);


            highscoretext5.setText("5.  " + highScore4  + " taps");
            editor.putInt("HIGH_SCORE5", highScore4);


            editor.putInt("HIGH_SCORE1", score);
            editor.commit();

        } else {
            highscoretext1.setText("1.  " + highScore1  + " taps");
            if (score > highScore2) {
                highscoretext2.setText("2.  " + score  + " taps");

                highscoretext3.setText("3.  " + highScore2  + " taps");
                editor.putInt("HIGH_SCORE3", highScore2);


                highscoretext4.setText("4.  " + highScore3  + " taps");
                editor.putInt("HIGH_SCORE4", highScore3);


                highscoretext5.setText("5.  " + highScore4  + " taps");
                editor.putInt("HIGH_SCORE5", highScore4);


                editor.putInt("HIGH_SCORE2", score);
                editor.commit();
            } else {
                highscoretext2.setText("2.  " + highScore2  + " taps");
                if (score > highScore3) {
                    highscoretext3.setText("3.  " + score  + " taps");

                    highscoretext4.setText("4.  " + highScore3  + " taps");
                    editor.putInt("HIGH_SCORE4", highScore3);


                    highscoretext5.setText("5.  " + highScore4  + " taps");
                    editor.putInt("HIGH_SCORE5", highScore4);


                    editor.putInt("HIGH_SCORE3", score);
                    editor.commit();
                } else {
                    highscoretext3.setText("3.  " + highScore3  + " taps");
                    if (score > highScore4) {
                        highscoretext4.setText("4.  " + score  + " taps");

                        highscoretext5.setText("5.  " + highScore4  + " taps");
                        editor.putInt("HIGH_SCORE5", highScore4);


                        editor.putInt("HIGH_SCORE4", score);
                        editor.commit();
                    } else {
                        highscoretext4.setText("4.  " + highScore4  + " taps");
                        if (score > highScore5) {
                            highscoretext5.setText("5.  " + score  + " taps");

                            editor.putInt("HIGH_SCORE5", score);
                            editor.commit();
                        } else {
                            highscoretext5.setText("5.  " + highScore5  + " taps");
                        }
                    }
                }
            }
        }
        editor.putInt("SCORE", 0);
        editor.commit();
    }
}


