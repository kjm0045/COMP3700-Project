import java.util.Scanner;

public class UserInterface {
    
    private Account current = null;
    private AccountDB accDB = new AccountDB("accountList.txt");
    private BookDB bookDB = new BookDB();
    private Scanner input = new Scanner(System.in);

    public void printMenu() {
        boolean status = true;
        while (status) {
            if (current != null) {
                if (current.getType() == "librarian") {
                    status = librarianMenu();
                }
                else {
                    status = userMenu();
                }
            }
            else {
                status = loginMenu();
            }
        }
    }

    private boolean loginMenu() {
        System.out.println("No account logged in.");
        System.out.println("1: Login to account");
        System.out.println("2: Exit system");
        System.out.print("Please enter a choice: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Please enter your account ID: ");
                int accountID = input.nextInt();
                input.nextLine();
                String password;
                //Check if accountID is valid
                if (accDB.accountExists(accountID)) {
                    System.out.print("Please enter your password: ");
                    password = input.nextLine();
                    System.out.println(password);
                    current = accDB.login(accountID, password);
                    if (current == null) {
                        System.out.println("Error: Incorrect Password");
                    }
                    else {
                        System.out.println("Login Successful");
                    }
                    return true;
                }
                else {
                    System.out.println("Error: Incorrect Account ID");
                }
                break;
            case 2:
                return false;
            default:
                System.out.println("Error: Invalid selection");
                return true;
        }
        return true;
    }

    private boolean userMenu() {
        System.out.println("User: " + current.getID() + " logged in");
        System.out.println("1: Log out");
        System.out.println("2: Check out book");
        System.out.println("3: Reserve book");
        System.out.println("4: Search for book");
        System.out.println("5: Check book status");
        System.out.println("6: Pay fees");
        System.out.println("7: Change account information");
        System.out.println("8: Cancel account");
        System.out.println("9: Exit System");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1:
                current = null;
                System.out.println("Logged out");
                return true;
            case 2:
                System.out.println("Error: Not yet implemented");
                return true;
            case 3:
                System.out.println("Error: Not yet implemented");
                return true;
            case 4:
                System.out.println("Error: Not yet implemented");
                return true;
            case 5:
                System.out.println("Error: Not yet implemented");
                return true;
            case 6:
                System.out.println("Error: Not yet implemented");
                return true;
            case 7:
                System.out.println("Error: Not yet implemented");
                return true;
            case 8:
                System.out.println("Error: Not yet implemented");
                return true;
            case 9:
                return false;
            default:
                System.out.println("Error: Invalid selection");
                return true;
        }
    }
    private boolean librarianMenu() {
        System.out.println("Librarian: " + current.getID() + " logged in");
        System.out.println("1: Log out");
        System.out.println("2: Check out book");
        System.out.println("3: Reserve book");
        System.out.println("4: Search for book");
        System.out.println("5: Check book status");
        System.out.println("6: Pay fees");
        System.out.println("7: Change account information");
        System.out.println("8: Cancel account");
        System.out.println("9: Check in item");
        System.out.println("10: Create report");
        System.out.println("11: Mark item as lost");
        System.out.println("12: Add new book");
        System.out.println("13: Issue new card");
        System.out.println("14: Freeze account");
        System.out.println("15: Exit System");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
           case 1:
                current = null;
                System.out.println("Logged out");
                return true;
            case 2:
                System.out.println("Error: Not yet implemented");
                return true;
            case 3:
                System.out.println("Error: Not yet implemented");
                return true;
            case 4:
                System.out.println("Error: Not yet implemented");
                return true;
            case 5:
                System.out.println("Error: Not yet implemented");
                return true;
            case 6:
                System.out.println("Error: Not yet implemented");
                return true;
            case 7:
                System.out.println("Error: Not yet implemented");
                return true;
            case 8:
                System.out.println("Error: Not yet implemented");
                return true;
            case 9:
                System.out.println("Error: Not yet implemented");
                return true;
            case 10:
                System.out.println("Error: Not yet implemented");
                return true;
            case 11:
                System.out.println("Error: Not yet implemented");
                return true;
            case 12:
                System.out.print("Enter Title: ");
                String title = input.nextLine();
                System.out.print("Enter Author: ");
                String author = input.nextLine();
                System.out.print("Enter Publisher: ");
                String publisher = input.nextLine();
                System.out.println("Title: " + title + "Author: " + author + "Publisher: " + publisher);
                System.out.print("Is this information correct? Enter Y to continue or N to cancel: ");
                char select = input.nextLine().charAt(0);
                if (Character.toLowerCase(select) == 'y') {
                    boolean state = bookDB.addBook(title, author, publisher);
                    if (state) {
                        System.out.println("Book added successfully");
                    }
                    else {
                        System.out.println("Failed to add book");
                    }
                }
                return true;
            case 13:
                System.out.println("Error: Not yet implemented");
                return true;
            case 14:
                System.out.println("Error: Not yet implemented");
                return true;
            case 15:
                return false;
            default:
                System.out.println("Error: Invalid selection");
                return true;
        }
    }
}