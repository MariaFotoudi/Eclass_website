package ismgroup66_java;
public class Gamesession { /**game session */
    
    private Integer points;
    private String username;
    


    public Gamesession(String username,Integer p) {
        this.points = p;
        this.username = username;

    


    }

    public Integer gettotalpoints() {
        return points;
    }

    public String getusername() {
        return username;
    }
}
