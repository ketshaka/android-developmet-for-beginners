package com.example.eric.notepad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.EditText;

public class EditorActivity extends AppCompatActivity {

    // EditText field to enter the note's heading
    private EditText mHeadingEditText;
    // EditText field to enter the note's body
    private EditText mBodyEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        // Find relevant views that user input will be read from
        mHeadingEditText = (EditText) findViewById(R.id.heading);
        mBodyEditText = (EditText) findViewById(R.id.body);
    }

}
