import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class AccountDB {
    private ArrayList<Account> accountList;
   
    public AccountDB(String filename) {
        accountList = new ArrayList<Account>();
        try {
            importList(filename);
        }
        catch (Exception e) {
            System.out.println("Error: Database File not Found");
        }
    }
    public void importList(String filename) throws FileNotFoundException {
        File f = new File(filename);
        Scanner list = new Scanner(f);
        while (list.hasNext()) {
            String input = list.nextLine();
            System.out.println(input);
            Scanner line = new Scanner(input);
            line.useDelimiter(",");
            int accountID = line.nextInt();
            String password = line.next();
            String accountType = line.next();
            Account current = new Account(accountID, password, accountType);
            accountList.add(current);
        }
    }

    public boolean accountExists(int accountID) {
        if (findAccountIndex(accountID) != -1) {
            return true;
        }
        return false;
    }

    public Account login(int accountID, String password) {
        int index = findAccountIndex(accountID);
        Account current = accountList.get(index);
        if (current.verifyPassword(password)) {
            return current;
        }
        return null;
    }
    
    private int findAccountIndex(int accountID) {
        Account current;
        for (int i = 0; i < accountList.size(); i++) {
            current = accountList.get(i);
            if (current.getID() == accountID) {
                return i;
            }
        }
        return -1;
    }
}