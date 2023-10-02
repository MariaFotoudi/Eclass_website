package ismgroup66_java;


public class User {
    
    private String usernamee;
	private String userpassword;

    /**
     * Full constuctor
     *   
     * @param username;
     * @param userpassword;
     */
    public User(String username, String userpassword) {        
        this.username = username;
        this.userpassword = userpassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setUserPassword(String userpassword) {
        this.userpassword = userpassword;        
    }  

    public String getUserPassword() {
        return userpassword;
    }


}