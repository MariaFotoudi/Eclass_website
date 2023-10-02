package ismgroup66_java;
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
  private String gamecode; 
  private int lessonnumber;
  /*bale played*/
  /**methodos pou gemizei tin listOfwords me tis lejeis tou arxeiou, ziga ellinika mona agglika */
 
  public Game(String gamecode, int lessonnumber, String filepath) {
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
  public List<String> words(String filepath) {
    String[] f = filepath.split(" ");

      for (String a : f) {
                    

        listOfWords.add(a);
                    
                    
       }
       return listOfWords;

} 
    /*function that returns random odd numbers taking into considaration the size of the list */
    public int randomOdd(List<String> listOfWords) {
      int si = listOfWords.size();

      Random random = new Random();
      int n = random.nextInt(si);
      if (n%2 == 0) {
        n++;
      }
      return n;
    }
    /*fuction that pops the correct elements*/ 
    public void removeCorrectWords(String qu, String ans, List<String> listOfWords) {
      
      listOfWords.remove(qu);
      listOfWords.remove(ans);

    }
    /*fuction that checks if users imput is correct */
    public String checkWord(String qu, String ans,List<String> listOfWords){
      
      int pos = listOfWords.indexOf(ans)+ 1;
      boolean contains = extracted(qu, pos,listOfWords);
      if (contains && listOfWords.contains(ans)) {
          removeCorrectWords(qu,ans,listOfWords);
          return "Your anwser is correct";
      } else {
          return "Your anwser is incorrect";
      }

    }
    private boolean extracted(String qu, int pos,List<String> listOfWords) {
      boolean contains = listOfWords.get(pos).equals(qu);
      return contains;
    }

    /*geterss */
    public List<String> getListOfWords() {
      return listOfWords;
    }
    public String getGameCode() {
      return gamecode;
    }
    public int getLesson() {
      return lessonnumber;
    }


}



