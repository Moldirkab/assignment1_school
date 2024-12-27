package com.people;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    File fileStudents =new File("/Users/aidynkabdykarimov/Downloads/students.txt");
    File fileTeachers =new File("/Users/aidynkabdykarimov/Downloads/teachers.txt");
    Scanner scanner=new Scanner(fileStudents);
    Scanner scanner2=new Scanner(fileTeachers);
    School school=new School();
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
     while (scanner2.hasNextLine()) {
      String name = scanner2.next();
      String surname = scanner2.next();
      int age = Integer.parseInt(scanner2.next());
      String gender = scanner2.next();
      String subject=scanner2.next();
      int yearsOfExperience = Integer.parseInt(scanner2.next());
      int salary=Integer.parseInt(scanner2.next());
      Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
      school.addMember(teacher);

    }
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

