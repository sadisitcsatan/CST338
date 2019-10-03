import java.util.Scanner;

public class kattis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        //System.out.println(num);
        String binary = Integer.toBinaryString(num);
        //System.out.println(binary);
        StringBuilder edits = new StringBuilder(binary);
        for (int i = 0; i < binary.length() && !(i >= binary.length()-i); i++) {
            char hold = edits.charAt(i);
            edits.setCharAt(i, edits.charAt(edits.length()-1-i));
            //System.out.println(edits.charAt(i));
            edits.setCharAt(edits.length()-1-i,hold);
        }
        //System.out.println(edits);
        String nBin = edits.toString();
        //System.out.println(nBin);
        int fin = Integer.parseInt(nBin, 2);
        System.out.println(fin);
    }

}
