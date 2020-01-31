
package bookreview;

import java.text.NumberFormat;

public class Book {
    
    private String title;
    private String author;
    private String isbn;
    private double price;
    private boolean inStock;
    
    
    public Book(){}  
    
    
     public Book(String t, String a, String i, double p, boolean s)
     {
      title = t;
      author = a;
      isbn = i;
      price = p;
      inStock = s; 
     }  
     
     
     //Let's also code a copy ctor which will create/clone a book based on an existing book (passed in through the parameter)
     public Book(Book existing)
     {
      title = existing.title;
      author = existing.author;
      isbn = existing.isbn;
      price = existing.price;
      inStock = existing.inStock;
     }
     

    /**
     * @return the title
     */
     
     
    public String getTitle() {
        return title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the inStock
     */
    public boolean isInStock() {
        return inStock;
    }
    
    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @param inStock the inStock to set
     */
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
     
    
    @Override
    public String toString()
    {
      //prints a book "record" on one line
        
        String stocked; 
        if(inStock)
            stocked = "Yes";
        else
            stocked = "No";
        
        
        //tab delimited line
       // return title + "\t" + author + "\t"  + NumberFormat.getCurrencyInstance().format(price) + "\t" + stocked;
      
        //more sophisticated...setting the print field width with String.Format
       return String.format("%1$-50s", title) + String.format("%1$-25s", author) +  String.format("%1$-10s", isbn) 
               + String.format("%1$-10s", NumberFormat.getCurrencyInstance().format(price)) + stocked;
       
       //Explanation of "%1$-50s"
       //% - Format specifiers begin with a percent sign (%) and end with a "converter" (see below for converter)
       //1$ - Refers to numbered argument being formatted. In each of these cases, there is only one additional argument, so the 1$ is redundant...
             //If we had this, however, : String.format("%2$-50s", title, author), the 2$ would apply the formatting to author, not title, because 
             //it is the second argument after the format specifier
       //-50 - Sets printed field width to 50 characters. The minus sign indicates left aligned; omit it for right alignment
       //s - The "converter" specifies what type of output will be printed. To simplify this discussion, you can think of "s" for string. 
      
    }
    
    @Override
    public boolean equals(Object book2)
    {
       //if isbns are equal, then it must be the same book
        if (this.isbn == ((Book) book2).isbn)
            return true; 
        else
            return false;
    
    }
    
      
   
    
}
