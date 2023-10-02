import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

  public List<String> listOfWords = new ArrayList<String>();
  private int gamecode; 
  private int lessonnumber;
  /*bale played*/
  /**methodos pou gemizei tin listOfwords me tis lejeis tou arxeiou, ziga ellinika mona agglika */
 
  public Game(int gamecode, int lessonnumber, String filepath) {
    this.lessonnumber = lessonnumber;
    this.gamecode = gamecode;
    try {
      listOfWords = words(filepath);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      listOfWords = null;
    }

  }
  public List<String> words(String filepath) throws Exception {
    File file = new File(filepath);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                String string; 
                String[] f = new String[2];

                while ((string = br.readLine()) != null) {
                    f = string.split(" ");

                    listOfWords.add(f[0]);
                    listOfWords.add(f[1]);
                    
                }
                return listOfWords;

                    
                    
                    
            } catch (IOException e) { e.printStackTrace(); }
            return listOfWords;

 
            
    } 
    /*function that returns random odd numbers taking into considaration the size of the list */
    public int randomOdd() {
      int si = listOfWords.size();

      Random random = new Random();
      int n = random.nextInt(si);
      if (n%2 == 0) {
        n++;
      }
      return n;
    }
    /*fuction that pops the correct elements*/ 
    public void removeCorrectWords(String qu, String ans) {
      
      listOfWords.remove(qu);
      listOfWords.remove(ans);

    }
    /*fuction that checks if users imput is correct */
    public String checkWord(String qu, String ans){
      
      int pos = listOfWords.indexOf(ans)+ 1;
      boolean contains = extracted(qu, pos);
      if (contains && listOfWords.contains(ans)) {
          removeCorrectWords(qu,ans);
          return "Your anwser is correct";
      } else {
          return "Your anwser is incorrect";
      }

    }
    private boolean extracted(String qu, int pos) {
      boolean contains = listOfWords.get(pos).equals(qu);
      return contains;
    }

    /*geterss */
    public List<String> getListOfWords() {
      return listOfWords;
    }
    public int getGameCode() {
      return gamecode;
    }
    public int getLesson() {
      return lessonnumber;
    }


}



