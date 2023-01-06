package j09_클래스;

import java.lang.management.OperatingSystemMXBean;

public class J09_Student {
   
   String name = "김";
   int age = 100;
   
   //기본생성자
   J09_Student() {
      System.out.println("생성됨!!!!");
   }
   
   void printInfo() {
      System.out.println("이름 : " + name);
      System.out.println("나이 : " + age);
   }

}