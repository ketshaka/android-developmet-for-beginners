package com.example.android.rugbyscoring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

/**
 * This activity keeps track of the score for a rugby game.
 */
public class MainActivity extends AppCompatActivity {

    // Tracks the score for Team A
    int scoreTeamA = 0;

    // Tracks the score for Team B
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increase the score for Team A by 2 points (conversion).
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 3 points (penalty or drop goal).
     */
    public void addThreeForTeamA(View v) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 5 points (try).
     */
    public void addFiveForTeamA(View v) {
        scoreTeamA = scoreTeamA + 5;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team B by 2 points (conversion).
     */
    public void addTwoForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 3 points (penalty or drop goal).
     */
    public void addThreeForTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 5 points (try).
     */
    public void addFiveForTeamB(View v) {
        scoreTeamB = scoreTeamB + 5;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Resets the score for both teams back to 0 (new game).
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Updates the score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Updates the score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
