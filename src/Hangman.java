import java.util.Scanner;
import java.util.List;
import java.io.*;

public class Hangman {
    static int guesses;
    static int spaces;
    static char[] lettersGuessed = new char[26];
    static int letterCounter = 0;
    //static ArrayList<Character> guesses;
    //going to do count of how many _ there are and when there is 0 print congratulations then exit DONE
    //guesses needs to go up only when its wrong DONE
    //need to add checks on input DONE
    //need to have a check for repeated letters DONE
    //need to ask how to handle a hint for the last letter DONE
    public static void main(String[] args){
        //lettersGuessed[0] = '1';
        //System.out.println(lettersGuessed.length);
        guesses = 4;
        int left = 1000;
        int id1 = 0;
        int id2 = 0;
        Scanner sc = new Scanner(System.in);
        Scanner cs = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String in  = sc.nextLine();
        in = in.toLowerCase();
        String removed = in.replaceAll("\\s","");
        Hangletter[] word = new Hangletter[removed.length()];
        char[] guessed;
        for(int i = 0; i < removed.length(); i++){
            if(removed.charAt(i) != ' ') {
                Hangletter test = new Hangletter(removed.charAt(i));
                word[i] = test;
            }
        }
        //System.out.println(word[0].getShow());
        //System.out.println(word[1].getShow());
        while(guesses > 0 && left != 0){
            left = 0;
            id1 = 0;
            id2 = 0;
            spaces = 0;
            System.out.print("So far, the word is: ");
            display(in,word);
            System.out.println("");
            System.out.println(guesses +" incorrect guesses left");
            //put into loop id 2
            while(id2 == 0) {
                System.out.print("Enter either 1 for guessing or 2 for hint: ");
                String response = sc.nextLine();
                int respond = 0;
                try {
                    respond = Integer.parseInt(response);
                } catch (NumberFormatException e) {
//                System.out.println("Incorrect Input");
                }
                if (respond == 1 || respond == 2) {
                    id2++;
                    if (respond == 1) {
                        //Put in while loop id 1
                        while (id1 == 0) {
                            boolean prev = false;
                            System.out.print("Enter your guess: ");
                            String gues = cs.nextLine();
                            //char geus = Character.toLowerCase(gues.charAt(0));
                            if (gues.length() != 1) {
                                System.out.println("Incorrect input");
                            } else {
                                char geus = Character.toLowerCase(gues.charAt(0));
                                if ((geus >= 65 && geus <= 90) || (geus >= 97 && geus <= 122)) {
                                    for(int g =0; g < letterCounter; g++){
                                        if(lettersGuessed[g] == geus){
                                            System.out.println("Already guessed that letter");
                                            prev = true;
                                            break;
                                        }
                                    }
                                    if(!prev) {
                                        guess(geus, word);
                                        id1++;
                                    }
                                } else {
                                    System.out.println("Incorrect Input");
                                }
                            }
                        }
                        //end of loop id 1
                    } else{
                        hint(word);
                        id2++;
                    }
                } else {
                    System.out.println("Incorrect Input.");
                }
            }
            //end loop id 2
            for (int k = 0; k < word.length; k++){
                if(word[k].getShow() == '_') {
                    left++;
                }
            }
            if(left == 0){
                System.out.println("Congratulations!");
                System.out.println("The word is " + in);
            }
            if(guesses == 0 && left != 0){
                System.out.println("Sorry, you ran out of guesses");
                System.out.println("The word was " + in);
            }
            }
    }
    public static void display(String a, Hangletter[] b){
        for(int k = 0; k < a.length(); k++){
            if (a.charAt(k) == ' ') {
                System.out.print("# ");
                spaces++;
            }else {
                System.out.print(b[k-spaces].getShow());
                System.out.print(" ");
            }
        }
    }
    public static void guess(char give, Hangletter[] word){
        boolean found = false;
        for (int i = 0; i<(word.length);i++){
            if(give == word[i].getLet()){
                word[i].setFound(true);
                found = true;
            }
        }
        if(found){
            System.out.println("That's right! " + Character.toUpperCase(give) + " is in the word.");
            lettersGuessed[letterCounter] = give;
            letterCounter++;
        }else {
            System.out.println("Sorry, " + Character.toUpperCase(give) + " is not in the word");
            guesses--;
        }
    }
    public static void hint(Hangletter[] word){
        char hint = ' ';
        for (int i = 0; i < word.length; i++){
            if(word[i].getShow() == '_'){
                hint = word[i].getLet();
                lettersGuessed[letterCounter] = hint;
                letterCounter++;
                break;
            }
        }
        System.out.println("The Hint is letter " + hint);
        for (int j = 0; j < word.length; j++){
            if(word[j].getLet() == hint){
                word[j].setFound(true);
            }

        }
        guesses--;
    }
}

