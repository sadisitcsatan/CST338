import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class kattis {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        File f = new File("sample.txt");
        Scanner sc = null;
        try {
             sc = new Scanner(f);
        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }
        //Scanner sc = new Scanner(f);
        int[] all =new int[1];
        List<Integer> one = new ArrayList<Integer>();
        List<Integer> two = new ArrayList<Integer>();
        int hold = 1;

        while (hold != 0) {
            hold = sc.nextInt();
            //System.out.println(hold);
            all[all.length-1] = hold;
            int[] temp = new int[all.length + 1];
            for (int i = 0; i < all.length; i++){
                temp[i] = all[i];
            }
            all = temp;
            //System.out.println(all[all.length-2]);
        }
        System.out.println(all.length);
        for (int i = 0; i < ((all.length-1) / 2); i++) {
            one.add(all[i]);
        }
        for (int j = (all.length-1) / 2; j < all.length-2; j++) {
            two.add(all[j]);
        }
        System.out.println(one);
        System.out.println(two);
        List<Integer> asorted = new ArrayList<>(one.size());
        asorted.addAll(one);
        List<Integer> bsorted = new ArrayList<>(two.size());
        bsorted.addAll(two);
        Collections.sort(asorted);
        Collections.sort(bsorted);
        System.out.println(asorted);
        System.out.println(bsorted);

    }

}
//    public static void Tri(){
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();
//        if(a + b == c){
//            System.out.println(a + "+"+ b + "="+c);
//        }else if(a*b == c){
//            System.out.println(a + "*"+ b + "="+c);
//        }else if(a/b == c){
//            System.out.println(a + "/"+ b + "="+c);
//        }else if (a-b == c){
//            System.out.println(a + "-"+ b + "="+c);
//        }else if(c*b == a){
//            System.out.println(a + "="+ b + "*"+c);
//        }else if(b/c == a){
//            System.out.println(a + "="+ b + "/"+c);
//        }else if (b-c == a){
//            System.out.println(a + "="+ b + "-"+c);
//        }else if (c+b == a){
//            System.out.println(a + "="+ b + "+"+c);
//        }
//    }
//    public static void Statistics(){
//        Scanner sc = new Scanner(System.in);
//        int caseCount = 1;
//        while(sc.hasNext()) {
//            String case1 = sc.nextLine();
//            String[] case11 = case1.split(" ");
//            int min = Integer.parseInt(case11[1]);
//            int max = Integer.parseInt(case11[1]);
//            int range;
//            int total = 0;
//            for (int i = 1; i < case11.length; i++) {
//                if (min > Integer.parseInt(case11[i])) {
//                    min = Integer.parseInt(case11[i]);
//                }
//                if (max < Integer.parseInt(case11[i])) {
//                    max = Integer.parseInt(case11[i]);
//                }
//                total += Integer.parseInt(case11[i]);
//            }
//            range = max - min;
//            System.out.println("Case "+ caseCount + ": " + min + " " + max + " " + range);
//            caseCount++;
//        }
//    }
//    public static void Retirement(){
//        Scanner sc = new Scanner(System.in);
//        int bAge = sc.nextInt();
//        int bPy = sc.nextInt();
//        int bY = sc.nextInt();
//        int aAge = sc.nextInt();
//        int aPy = sc.nextInt();
//        int atotal = 0;
//        int bTotal = (bPy-bAge) * bY;
//        int atime = 0;
//        //System.out.println(bTotal);
//        for(int i = 0; atotal <= bTotal; i++){
//            atotal = i * aPy;
//            atime = i;
//            //System.out.println(atotal);
//        }
//        System.out.println((atime + aAge));
//    }
//}
