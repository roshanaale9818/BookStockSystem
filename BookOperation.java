import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

public class BookOperation {
    ArrayList<Book> books = new ArrayList<Book>();
    Scanner scan = new Scanner(System.in);

    public BookOperation() {
        // constructor for BookOperation
        // initializing the books
        this.initBooks();
    }

    public void initBooks() {
        this.books.add(
                new Book(1, "John Doe", "John Doe", 12, 9, 891));
        this.books.add(
                new Book(4, "Thousand", "John Moy", 12, 9, 212));
        this.books.add(
                new Book(3, "The Gun ", "John Tan", 90, 9, 231));
    }

    // adding new book
    public void addBook() {

        try {

            String title;
            int bookId;
            String authorName;
            int price;
            int bookQuantity;
            int ISBNnumber;
            System.out.println("*****Add new Book****");
            System.out.print("Enter book title" + "\n");
            title = scan.nextLine();
            System.out.print("Enter book author name" + "\n");
            authorName = scan.nextLine();
            Random ran = new Random();
            // bookId = (int) Math.random()*(200-10);
            bookId =ran.nextInt(200-3+22);
            // bookId =  UUID.randomUUID();
            System.out.print("Enter book price" + "\n");
            price = scan.nextInt();
            System.out.print("Enter book quantity" + "\n");
            bookQuantity = scan.nextInt();
            System.out.print("Enter book ISBNnumber" + "\n");
            ISBNnumber = scan.nextInt();
            scan.nextLine();
            Book book = new Book(bookId, title, authorName, price, bookQuantity, ISBNnumber);
            books.add(book);
            System.out.println("Book Added Successfully.");
        } catch (InputMismatchException ex) {
            System.out.println("Error has occured" + ex);
        }
    }

    // getting all books method
    public void getAllBooks() {
        if (this.books.size() < 1) {
            System.out.println("Book List is empty");
        } else {
            System.out.println("****All Books****");
            System.out.format(
                    "+-----------------+--------------------------------------------------------------------------------------+%n");
            System.out.format(
                    "| ID   |  Title                      |  Author               |  Price     |   Quantity     |    ISBN     |%n");
            // System.out.format("+-----------------+------+%n");
            System.out.format(
                    "+-----------------+--------------------------------------------------------------------------------------+%n");

            // System.out.print(" Id ");
            // System.out.print(" Title ");
            // System.out.print(" Authorname ");
            // System.out.print(" Price ");
            // System.out.print(" Quantity ");
            // System.out.print(" ISBN ");
            // System.out.println();
            for (Book _book : this.books) {
                // System.out.print(" " + _book.getBookId() + " ");
                // System.out.print(" " + _book.getTitle() + " ");
                // System.out.print(" " + _book.getAuthorName() + " ");
                // System.out.print(" " + _book.getPrice() + " ");
                // System.out.print(" " + _book.getQuantity() + " ");
                // System.out.print(" " + _book.getISBNnumber() + " ");
                // System.out.println();
                // System.out.format("| ID | Title | Author | Price | Quantity | ISBN |%n");
                System.out.format("|  " + _book.getBookId() + "   |  " + _book.getTitle() + "                   |  "
                        + _book.getAuthorName() + "             | " + _book.getPrice() + "         |   "
                        + _book.getQuantity() + "            |    " + _book.getISBNnumber() + "      |%n");
                System.out.format(
                        "+--------------------------------------------------------------------------------------------------------+%n");
            }
        }
    }

    // getbook by title
    public ArrayList<Book> getBookByTitle(String title) {
        // Book book = null;
        ArrayList<Book> list = new ArrayList<Book>();
        for (Book _book : this.books) {
            if (_book.getTitle().trim().toLowerCase().equals(title.toLowerCase())) {
                // book = _book;

                list.add(_book);

            }
        }
        return list;
    }

