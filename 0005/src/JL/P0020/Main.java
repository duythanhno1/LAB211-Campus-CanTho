package JL.P0020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Duy Thanh
 */
public class Main {

    private static final Scanner in = new Scanner(System.in);

    // Check number is Square
    private static boolean checkSquareNumber(int n) {
        // Check param user input is quarenumber
        if (Math.sqrt(n) * Math.sqrt(n) == n) {
            // value correct
            return true;
        }
        return false;
    }

    private static void getNumber(String inputString) {
        HashMap<String, ArrayList<Integer>> hmNumber = new HashMap<>();
        //Check regular to is number \\D
        String number = inputString.replaceAll("\\D+", ",");
        if (number.charAt(0) == ',') {
            number = number.substring(1);
        }
        if (number.charAt(number.length() - 1) == ',') {
            number = number.substring(0, number.length() - 1);
        }
        String[] listNumber = number.split(",");
        int lenNumber = listNumber.length;
        // Create arraylist 
        ArrayList<Integer> liPerfectSquare = new ArrayList<>();
        ArrayList<Integer> liOdd = new ArrayList<>();
        ArrayList<Integer> liEven = new ArrayList<>();
        ArrayList<Integer> liAll = new ArrayList<>();
        for (int i = 0; i < lenNumber; i++) {
            int numberCheck = Integer.parseInt(listNumber[i]);
            //Check number is odd
            if (numberCheck % 2 == 1) {
                liOdd.add(numberCheck);
            }
            //Check number is Even
            if (numberCheck % 2 == 0) {
                liEven.add(numberCheck);
            }
            // Check Squarenumber 
            if (checkSquareNumber(numberCheck)) {
                liPerfectSquare.add(numberCheck);
            }
            liAll.add(numberCheck);
        }
        hmNumber.put("Perfect Square Numbers: ", liPerfectSquare);
        hmNumber.put("Odd Numbers: ", liOdd);
        hmNumber.put("Even Numbers: ", liEven);
        hmNumber.put("All Numbers: ", liAll);
        // List elemen in hashmap and print 
        for (Map.Entry m : hmNumber.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

    private static void getCharacter(String inputString) {
        HashMap<String, String> hmString = new HashMap<>();
        // Check regular to uppercase a-z 
        String uppercase = inputString.replaceAll("\\W|[0-9]|[a-z]", "");
        // Check regular to lowercase A-Z
        String lowercase = inputString.replaceAll("\\W|[0-9]|[A-Z]", "");
        // Check regular to special
        String special = inputString.replaceAll("\\w", "");
        // Check regular to character
        String allCharacter = inputString.replaceAll("\\W\\w|[0-9]", "");
        hmString.put("Uppercase: ", uppercase);
        hmString.put("Lowercase: ", lowercase);
        hmString.put("Special: ", special);
        hmString.put("All Character: ", allCharacter);
        // Elemen Hashmap and print 
        for (Map.Entry m : hmString.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

    }

    /**
     * Main run and check user input null
     *
     * @param args
     */
    public static void main(String[] args) {
        //getNumber("32hg321sdhkjDFGH!@#$%^22fdsf3fdgdf/");
        //getCharacter("32hg321sdhkjDFGH!@#$%^22fdsf3fdgdf/");
        System.out.println("Input String: ");
        String content = in.nextLine();
        //loop check user input null 
        while (content.trim().isEmpty() || !content.matches("[a-zA-Z0-9]+[\\w\\W]+{1,30}") ) {
            System.out.println("The String cant empty");
            content = in.nextLine();
        }
        getNumber(content);
        getCharacter(content);
    }

}
