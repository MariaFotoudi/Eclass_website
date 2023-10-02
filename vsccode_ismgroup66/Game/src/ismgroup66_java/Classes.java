package ismgroup66_java;

public class Classes {
    
    private String id; //classid
    private String name; //teacherid

    public Classes(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}