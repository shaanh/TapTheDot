package shoda.tapthedot;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void onClick(View view) {
        Intent intent = new Intent(HomeActivity.this, GamePlay.class);
        startActivity(intent);
    }

    /*public void quit(View view) {
        finishAffinity();
    }
    */

    public void highscores(View view) {
        Intent intent = new Intent(HomeActivity.this, HighScores.class);
        startActivity(intent);
    }

    public void howToPlay(View view) {
        Intent intent = new Intent(HomeActivity.this, HowToPlay.class);
        startActivity(intent);
    }
}
