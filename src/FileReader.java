/*
 *author: Christopher Scott
 *date: 9/12/2019
 *Description: in class scanner practice
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
    private static void listing (String[] list) {
        for(int i = 0; i<list.length; i++){
            System.out.println(list[i].trim());
        }
    }

    public static void main(String[] args){


        String filename = "myfile.txt";
        File f = new File(filename);

        Scanner scan = null;
        try {
            if (f.createNewFile()) {
                System.out.println(filename + " created successfully");
            } else {
                System.out.println(filename + " already exists");
            }
            scan = new Scanner(f);
        }catch (FileNotFoundException e) {
            System.out.println("couldn't find " + filename);

        }catch (IOException e){
            System.out.println("Problem with making file " + e );
            e.printStackTrace();
        }
        while(scan != null && scan.hasNext()){
            String input = scan.nextLine();
            System.out.println(input);
            listing(input.split(","));
        }


//        boolean loop = true;
//        while(loop){
//            System.out.print("enter something (zz to exit)" );
//            String input = scan.nextLine();
//
//            if(input.trim().toLowerCase().equals("zz")){
//                loop = false;
//                //break;
//            }
        }

    }

