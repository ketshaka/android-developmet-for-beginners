package com.example.android.reportclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReportCard student1 = new ReportCard("Bobby Firmino");

        List<String> subjectList = new ArrayList<>();
        subjectList.add("English");
        subjectList.add("History");
        subjectList.add("Math");
        student1.setSubjects(subjectList);

        List<String> grades = new ArrayList<>();
        grades.add("B");
        grades.add("A-");
        grades.add("C");
        student1.setGrade(grades);

        // check that it works
        Log.v("MainActivity", "student1: " + student1);
    }
}
