package com.people;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    School school=new School();


    File fileStudents =new File("students.txt");
    Scanner scanner=new Scanner(fileStudents);
    try{
      while (scanner.hasNextLine()) {
      String name = scanner.next();
      String surname = scanner.next();
      int age = Integer.parseInt(scanner.next());
      String gender = scanner.next();
      Student student = new Student(name, surname, age, gender);
       while (scanner.hasNextInt()) {
         student.addGrade(scanner.nextInt());
       }
      school.addMember(student);
      }
    } catch (NoSuchElementException e) {
    System.out.println("Input is missing.");
  }
    File fileTeachers =new File("teachers.txt");
    Scanner scanner2=new Scanner(fileTeachers);
    try {
      while (scanner2.hasNextLine()) {
        String name = scanner2.next();
        String surname = scanner2.next();
        int age = Integer.parseInt(scanner2.next());
        String gender = scanner2.next();
        String subject = scanner2.next();
        int yearsOfExperience = Integer.parseInt(scanner2.next());
        int salary = Integer.parseInt(scanner2.next());
        Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
        school.addMember(teacher);
      }
    } catch(NoSuchElementException e) {
    System.out.println("Input is missing.");
  }


     scanner.close();
     scanner2.close();

    for(Person person:school.getMembers()){
      if(person instanceof Student) {
        Student student = (Student) person;
        if (student.getName().equals("Luna")) {
          System.out.println("the gpa for " + student.getName() + " is " + String.format("%.2f",student.calculateGpa()));
        }
      }
      if(person instanceof Teacher){
        Teacher teacher =(Teacher) person;
        if(teacher.getYearsOfExperience()>=10){
          System.out.println("The increased salary for "+teacher.getName()+ " is "+  teacher.giveRaise(20));
        }
      }
    }
    school.bubbleSort();
    System.out.println("\n\nThe list of people who study or work at the school:");
    school.print();


  }
}

