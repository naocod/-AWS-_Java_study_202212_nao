package j09_클래스;

public class J09_StudentMain {

      public static void main(String[] args) {
         
   
         
         J09_Student student1 = new J09_Student(); //student1 은 스택 메모리(정적)에 들어있음
         J09_Student student2 = new J09_Student(); //new로 생성자 호출을 해서 힙 메모리(동적)에 넣음 new 형태의 문장은 힙에 들어감
         //생성자는 클래스명이랑 일치함
         
         
         System.out.println(student1);
         System.out.println(student2);
         
         J09_Student s1 = new J09_Student();
         J09_Student s2 = new J09_Student();
         
         s1.name = "김상현";
         s1.age = 28;
         
         s1.printInfo();
         s2.printInfo();
      }

   }