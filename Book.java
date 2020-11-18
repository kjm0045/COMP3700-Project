
public class Book {
    
    private String status;
    private String title;
    private String author;
    private String publisher;
    private String available = "available";
    private String reserved = "reserved";
    private String checkedOut = "checkedOut";
    private int bookID;
    
    public Book(String titleIn, String authorIn, String publisherIn, int bookIDIn) {
        title = titleIn;
        author = authorIn;
        publisher = publisherIn;
        bookID = bookIDIn;
        status = available;
    }

    public String getStatus() {
        return status;
    }

    public boolean checkOut() {
        if (status == available) {
            status = checkedOut;
            return true;
        }
        return false;
    }

    public boolean reserve() {
        if (status == available) {
            status = reserved;
            return true;
        }
        return false;
    }
    
    public boolean checkIn() {
        if (status == checkedOut) {
            status = available;
            return true;
        }
        return false;
    }
}