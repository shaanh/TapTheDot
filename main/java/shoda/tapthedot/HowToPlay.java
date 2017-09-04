package shoda.tapthedot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

/**
 * Created by Shaan on 8/16/2017.
 */
public class HowToPlay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);
        TextView objective = (TextView) findViewById(R.id.objective);
        String obj = "<b>" + "Objective: " + "</b> " + " " + "Tap the screen as much as you can before the 10 second timer runs out!";
        objective.setText(Html.fromHtml(obj));
        TextView warning = (TextView) findViewById(R.id.warning);
        String warn = "<b>" + "Warning: " + "</b> " + " " + "Upon completion of a round, pressing 'Try Again' will not add your current score to your High Scores if it is eligible. \n";
        warning.setText(Html.fromHtml(warn));
        TextView note = (TextView) findViewById(R.id.note);
        String no = "<b>" + "Note: " + "</b> " + " " + "During a round, if you decide to forfeit and start over, you must wait approximately 10 seconds before playing again.\n" +
"         This is to allow for the timer to reset.";
        note.setText(Html.fromHtml(no));


    }
}
