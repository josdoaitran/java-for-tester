
/*
 * Print square pattern using nested-loop
 */
public class SquareBoard {
   public static void main (String[] args) {
      int size = 5;    // size of the board
      for (int row = 1; row <= size; ++row) {  
// Use row and col, NOT i and j, or x and y
         for (int col = 1; col <= size; ++col) {
            System.out.print(“#”);
         }
         System.out.println(“”);
      }
   }
}

/*
#
##
###
####
#####
*/

public void print () {
   int size = 5;
   for (int row = 1; row <= size; ++row) {  
      for (int col = 1; col <= row; ++col) {
            System.out.print(“#”);
         }
         System.out.println(“”);
      }
}


