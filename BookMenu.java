
import java.util.*;

public class BookMenu {
    Scanner _scanner = new Scanner(System.in);
    BookOperation bOperation = new BookOperation();

    public void showMenu() {
        System.out.println("*** BookStock System ***");
        System.out.println("This system represents book store and their information that can be viewed and edited.");
      
        System.out.println("[1] Add new Book.");
        System.out.println("[2] Show All Books.");
        System.out.println("[3] Search Books By Title");
        System.out.println("[4] Sort the book.");
        System.out.println("[5] View Book [Id Required] ");
        System.out.println("[6] Export BookStock to File ");
        System.out.println("[0] Exit Application.");
        System.out.println("Please Enter Your Choice-->");
    }

    public BookMenu() {
        // constructor
    }

    public void onChoice() {

        try{

        
        // System.out.println("Please enter your choice");
        int choice;

        do {
            showMenu();
            choice = _scanner.nextInt();
            _scanner.nextLine();
            switch (choice) {
                case 1:
                    bOperation.addBook();
                    break;
                case 2:
                    bOperation.getAllBooks();
                    break;
                case 3:
                    bOperation.onSearchBookByTitle();
                    break;
                case 4:
                    // sort books
                    bOperation.sortBooks();
                    break;
                case 5:
                    // view book
                    bOperation.onViewBook();
                    break;
                case 6:
                bOperation.onExportBook();
                break;    
                default:
                    System.out.println("INVALID CHOICE");
                    break;
            }
        } while (choice != 0);
    }
    catch(InputMismatchException ex){
        System.out.println("Error occured. Please input choice as integer.");
    }
    }
}
