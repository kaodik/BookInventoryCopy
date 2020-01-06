/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookreview;


/**
 *
 * @author Dawn
 */
public class BookReview {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Book[] inventory = new Book[7]; 
        
        inventory[0] = new Book("Carrie", "Stephen King", "11111", 7.95F, true);
        inventory[1] = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "22222", 7.95F, true);
        inventory[2] = new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", "33333", 7.95F, true);
        inventory[3] = new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "44444", 7.95F, true);
        inventory[4] = new Book("Harry Potter and the Goblet of Fire", "J.K. Rowling", "55555", 12.95F, true);
        inventory[5] = new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling", "66666", 12.95F, true);
        inventory[6] = new Book("Harry Potter and the Half-Blood Prince", "J.K. Rowling", "77777", 12.95F, true);
      //  inventory[7] = new Book("Harry Potter and the Deathly Hallows", "J.K. Rowling", "88888", 12.95F, true);
             
        
        //System.out.println(inventory[0].getTitle()); 
        
      System.out.println(String.format("%1$-50s", "Title") + String.format("%1$-25s", "Author") +  String.format("%1$-10s", "ISBN") 
               + String.format("%1$-10s", "Price") + "In Stock");
      
      System.out.println("-------------------------------------------------------------------------------------------------------");
        
       for(int i = 0; i < inventory.length; i++)
       {
        //call toString override
        System.out.println(inventory[i].toString()); 
       }
        
            
     //Let's experiment with shallow vs. deep copies
      System.out.println("\nShallow Copy...");
       
            
     Book hpbShallowCopy = inventory[6]; //shallow copy of the Half-Blood Prince--two references pointing to the same single object in memory
     System.out.println(hpbShallowCopy.toString());
     System.out.println(hpbShallowCopy.hashCode());
     System.out.println(inventory[6].hashCode());
     
     
     System.out.println("\nDeep Copy...");
       
     
     Book hpbDeepCopy = new Book(inventory[6]); //deep copy of the Half-Blood Prince--results in TWO separate objects in me memory
     System.out.println(hpbDeepCopy.toString());
     System.out.println(hpbDeepCopy.hashCode());
     System.out.println(inventory[6].hashCode());
     
     
     Course c = new Course("Harry Potter and Medieval Culture", "HUM276", inventory[1]); 
           
     System.out.println();     
     System.out.println(c);
     
     
    }
    
}
