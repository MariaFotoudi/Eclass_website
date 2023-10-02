package ismgroup66_java;

/**
 * This class represents a Student
 * 
 * @author Sofoklis Stouraitis
 * @version 1.0
 */
public class Student {
    
    private String lastname;
    private String firstname;
    private String email;
    private String username;
    private int sumpoints;


    public Student(String lastname, String firstname, String email, String username) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSumpoints() {
        return sumpoints;
    }
    public void setSumpoints(int sumpoints) {
        
        this.sumpoints = sumpoints;
    }
}