import java.util.Scanner;

/**
 * Author:Christopher Scott
 * Date:
 * Purpose:
 */
public class Draw {
    public static void main(String[] args){
//      initializing a Scanner which will then be
//      passed into a static method. 
        Scanner sc = new Scanner(System.in);

        //using a static method to get user input.
        int size = Draw.getSize(sc);

        while(size > 0){
            Draw.square(size);
            Draw.triangle(size);
            size =  getSize(sc);
        }
    }//end main

    /**
     * square
     * @param size
     *
     * square takes an int, size, and draws a
     * square on the screen i.e.
     * 3 ==
     *      * * *
     *      * * *
     *      * * *
     */

    public static void square(int size){
        //start the static method square here
        for(int i  = size; i > 0; i--){
            for (int j = size; j> 0; j--){
                System.out.print("* ");
            }
            System.out.println("");
        }
        System.out.println("");
        //start the static method square above here
    }

    /**
     * triangle
     * @param size
     * Takes an int, size, and returns a triangle with side
     * length == size. The side is on the left i.e.
     *  3 ==     *
     *         * *
     *       * * *
     */
    public static void triangle(int size){
        for(int i = 0; i< size;i++){
            for(int j = size; j >0; j--){
                if(i < (j-1)){
                    System.out.print("  ");
                }else {
                    System.out.print("* ");
                }

            }
            System.out.println("");
        }
    }
// start the code for the static method triangle, here.

//code for triangle goes above here.

    private static int getSize(Scanner sc){
        System.out.print("How many stars? (-1 to quit) :");
        //Use a scanner to read in values from the user and return input

        return Integer.parseInt(sc.nextLine());
    }
}