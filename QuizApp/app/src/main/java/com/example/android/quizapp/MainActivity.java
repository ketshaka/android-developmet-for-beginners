package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
    }

    private void checkQuesOne(){
        RadioButton radioButtonYes = (RadioButton) findViewById(R.id.radioTrue);
        boolean isQuesOneYesChecked = radioButtonYes.isChecked();
        if (isQuesOneYesChecked){
            score += 1;
        }
    }

    private String getQuesTwoInput() {
        EditText input = (EditText) findViewById(R.id.editQues2);
        String algo = input.getText().toString();
        return algo;
    }

    private void checkQuesTwo(){
        String algo = getQuesTwoInput();
        if (algo.trim().equalsIgnoreCase(getString(R.string.q2_answer))){
            score += 1;
        }
    }

    private void checkQuesThree(){
        CheckBox quesThreeQueues = (CheckBox) findViewById(R.id.checkQueues);
        CheckBox quesThreeStacks = (CheckBox) findViewById(R.id.checkStacks);
        CheckBox quesThreeTrees = (CheckBox) findViewById(R.id.checkTrees);
        boolean isQuesThreeQueuesChecked = quesThreeQueues.isChecked();
        boolean isQuesThreeStacksChecked = quesThreeStacks.isChecked();
        boolean isQuesThreeTreesChecked = quesThreeTrees.isChecked();

        if (isQuesThreeQueuesChecked && isQuesThreeStacksChecked && !isQuesThreeTreesChecked){
            score += 1;
        }
    }

    private void checkQuesFour(){
        RadioButton radioButtonBubble = (RadioButton) findViewById(R.id.radioBubble);
        boolean isQuesFourBubbleChecked = radioButtonBubble.isChecked();
        if (isQuesFourBubbleChecked){
            score += 1;
        }
    }

    private void checkQues(){
        checkQuesOne();
        checkQuesTwo();
        checkQuesThree();
        checkQuesFour();
    }

    private void resetScore(){
        score = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v){
            checkQues();
            Toast.makeText(MainActivity.this, getString(R.string.whoop) + score + getString(R.string.over_4),
                    Toast.LENGTH_LONG).show();
            resetScore();
        }
    };
}
