import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;

public class LibraryGui extends JFrame {
    private ArrayList<books> booklist = new ArrayList<>();
    private ArrayList<Members> memberlist = new ArrayList<>();

    public LibraryGui() {
        // Dummy Data (from Main class)
        booklist.add(new books("Java Programming", "James Gosling", 5));
        booklist.add(new books("Python Programming", "Guido van Rossum", 3));
        booklist.add(new books("C++ Programming", "Bjarne Stroustrup", 4));
        booklist.add(new books("JavaScript Programming", "Brendan Eich", 2));
        booklist.add(new books("C# Programming", "Anders Hejlsberg", 3));

        memberlist.add(new student("Ali", "Ali123@gmail.com", "032748393", "sp23-bcs-123"));
        memberlist.add(new student("Sara", "sara@132", "032748393", "sp23-bcs-124"));
        memberlist.add(new staff("Ahmed", "ahmed@123", "032748393"));
        memberlist.add(new staff("Fatima", "fatima@123", "0327482332"));

        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(20, 20));

        JLabel welcomeLabel = new JLabel("Welcome to Library Management System", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 15));

        JButton addBookButton = new JButton("Add Book");
        JButton addStudentButton = new JButton("Add Student");
        JButton addStaffButton = new JButton("Add Staff");
        JButton searchBookButton = new JButton("Search Book");
        JButton borrowBookButton = new JButton("Borrow Book");

        buttonPanel.add(addBookButton);
        buttonPanel.add(addStudentButton);
        buttonPanel.add(addStaffButton);
        buttonPanel.add(searchBookButton);
        buttonPanel.add(borrowBookButton);
        JButton displayBooksButton = new JButton("Display All Books");
        buttonPanel.add(displayBooksButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Button Actions with REAL LMS LOGIC:
        addBookButton.addActionListener(e -> openAddBookForm());
        addStudentButton.addActionListener(e -> openAddStudentForm());
        addStaffButton.addActionListener(e -> openAddStaffForm());
        searchBookButton.addActionListener(e -> openSearchBookForm());
        borrowBookButton.addActionListener(e -> openBorrowBookForm());
        displayBooksButton.addActionListener(e -> displayAllBooks());

    }

    private void openAddBookForm() {
        JTextField nameField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField quantityField = new JTextField();

        Object[] fields = {
            "Book Name:", nameField,
            "Author:", authorField,
            "Quantity:", quantityField
        };

        int result = JOptionPane.showConfirmDialog(this, fields, "Add Book", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            if (nameField.getText().isEmpty() || authorField.getText().isEmpty() || quantityField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    int qty = Integer.parseInt(quantityField.getText());
                    booklist.add(new books(nameField.getText(), authorField.getText(), qty));
                    JOptionPane.showMessageDialog(this, "Book added successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Quantity must be a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void openAddStudentForm() {
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField regField = new JTextField();

        Object[] fields = {
            "Student Name:", nameField,
            "Email:", emailField,
            "Phone:", phoneField,
            "Reg Number:", regField
        };

        int result = JOptionPane.showConfirmDialog(this, fields, "Add Student", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            if (nameField.getText().isEmpty() || emailField.getText().isEmpty() || phoneField.getText().isEmpty() || regField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                memberlist.add(new student(nameField.getText(), emailField.getText(), phoneField.getText(), regField.getText()));
                JOptionPane.showMessageDialog(this, "Student added successfully!");
            }
        }
    }

    private void openAddStaffForm() {
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField phoneField = new JTextField();

        Object[] fields = {
            "Staff Name:", nameField,
            "Email:", emailField,
            "Phone:", phoneField
        };

        int result = JOptionPane.showConfirmDialog(this, fields, "Add Staff", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            if (nameField.getText().isEmpty() || emailField.getText().isEmpty() || phoneField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                memberlist.add(new staff(nameField.getText(), emailField.getText(), phoneField.getText()));
                JOptionPane.showMessageDialog(this, "Staff added successfully!");
            }
        }
    }

    private void openSearchBookForm() {
        String bookName = JOptionPane.showInputDialog(this, "Enter Book Name to Search:");
        if (bookName != null && !bookName.trim().isEmpty()) {
            boolean found = false;
            for (books b : booklist) {
                if (b.getbookname().equalsIgnoreCase(bookName.trim())) {
                    JOptionPane.showMessageDialog(this, "Book Found!\nAuthor: " + b.getauthor() + "\nQuantity: " + b.getquantity());
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "Book not found.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter book name!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
private void openBorrowBookForm() {
    String memberName = JOptionPane.showInputDialog(this, "Enter Your Name:");
    if (memberName == null || memberName.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter your name!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    boolean memberFound = false;
    for (Members member : memberlist) {
        if (member.getname().equalsIgnoreCase(memberName.trim())) {
            memberFound = true;
            break;
        }
    }

    if (!memberFound) {
        JOptionPane.showMessageDialog(this, "Member not found! Please register first.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String bookName = JOptionPane.showInputDialog(this, "Enter Book Name to Borrow:");
    if (bookName != null && !bookName.trim().isEmpty()) {
        boolean bookFound = false;
        for (books b : booklist) {
            if (b.getbookname().equalsIgnoreCase(bookName.trim())) {
                bookFound = true;
                if (b.getquantity() > 0) {
                    b.setquantity(b.getquantity() - 1);
                    JOptionPane.showMessageDialog(this, "Book Borrowed Successfully!\nRemaining Quantity: " + b.getquantity());
                } else {
                    JOptionPane.showMessageDialog(this, "This book is not available for borrowing.");
                }
                break;
            }
        }
        if (!bookFound) {
            JOptionPane.showMessageDialog(this, "Book not found.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please enter book name!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

   private void displayAllBooks() {
    if (booklist.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No books available in the library.");
        return;
    }

    StringBuilder booksInfo = new StringBuilder();
    for (books b : booklist) {
        booksInfo.append(b.displayallbook()).append("\n\n");
    }

    JTextArea textArea = new JTextArea(booksInfo.toString());
    textArea.setEditable(false);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);

    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setPreferredSize(new Dimension(400, 300));

    JOptionPane.showMessageDialog(this, scrollPane, "All Books", JOptionPane.INFORMATION_MESSAGE);
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryGui().setVisible(true));
    }
}
