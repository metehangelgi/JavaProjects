import java.util.Scanner;

/**
 * creating a line of nubers 
 * @BatuhanGelgi
 * @version 22.11.2018
 */ 
public class mete {
   public static void main( String[] args){
      Scanner scan = new Scanner( System.in);
      
      
      
      
      // constants
      final int n;
      
      // variables
      int i;
      int x;
      int a;
      int b;
      
      // program code
      
      // ask and get the height from the user
      System.out.print( "Enter the height of number tree: " );
      n = scan.nextInt();
      
      b = n;
      // line number 
      for ( i = 1; i <= n; i++ ) {
         
         // adding spaces
         for ( a = 3 * ( b - 1 ); a > 0; a-- ) {
            System.out.print( " " );
         }
         
         // reading values
         for ( x = 1; x <= i; x++ ) {
            System.out.print( i-x+1 );
            System.out.print( numberOfSpaces( intoString( x ), 3) );
         }
         b--;
         System.out.println();
      }
   }
   
   public static String intoString( int x )
   {
      String s;
      
      s = "" + x;
      return s; 
   }
   
   public static String numberOfSpaces( String s, int x )
   {
      String space;
      int a;
      space = "";
      
      for ( a = 1; a <= x - s.length(); a++ ){
         space = space + " ";
      }
      return space;
   }  
}
