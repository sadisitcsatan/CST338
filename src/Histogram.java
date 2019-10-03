import java.io.File;
import java.util.Scanner;
//Title: Histogram.java
//Abstract: Take text from user and scan a file with the name given and display
//    the occurrence of characters in a bar graph sorted by least occurrence to most.
//Author: Christopher Scott
//Date: 9/16/2019
public class Histogram {
    public static void main(String[] args){
        //Creating objects to represent each letter with counter
        Letter aletter = new Letter('A',0);
        Letter bletter = new Letter('B',0);
        Letter cletter = new Letter('C',0);
        Letter dletter = new Letter('D',0);
        Letter eletter = new Letter('E',0);
        Letter fletter = new Letter('F',0);
        Letter gletter = new Letter('G',0);
        Letter hletter = new Letter('H',0);
        Letter iletter = new Letter('I',0);
        Letter jletter = new Letter('J',0);
        Letter kletter = new Letter('K',0);
        //creating a int to represent the highest occurrence of a letter
        int biggest = 0;
        System.out.print("Input Filename: ");
        //taking input from nuser to get file name
        Scanner input = new Scanner(System.in);
        String ins = input.nextLine();
        File file = new File(ins);
        Scanner scan = null;
        //had to catch the FileNotFound exception in case the file doesn't exist
        try {
            scan = new Scanner(file);
        }catch (java.io.FileNotFoundException e){
            System.out.println("file not found");
        }
        //reading the file and changing relative counter per appearance
        while(scan.hasNext()){
            String current = scan.nextLine();
            if(current.equals("A")){
                aletter.setCount(aletter.getCount()+1);
                if(aletter.getCount() > biggest){
                    biggest = aletter.getCount();
                }
            }
            if(current.equals("B")){
                bletter.setCount(bletter.getCount()+1);
                if(bletter.getCount() > biggest){
                    biggest = bletter.getCount();
                }
            }
            if(current.equals("C")){
                cletter.setCount(cletter.getCount()+1);
                if(cletter.getCount() > biggest){
                    biggest = cletter.getCount();
                }
            }
            if(current.equals("D")){
                dletter.setCount(dletter.getCount()+1);
                if(dletter.getCount() > biggest){
                    biggest = dletter.getCount();
                }
            }
            if(current.equals("E")){
                eletter.setCount(eletter.getCount()+1);
                if(eletter.getCount() > biggest){
                    biggest = eletter.getCount();
                }
            }
            if(current.equals("F")){
                fletter.setCount(fletter.getCount()+1);
                if(fletter.getCount() > biggest){
                    biggest = fletter.getCount();
                }
            }
            if(current.equals("G")){
                gletter.setCount(gletter.getCount()+1);
                if(gletter.getCount() > biggest){
                    biggest = gletter.getCount();
                }
            }
            if(current.equals("H")){
                hletter.setCount(hletter.getCount()+1);
                if(hletter.getCount() > biggest){
                    biggest = hletter.getCount();
                }
            }
            if(current.equals("I")){
                iletter.setCount(iletter.getCount()+1);
                if(iletter.getCount() > biggest){
                    biggest = iletter.getCount();
                }
            }
            if(current.equals("J")){
                jletter.setCount(jletter.getCount()+1);
                if(jletter.getCount() > biggest){
                    biggest = jletter.getCount();
                }
            }
            if(current.equals("K")){
                kletter.setCount(kletter.getCount()+1);
                if(kletter.getCount() > biggest){
                    biggest = kletter.getCount();
                }
            }

        }
        //creating an array of letters for easier sorting and displaying in order
        Letter[] total = {aletter,bletter,cletter,dletter,eletter,fletter,gletter,hletter,iletter,jletter,kletter};
        Letter temp;
        int length = total.length;
//        System.out.println(length);
//        System.out.println(total[0].getCount());

        for(int f = 0; f < total.length; f++){
            if(total[f].getCount() > 0) {
                System.out.println(" " + total[f].getLet() + "        " + total[f].getCount());
            }
        }
        int srt = 10;
        while(srt > 0) {
            for (int n = 0; n < 10; n++) {
                int currentCount = total[n].getCount();
                int nextCount = total[n + 1].getCount();
                if (currentCount > nextCount) {
                    temp = total[n + 1];
                    total[n + 1] = total[n];
                    total[n] = temp;
                }
            }
            srt--;
        }
        //Start of sorted bar graph
        System.out.println("");
        System.out.println("============= Vertical Bar =============");
        for(int i =biggest; i > 0; i--){
            if(i < 10) {
                System.out.print("|  " + i + " |  ");
            }else {
                System.out.print("| "+i+" |");
            }
            for (int u=0; u < total.length; u++){
                if (total[u].getCount() >= i){
                    System.out.print("*  ");
                }
                else {
                    System.out.print("   ");
                }
            }
            System.out.println("");
        }
        System.out.println("========================================");
        System.out.print("| No |  ");
        for( int j=0; j < total.length; j++){
            System.out.print(total[j].getLet()+"  ");
        }
        System.out.println("");
        System.out.println("========================================");

    }
}
