import java.util.ArrayList;

public class Account {

    private static final int maxBooks = 5;
    private int accountID;
    private String password;
    private ArrayList<Book> checkedOut;
    private int reservation;
    private String accountType;
    
    public Account(int IDin, String passwordIn, String accountTypeIn) {
        accountID = IDin;
        password = passwordIn;
        accountType = accountTypeIn;
        checkedOut = new ArrayList<Book>();
    }

    public int getID() {
        return accountID;
    }

    public boolean verifyPassword(String passwordIn) {
        if (password.equals(passwordIn)) {
            return true;
        }
        return false;
    }
    
    public String getType() {
      return accountType;
    }
}