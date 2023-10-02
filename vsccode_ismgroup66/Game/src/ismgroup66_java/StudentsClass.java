package ismgroup66_java;

public class StudentsClass {
    
    private String classid;
	private String username;

    /**
     * Full constuctor
     *   
     * @param classid;
     * @param username;
     */
    public StudentsClass(String classid, String username) {        
        this.classid = classid;
        this.username = username;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }
    
    public void setUsername(String username) {
        this.username = username;        
    }  

    public String getUsername() {
        return username;
    }


}