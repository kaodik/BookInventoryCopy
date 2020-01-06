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
public class Course {
    
    private String courseName;
    private String courseCode;
    private Book requiredText;  //aggregation (object as instance varaible of another object)
    
    public Course() {}
    
    public Course(String n, String c, Book b) 
    {
     courseName = n;
     courseCode = c;
     //requiredText = b; //shallow copy
     requiredText = new Book(b); //deep copy (more secure--see longer note in the ctor below...same situation)
    }
    
    //copy ctor
    public Course(Course existing) 
    {
     courseName =  existing.courseName;
     courseCode = existing.courseCode;
     //requiredText = existing.requiredText; //This would be a shallow copy, which opens a security hole because this shiny new Course object 
                                             //points to an old used-up Book object that might have its reference out there all over the place. 
                                             
     //Better to do a deep copy
     requiredText = new Book(existing.requiredText); //call to Book's copy ctor
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * @param courseCode the courseCode to set
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    
    /**
     * @param requiredText the requiredText to set
     */
    public void setRequiredText(Book requiredText) {
        this.requiredText = requiredText;
    }
    
    /**
     * Returning an object reference to the "outside world" opens up a security hole in your class
     */
//    public Book getRequiredText() {
//        return requiredText;
//    }
    
    
    /**
     * A better get to get the requiredText...
     * @return 
     */
    public Book getRequiredText() {
        return new Book(requiredText); //call to copy ctor
    }
    

    @Override 
    public String toString()
    {
        return String.format("%1$-8s", courseCode) + String.format("%1$-35s", courseName)  
                + "\n\tRequired Text: " + requiredText.getTitle() + " by " + requiredText.getAuthor() + "; ISBN:" + requiredText.getIsbn(); 
    }
    
    
}
