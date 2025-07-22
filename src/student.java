

public class student extends Members {

    private String regNumber;

    public student(String name, String email, String phoneNumber, String regNumber) {
        super(name, email, phoneNumber);
        this.regNumber = regNumber;
    }

    public void setregNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getregNumber() {
        return regNumber;
    }

   
    @Override
    public String searchmember(String name) {
        if (this.getname().equalsIgnoreCase(name)) {
            return "Student Member found: " + name + 
                   "\nRegistration Number: " + this.regNumber +
                   "\nEmail: " + getemail() +
                   "\nPhone Number: " + getphonenumber();
        } else {
            return "Student Member not found: " + name;
        }
    }
}
