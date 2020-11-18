import java.util.ArrayList;

public class BookDB {
    private ArrayList<Book> bookList;

    public boolean addBook(String title, String author, String publisher) {
        Book current = new Book(title, author, publisher, generateBookID());
        return true;
    }

    private int generateBookID() {
        return bookList.size();
    }
}