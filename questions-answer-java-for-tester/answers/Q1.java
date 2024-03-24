/**
 *  Testing boolean method (method that returns a boolean value)
 */
public class BooleanMethodTest {
   // This method returns a boolean value
   public static boolean isOdd(int number) {
      if (number % 2 == 1) {
         return true;
      } else {
         return false;
      }
   }
 
   public static void main(String[] args) {
      System.out.println(isOdd(5));  // true
      System.out.println(isOdd(6));  // false
      System.out.println(isOdd(-5)); // false
   }
}
