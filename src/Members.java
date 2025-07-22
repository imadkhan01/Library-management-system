

public abstract class Members {

    private String name;
    private String email;
    private String phonenumber;

    public Members(String name, String email, String phonenumber) {
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public void setphonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getname() {
        return name;
    }

    public String getemail() {
        return email;
    }

    public String getphonenumber() {
        return phonenumber;
    }

   public String addmember(String name, String email, String phonenumber) {
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        return "Member added successfully: " + name;
    }


    public String displaymember() {
        return "Member Name: " + name + "\nEmail: " + email + "\nPhone Number: " + phonenumber;
    }

    
    public abstract String searchmember(String name);
}
