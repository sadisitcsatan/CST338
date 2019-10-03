// Java program to find type of input character
import java.io.*;

class charCheck {

    static void charCheck(char input_char)
    {
        // CHECKING FOR ALPHABET
        if ((input_char >= 65 && input_char <= 90)
                || (input_char >= 97 && input_char <= 122))
            System.out.println(" Alphabet ");

            // CHECKING FOR DIGITS
        else if (input_char >= 48 && input_char <= 57)
            System.out.println(" Digit ");

            // OTHERWISE SPECIAL CHARACTER
        else
            System.out.println(" Special Character ");
    }

    // Driver Code
    public static void main(String[] args)
    {
        char input_char = '$';
        charCheck(input_char);
        String str = "      Geeks     for    Geeks        ";

        // Call the replaceAll() method
        str = str.replaceAll("\\s", "");

        System.out.println(str);
    }

}

// This code is contributed by vt_m.