    // onSearchingBookByTitle
    public void onSearchBookByTitle() {
        System.out.println("*****SearchBooks By Name*****");
        System.out.println("Enter the book name");
        String title = scan.nextLine();
        ArrayList<Book> list = getBookByTitle(title);
        if (list.size() != 0) {

            System.out.println(list.size() + "  Book Found");
            // System.out.print(" Id ");
            // System.out.print(" Title ");
            // System.out.print(" Authorname ");
            // System.out.print(" Price ");
            // System.out.print(" Quantity ");
            // System.out.print(" ISBN ");
            // System.out.println();
            // System.out.println("****All Books****");
            System.out.format(
                    "+-----------------+--------------------------------------------------------------------------------------+%n");
            System.out.format(
                    "| ID   |  Title                      |  Author               |  Price     |   Quantity     |    ISBN     |%n");
            // System.out.format("+-----------------+------+%n");
            System.out.format(
                    "+-----------------+--------------------------------------------------------------------------------------+%n");

            for (Book _book : list) {
                // System.out.print(" " + _book.getBookId() + " ");
                // System.out.print(" " + _book.getTitle() + " ");
                // System.out.print(" " + _book.getAuthorName() + " ");
                // System.out.print(" " + _book.getPrice() + " ");
                // System.out.print(" " + _book.getQuantity() + " ");
                // System.out.print(" " + _book.getISBNnumber() + " ");
                // System.out.println();
                // System.out.format("| ID | Title | Author | Price | Quantity | ISBN |%n");
                System.out.format("|  " + _book.getBookId() + "   |  " + _book.getTitle() + "                   |  "
                        + _book.getAuthorName() + "             | " + _book.getPrice() + "         |   "
                        + _book.getQuantity() + "            |    " + _book.getISBNnumber() + "      |%n");
                System.out.format(
                        "+--------------------------------------------------------------------------------------------------------+%n");
            }
        } else {
            System.out.println("Book Not Found  (Searched title = " + title + ")");
        }
    }

    // this method returns boolean if book exists or not
    public boolean searchBookByTitle(String title) {

        boolean isFound = false;
        for (Book _book : this.books) {
            if (_book.getTitle().toLowerCase().equals(title)) {
                isFound = true;
            } else {
                isFound = false;
            }
        }
        return isFound;
    }

    // update the book in stock
    public void updateBook(int id) {
        try {

            Book book = null;
            String title;

            String authorName;
            int price;
            int bookQuantity;
            int ISBNnumber;
            for (Book _book : this.books) {
                if (_book.getBookId() == id) {
                    book = _book;
                }
            }
            ;
            if (book != null) {
                scan.nextLine();
                System.out.print("Enter book title" + "\n");
                // book.setTitle(scan.nextLine());
                // scan.nextLine();
                title = scan.nextLine();
                System.out.print("Enter book author name" + "\n");
                authorName = scan.nextLine();
               
                System.out.print("Enter book price" + "\n");
                // book.setPrice(scan.nextFloat());
                price = scan.nextInt();
                System.out.print("Enter book quantity" + "\n");
                // book.setBookQuantity(scan.nextInt());
                bookQuantity = scan.nextInt();
                System.out.print("Enter book ISBNnumber" + "\n");
                // book.setISBNnumber(scan.nextLine());
                ISBNnumber = scan.nextInt();
                scan.nextLine();
                book.setAuthorName(authorName);
                book.setBookQuantity(bookQuantity);
                book.setISBNnumber(ISBNnumber);
                book.setPrice(price);
                book.setTitle(title);
                System.out.println("Book updated successfully.");
                System.out.println("Press [0] for Back");
                // scan.nextLine();

            } else {
                System.out.println("Book not found having ID:  " + id);
            }
        } catch (InputMismatchException exception) {
            System.out.println("Error has occured." + exception);
        }

    }

    // view book by id
    public void onViewBook() {
        System.out.println("***** VIEW BOOK*****");
        System.out.println("Enter the ID of the book");

        int id = scan.nextInt();
        // scan.nex
        Book book = null;
        for (Book _book : this.books) {
            if (_book.getBookId() == id) {
                book = _book;
            }
        }
        ;

        if (book != null) {
            System.out.println("****Book Found****");
            System.out.println("Book Title :" + book.getTitle());
            System.out.println("Book Author :" + book.getAuthorName());

            System.out.println("Book Price :" + book.getPrice());

            System.out.println("Book  Quantity:" + book.getQuantity());
            System.out.println("ISBN  Number:" + book.getISBNnumber());

            // System.out.println("Book :"+book.getTitle());

            scan.nextLine();
            System.out.print("[1] Edit book     ");
            System.out.print(
                    "[9] Delete the book       ");
            System.out.print(
                    "         0] Back" + "\n");

            System.out.println("Enter your choice");
            int choice = scan.nextInt();

            while (choice != 0) {
                switch (choice) {
                    case 1:
                        updateBook(book.getBookId());
                        if (scan.nextInt() == 0) {
                            choice = 0;
                            break;
                        }
                        break;
                    case 0:
                        break;
                    case 9:
                        deleteBook(book.getBookId());
                        choice = 0;
                        break;

                    default:
                        System.out.println("***INVALID CHOICE ****");
                        break;

                }
            }

        } else {
            System.out.println("Book Not Found");

        }
    }

