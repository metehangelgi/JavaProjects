// Exercise 17.12: ProcessInvoices.java
// Processing Invoices with lambdas and streams.

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProcessInvoices {
	
   public static void main(String[] args) {
      Invoice[] invoices = {
         new Invoice(83, "Electric sander", 7, 57.98),
         new Invoice(24, "Power saw", 18, 99.99),
         new Invoice(7, "Sledge hammer", 11, 21.50),
         new Invoice(77, "Hammer", 76, 11.99),
         new Invoice(39, "Lawn mower", 3, 79.50),
         new Invoice(68, "Screwdriver", 106, 6.99),
         new Invoice(56, "Jig saw", 21, 11.00),
         new Invoice(3, "Wrench", 34, 7.50)
      };
      

      /* 
       * Use lambdas and streams to sort the Invoice objects by PartDescription, 
       * then display the results.
       * */
      System.out.println("Invoices sorted by part description:");
      /*
       * Your solution
       */
      Function<Invoice, String> partComparatorF=Invoice::getPartDescription;
      Comparator<Invoice> partComparator=Comparator.comparing(partComparatorF);
      
      
      Arrays.stream(invoices)
      			.sorted(partComparator)
      			.forEach(invoice ->System.out.println(invoice));

      /*
       * Use lambdas and streams to sort the Invoice objects by Price, 
       * then display the results.
       */
      System.out.printf("%nnInvoices sorted by price:%n");
      /*
       * Your solution
       */
      Function<Invoice, Double> partComparatorF2=Invoice::getPrice;
      Comparator<Invoice> priceComparator =Comparator.comparing(partComparatorF2);
      
      Arrays.stream(invoices)
      			.sorted(priceComparator)
      			.forEach(invoice ->System.out.println(invoice));
      
      

      /*
       * Use lambdas and streams to map each Invoice to its PartDescription and Quantity,
       * sort the results by Quantity, then display the results.
       */
      System.out.printf("%nInvoices mapped to description and quantity:%n");
      /*
       * Your solution
       */
      Function<Invoice, Integer> partComparatorF3=Invoice::getQuantity;
      Comparator<Invoice> QuantityComparator =Comparator.comparing(partComparatorF3);
      
      Arrays.stream(invoices)
      				.sorted(QuantityComparator)
      				.map(Invoice::getPartDescription)
      				.forEach(System.out::println);
      

      /*
       * Use lambdas and streams to map each Invoice to its PartDescription and the value of
       * the Invoice (i.e., Quantity * Price). Order the results by Invoice value.
       */
      System.out.printf("%nInvoices mapped to description and invoice amount:%n");
      /*
       * Your solution
       */

      Function<Invoice, Double> byPrice2 = Invoice::getPrice;   //e-> e.getFirstName()
      Function<Invoice, Integer> byQuantity2 = Invoice::getQuantity;
      Comparator<Invoice> comparebyQuantityandPrice =                           
 	         Comparator.comparing(byPrice2);
      
      
      System.out.printf(
    	         "%nEmployee names in order by last name then first name:%n"); 
    	      Arrays.stream(invoices)
    	          .sorted(comparebyQuantityandPrice)
    	          .map(Invoice::getPartDescription)
    	          .forEach(System.out::println);

      
      
      

      /*
       * Modify your previous solution to select the Invoice values in the range $200 to $500.
       */
      System.out.printf("%nInvoices mapped to description and invoice amount for invoices in the range 200-500:%n");
      /*
       * Your solution
       */
      Predicate<Invoice> twoToFive= e ->(e.getPrice() >=20 && e.getPrice() <=50);
      //Predicate<Invoice> fourToSixThousand =                  
 	   //      e -> (e.getPrice() >= 200 && e.getPrice() <= 500);
      Arrays.stream(invoices)
      .filter(twoToFive)
      .sorted(Comparator.comparing(Invoice::getPrice))
      .forEach(System.out::println);
      

      
      
   }
}
