package j22_익명클래스.복습;

import j22_익명클래스.Addition;
import j22_익명클래스.Calculator;

public class Main {

   public static void main(String[] args) {
      Calculator c1 = new Addition();
      
      System.out.println(c1.calc(10, 20));

   ////////////////////////////////////////////////
      
      Calculator c2 = new Calculator() {
         
         @Override
         public int calc(int x, int y) {
            return x - y;
         }
      };
      System.out.println(c2.calc(200, 100));
      
      // 익명클래스를 한줄로 줄인것 : 람다식
      Calculator c3 = (x, y) -> x * y;
      System.out.println(c3.calc(20, 3));
   }
}