    // delete the book
    public String deleteBook(int id) {
        scan.nextLine();
        System.out.println("Are you sure you want to delete [Y/N] ?");
        String ch = scan.nextLine();
        System.out.println("INPUT RECEIVED ->" + ch.toLowerCase());
        String result = "";
        if (ch.toLowerCase().equals("y")) {
            this.books.removeIf(book -> book.getBookId() == id);
            // for(Book b:this.books){
            // this.books.remove(e-> e.)
            // }

            System.out.println("Book deleted successfully.");
            result = "deleted";
        } else {
            System.out.println("Cancelled");
        }
        return result;
    }

    // sorting the books
    public void sortBooks() {
        int choice = -1;
        System.out.println("*****SORT BOOKS*****");
        System.out.println("Please Enter Your Choice");
        if (this.books.size() != 0) {
            System.out.println("[1] Sort By ID [ASC]");
            System.out.println("[2] Sort By ID [DESC]");
            // System.out.println("[3] Sort By Name [ASC]");
            // System.out.println("[4] Sort By Name [DESC]");
            // System.out.println("[5] Sort By Price [ASC]");
            // System.out.println("[6] Sort By Price [DESC]");
            System.out.println("[0] Back");
            choice = scan.nextInt();
            while (choice != 0) {
                switch (choice) {
                    case 1:
                        sortBooksById("asc");
                        choice = 0;
                        break;
                    case 2:
                        sortBooksById("dsc");
                        choice = 0;
                        break;
                    // case 3:
                    // break;
                    // case 4:
                    // break;
                    default:
                        break;
                }
            }
        } else {
            System.out.println("There are no any books.");
        }

    }

    public void sortBooksById(String type) {
        if (type.toLowerCase().equals("asc")) {
            // Collections.sort(this.books,Comparator.naturalOrder());
            Collections.sort(this.books);

        } else {
            Collections.reverse(this.books);
        }

        System.out.println("****All Books in " + type.toUpperCase() + "order"+" ****");
        System.out.format(
                "+-----------------+--------------------------------------------------------------------------------------+%n");
        System.out.format(
                "| ID   |  Title                      |  Author               |  Price     |   Quantity     |    ISBN     |%n");
        // System.out.format("+-----------------+------+%n");
        System.out.format(
                "+-----------------+--------------------------------------------------------------------------------------+%n");

        for (Book _book : this.books) {
            System.out.format("|  " + _book.getBookId() + "   |  " + _book.getTitle() + "                   |  "
                    + _book.getAuthorName() + "             | " + _book.getPrice() + "         |   "
                    + _book.getQuantity() + "            |    " + _book.getISBNnumber() + "      |%n");
            System.out.format(
                    "+--------------------------------------------------------------------------------------------------------+%n");
        }
    }

    public void onExportBook() {
        try {
            String fileName = "BookStocks.txt";
            PrintWriter outFile = new PrintWriter(fileName);
            outFile.println("ID"+"  " + "Title" + "   " + " Author"+ "   "
                        +"Price" + "   " +
                        "ISBN");
            for (Book _book : this.books) {
                outFile.println(_book.getBookId() + "   " + _book.getTitle() + "   " + _book.getAuthorName() + "   "
                        + _book.getPrice() + "   " +
                        _book.getISBNnumber());
            }
            outFile.close();
            System.out.println("Bookfile is exported successfully in"+fileName);
        } catch (FileNotFoundException exception) {
            System.out.println("Exception occured in handling file.");
        }

    }
}