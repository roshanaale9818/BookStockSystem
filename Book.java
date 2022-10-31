public class Book implements Comparable<Book>{
    private int bookId;
    private String title;
    private String authorName;
    private int price;
    private int bookQuantity;
    private int ISBNnumber;
    public Book(int id,String title, String authorname,int price, int bookQuantity,int isbn){

        //constructor
        this.bookId = id;
        this.title = title;
        this.authorName = authorname;
        this.price = price;
        this.bookQuantity = bookQuantity;
        this.ISBNnumber = isbn;

    }
    public int getBookId(){
        return this.bookId;
    }
    public int setBookId(int id){
        return this.bookId = id;
    }
    public void setTitle(String n){
        this.title = n;

    }
    public String getTitle(){
        return this.title;
    }
    public void setAuthorName(String name){
        this.authorName = name;
    }
    public String getAuthorName(){
        return this.authorName;
    }
    public int getPrice(){
        return this.price;
    }
    public void setPrice(int _price){
        this.price = _price;
    }
    public int getISBNnumber(){
        return this.ISBNnumber;
    }
    public int setISBNnumber(int id){
        return this.ISBNnumber = id;
    }
    public int getQuantity(){
        return this.bookQuantity;
    }
    public int setBookQuantity(int bookNo){
        return this.bookQuantity = bookNo;
    }
    @Override
    public int compareTo(Book o) {
        int compareBookId
        = ((Book)o).getBookId();

    //  For Ascending order
    return this.bookId - compareBookId;

    // For Descending order do like this
    // return compareage-this.studentage;
}
    }




