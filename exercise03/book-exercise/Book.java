/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author (Mario Schuetz)
 * @version (2015-11-10)
 */
class Book
{
    // The fields.
    private String author;
    private String title;
    private int pages;
    private String refNumber;

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String bookAuthor, String bookTitle, int bookPages)
    {
        author = bookAuthor;
        title = bookTitle;
        pages=bookPages;
        refNumber="";
    }
        
    public String getAuthor(){
        return author;
    }
        
    public String getTitle(){
        return title;
    }
    
    public int getPages(){
        return pages;
    }
    
        public String getRefNumber(){
        return refNumber;
    }
    
    public void setRefNumber(String ref){
        if(ref.length()<3){
            System.out.println("");
            System.out.println("Please type at least 3 characters.");
        }
        else{
            refNumber=ref;
        }
        
    }
    
    public void printAuthor(){
        System.out.println("The Authors Name Is: " + author);
    }
    
    public void printBookTitle(){
        System.out.println("The Books Name Is: " + title);
    }
    
    public void printDetails(){
        System.out.println("");
        System.out.println("Bookdetails");
        System.out.println("The Authors Name Is: " + author);
        System.out.println("The Books Title Is: " + title);
        System.out.println("It contains " + pages + " pages.");
        if(refNumber.length()>=1){
            System.out.println("RefNumber: " + refNumber);
        }
    }
}
