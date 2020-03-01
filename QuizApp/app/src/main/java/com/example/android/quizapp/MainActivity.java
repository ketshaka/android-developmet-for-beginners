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
    Button submitButton;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(submitButtonOnClickListener);
    }

    private void checkQuestionOne(){
        RadioButton radioButtonTrue = (RadioButton) findViewById(R.id.radioTrue);
        boolean isQuestionOneYesChecked = radioButtonTrue.isChecked();
        if (isQuestionOneYesChecked){
            score += 1;
        }
    }

    private String getQuestionTwoTextInput() {
        EditText editText = (EditText) findViewById(R.id.editQues2);
        String textInput = editText.getText().toString();
        return textInput;
    }

    private void checkQuestionTwo(){
        String textInput = getQuestionTwoTextInput();
        if (textInput.trim().equalsIgnoreCase(getString(R.string.q2_answer))){
            score += 1;
        }
    }

    private void checkQuestionThree(){
        CheckBox checkBoxQueues = (CheckBox) findViewById(R.id.checkQueues);
        CheckBox checkBoxStacks = (CheckBox) findViewById(R.id.checkStacks);
        CheckBox checkBoxTrees = (CheckBox) findViewById(R.id.checkTrees);
        boolean isCheckBoxQueuesChecked = checkBoxQueues.isChecked();
        boolean isCheckBoxStacksChecked = checkBoxStacks.isChecked();
        boolean isCheckBoxTreesChecked = checkBoxTrees.isChecked();

        if (isCheckBoxQueuesChecked && isCheckBoxStacksChecked && !isCheckBoxTreesChecked){
            score += 1;
        }
    }

    private void checkQuestionFour(){
        RadioButton radioButtonBubbleSort = (RadioButton) findViewById(R.id.radioBubble);
        boolean isQuestionFourBubbleSortChecked = radioButtonBubbleSort.isChecked();
        if (isQuestionFourBubbleSortChecked){
            score += 1;
        }
    }

    private void checkQuestions(){
        checkQuestionOne();
        checkQuestionTwo();
        checkQuestionThree();
        checkQuestionFour();
    }

    private void resetScore(){
        score = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v){
            checkQuestions();
            Toast.makeText(MainActivity.this, "Whoop! Your score is: " + score + "/4",
                    Toast.LENGTH_LONG).show();
            resetScore();
        }
    };
}
