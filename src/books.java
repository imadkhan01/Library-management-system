import java.util.List;

public class books {
    private String bookname;
    private String author;
    private int quantity;

    public books() {
        this.bookname = "";
        this.author = "";
        this.quantity = 0;
    }

    public books(String bookname, String author, int quantity) {

        
        this.bookname = bookname;
        this.author = author;
        this.quantity = quantity;
    }

    public String getbookname() {
        return bookname;
    }

    public String getauthor() {
        return author;
    }

    public int getquantity() {
        return quantity;
    }

    public void setbookname(String bookname) {
        this.bookname = bookname;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    public void setauthor(String author) {
        this.author = author;
    }

   
    public String booksearch(String bookname) {
        if (this.bookname.equalsIgnoreCase(bookname)) {
            return "Book found: " + bookname + "\nAuthor: " + author + "\nQuantity: " + quantity;
        } else {
            return "Book not found: " + bookname;
        }
    }

public String bookBorrow(String bookname, String memberName, List<Members> memberList) {
    boolean memberFound = false;
    for (Members member : memberList) {
        if (member.getname().equalsIgnoreCase(memberName)) {
            memberFound = true;
            break;
        }
    }

    if (memberFound) {
        if (this.bookname.equalsIgnoreCase(bookname)) {
            if (quantity > 0) {
                quantity--;
                return "Book Borrowed: " + bookname;
            } else {
                return "This book is not available for borrowing.";
            }
        } else {
            return "Book not found: " + bookname;
        }
    } else {
        return "The user cannot be found!";
    }
}

    
    public String bookreturn(String bookname) {
        if (this.bookname.equalsIgnoreCase(bookname)) {
            quantity++;
            return "Book returned: " + bookname;
        } else {
            return "This book is not borrowed from the library.";
        }
    }
    
    
    public String displayallbook() {
        return "Book Name: " + bookname + "\nAuthor: " + author + "\nQuantity: " + quantity;
    }
    
    
}
