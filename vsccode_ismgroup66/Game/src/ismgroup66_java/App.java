package ismgroup66_java;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    private static String qu;
    private static String ans;

    public static void main(String[] args) throws Exception {
        String filepath = "C:\\Users\\Maria\\Documents\\vsccode_ismgroup66\\test.txt";
        Lesson lesson = new Lesson();
        Student student = new Student();
        GameDao gamedao = new GameDao();
        Game gm = new Game("english",1,filepath);
        
        String ret ;
        Scanner scanner = new Scanner(System.in);
        int points = 0;
        int played;
        List<String> listOfWords = gm.getListOfWords();
        while (!(listOfWords.isEmpty())) {
            qu = listOfWords.get(gm.randomOdd());
            System.out.print("Write the translation of the word:");
            System.out.println(qu);
            ans = scanner.next();
            if (ans.equals("exit")) {
                points = 0; 
                listOfWords.clear();
                break;
            }
            ret = gm.checkWord(qu,ans);
            System.out.println(ret);
            if(ret.equals("Your anwser is correct")){
                points++;
            }


        } /* na peraso to gm me antikeimeno game session kai timi played =0 h ena analoga me tin timi tis listas*/
        if (listOfWords.isEmpty()) {
            played = 0;
        } else {
            played = 1;
        }
        Gamesession gamesession = new Gamesession(student, gm, played);
        gamesession.calTotalpoints(points);
        gamesession.viewTotalSesionpoints();
        
} }

