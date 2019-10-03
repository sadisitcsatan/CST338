public class test {
    public static void main(String[] args) {
        String str = "catcat";
        int count = 0;
        int ocount = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            String test = str.substring(i, i + 3);
            System.out.println(test);
            if (test.equals("cat")) {
                count++;
            }
            if (test.equals("dog")) {
                ocount++;
            }
        }
    }

}
