

public class staff extends Members {

    public staff(String name, String email, String phonenumber) {
        super(name, email, phonenumber);
    }

    
    @Override
    public String searchmember(String name) {
        if (this.getname().equalsIgnoreCase(name)) {
            return "Staff Member found: " + name + "\nEmail: " + getemail() + "\nPhone Number: " + getphonenumber();
        } else {
            return "Staff Member not found: " + name;
        }
    }
}
