package com.publish.shahar91.testingstuff;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Christiano on 1/04/2017.
 */

public class CourtCounter extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.court_counter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    public void threeButton(View view) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    public void twoButton(View view) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);

    }

    public void freeButton(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);

    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.teamATv);
        scoreView.setText(String.valueOf(score));
    }

    public void threeBButton(View view) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    public void twoBButton(View view) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);

    }

    public void freeBButton(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    public void resetButton(View view) {
        scoreTeamA = 0;
        displayForTeamA(scoreTeamA);

        scoreTeamB = 0;
        displayForTeamB(scoreTeamB);
    }

    public void displayForTeamB(int score) {
        TextView scoreBView = (TextView) findViewById(R.id.teamBTv);
        scoreBView.setText(String.valueOf(score));
    }
}
