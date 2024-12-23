package com.people;

import java.util.ArrayList;

public class Student extends Person {
  private static int id_gen=1;
  private int studentID;
  private ArrayList<Integer> grades;

  public Student(String name, String surname, int age, String gender){
    super(name, surname, age, gender);
    this.studentID = id_gen++;
    grades=new ArrayList<>();
  }
  public int getStudentID() {
    return studentID;
  }
  public void addGrade(int grade){
    this.grades.add(grade);
  }

  public double calculateGpa() {
    int totalGrades=0;
    int totalCredits=0;
    for (Integer  grades: grades) {
      totalGrades += grades;
      totalCredits ++;
    }
    return totalGrades/totalCredits;
  }
  @Override
  public String toString() {
    return super.toString()+ "I am a student with ID "+ studentID;
  }
}
