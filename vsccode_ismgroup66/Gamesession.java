public class Gamesession { /**game session */
    
    private int totalpoints;
    private int gamecode;
    private Student username;
    private int played; /**1 an exei pextei h 0 allios */
    private String dateplayed;
    private Game game;
    public Gamesession(Student username,Game game,int played) {
        totalpoints = 0;
        gamecode = game.getGameCode();
        this.username = username;
        this.played = played;
        this.game = game;
        dateplayed = "00/00/00";

    }

    public int gettotalpoints() {
        return totalpoints;
    }
    public void calTotalpoints(int p) {
        totalpoints = totalpoints + p;

    }
    public void viewTotalSesionpoints() {
        System.out.println("Your Points:");
        System.out.println(totalpoints);
    }
    
}
