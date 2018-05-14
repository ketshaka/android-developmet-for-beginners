package com.example.android.reportclass;

import java.util.ArrayList;
import java.util.List;

public class ReportCard {

    String studentName;
    // List of subjects
    List<String> subjects;
    // Grades
    List<String> grade;


    // constructor
    public ReportCard(String studentName) {
        this.studentName = studentName;
        this.subjects = new ArrayList<>();
        this.grade = new ArrayList<>();

    }

    public String getStudentName() {
        return studentName;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getGrade() {
        return grade;
    }

    public void setGrade(List<String> grade) {
        this.grade = grade;
    }

    public String getSubjectAndGrade(int index) {
        List<String> subjects = getSubjects();
        List<String> grade = getGrade();

        String subjectWithGrade = subjects.get(index) + " with " + grade.get(index);

        return subjectWithGrade;
    }

    public String getAllSubjectsAndGrade() {
        String allSubjectsWithGrades = "";
        for (int i = 0;
                i < subjects.size();
                i++) {
            allSubjectsWithGrades += (getSubjectAndGrade(i) + "\n");
        }
        return allSubjectsWithGrades;
    }

    @Override
    public String toString() {
        String report = "Student Name: " + getStudentName() + "\n" +
                "Results:\n" + getAllSubjectsAndGrade();
        return report;
    }
}
