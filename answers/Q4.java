
/*
 * Print square pattern using nested-loop
 */
public class SquareBoard {   // Save as "SquareBoard.java"
   public static void main (String[] args) {
      int size = 5;    // size of the board
      for (int row = 1; row <= size; ++row) {  // Use row and col, NOT i and j, or x and y
         for (int col = 1; ......; ......) {
            ......
         }
         ......
      }
   }
}

// Notes: The code pattern for printing 2D patterns using nested loop is:


// Outer loop to print each of the rows
for (int row = 1; row <= size; row++) {
   // Inner loop to print each of the columns of one particular row
   for (int col = 1; col <= size; col++) {
      System.out.print( ...... )
      ......
   }
   // Print a newline after all the columns
   System.out.println();
}
// You should name the variables row and col, NOT i and j or x and y!!!
