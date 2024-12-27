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
  public void addGrade(int grade){
    this.grades.add(grade);
  }

  public double calculateGpa() {
    int totalGrades=0;
    int totalCredits=0;
    for (Integer  grades: grades) {
      if(grades>=95 ){
        totalGrades+=4.0;
      }
      else if(grades>=90 && grades<=94){
        totalGrades+=3.67;
      }
      else if(grades>=85 && grades<=89){
        totalGrades+=3.33;
      }else if(grades>=80 && grades<=84){
        totalGrades+=3.0;
      }else if(grades>=75 && grades<=79){
        totalGrades+=2.67;
      }else if(grades>=70 && grades<=74){
        totalGrades+=2.33;
      }else if(grades>=65 && grades<=69){
        totalGrades+=2.0;
      }else if(grades>=60 && grades<=64){
        totalGrades+=1.67;
      }else if(grades>=55 && grades<=59){
        totalGrades+=1.33;
      }else if(grades>=50 && grades<=54){
        totalGrades+=1.0;
      }else{
        totalGrades+=0.0;
      }
      totalCredits ++;
    }
    return (double)totalGrades/totalCredits;
  }
  @Override
  public String toString() {
    return super.toString()+ "I am a student with ID "+ studentID;
  }
}
