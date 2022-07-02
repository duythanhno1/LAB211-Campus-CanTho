package JS.P0008;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Duy Thanh
 */
public class validator {

    /**
     * Function check user choose menu  
     * @param min value 
     * @param max value
     * @return user input form min - max value is connect 
     */
    public static int getInputMenu(int min, int max) {
        int userInput = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                userInput = Integer.parseInt(sc.nextLine());
                //If input in range of menu --> out loop
                if (userInput >= min && userInput <= max) {
                    break;
                } //if input out range of menu tell user enter again
                else {
                    System.out.println("Please enter the number and in rage of "
                            + min + " - " + max);
                }
            } //if input is not number tell user enter number
            catch (Exception e) {
                System.out.println("Please enter the number and in rage of "
                        + min + " - " + max);
            }
        } while (true);
        return userInput;
    }

    /**
     * Function check user input 
     * @return user input string for name
     */
    public static String getString() {
        Scanner getInput = new Scanner(System.in);
        String userInput = "";
        //loop for user enter again
        while (true) {
            userInput = getInput.nextLine().trim();
            boolean checkLegal = true;
            //check if user enter anything or not
            if (!userInput.matches("[a-zA-Z]+[.]{0,1}[a-zA-Z0-9 ]+[.]{0,1}")) {
                System.out.println("You didn't enter anything! Try again!");
                checkLegal = false;
            }
            //check special
            Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
            Matcher hasSpeacial = special.matcher(userInput);
            //check string contain special or not
            if (hasSpeacial.find()) {
                System.out.println("String not contain special! Try again!");
                checkLegal = false;
            }
            char[] array = userInput.toCharArray();
            //loop to acces from first to last element in array
            for (int i = 0; i < array.length; i++) {
                //check string contain number or not
                if (Character.isDigit(array[i])) {
                    System.out.println("String not contain number! Try again!");
                    checkLegal = false;
                    break;
                }
            }
            if (checkLegal) {
                userInput = userInput.replaceAll("\\s+", " ");
                userInput = userInput.trim();
                break;
            }
        }
        return userInput;
    }

    /**
     * Function check input phone number 
     * @return the user input is format pattern  
     */
    public static String getPhone() {
        Scanner getInput = new Scanner(System.in);
        String userInput = "";
        while (true) {
            //user enter input
            userInput = getInput.nextLine();
            //check illegal format or not
            Pattern format1 = Pattern.compile("^\\d{10}$");
            Matcher check1 = format1.matcher(userInput);
            Pattern format2 = Pattern.compile("^\\d{3}[-]\\d{3}[-]\\d{4}$");
            Matcher check2 = format2.matcher(userInput);
            Pattern format3 = Pattern.compile("^\\d{3}[-]\\d{3}[-]\\d{4}[\\s][x]\\d{4}$");
            Matcher check3 = format3.matcher(userInput);
            Pattern format4 = Pattern.compile("^\\d{3}[-]\\d{3}[-]\\d{4}[\\s][e][x][t]\\d{4}$");
            Matcher check4 = format4.matcher(userInput);
            Pattern format5 = Pattern.compile("^[(]\\d{3}[)][-]\\d{3}[-]\\d{4}$");
            Matcher check5 = format5.matcher(userInput);
            Pattern format6 = Pattern.compile("^\\d{3}[\\.]\\d{3}[\\.]\\d{4}$");
            Matcher check6 = format6.matcher(userInput);
            Pattern format7 = Pattern.compile("^\\d{3}[\\s]\\d{3}[\\s]\\d{4}$");
            Matcher check7 = format7.matcher(userInput);
            //check correct format
            if (check1.find() || check2.find() || check3.find() || check4.find()
                    || check5.find() || check6.find() || check7.find()) {
                break;
            } else {
                System.out.println("Wrong format! Try again!");
            }
        }
        return userInput;
    }

    /**
     * Function check input number 
     * @return the user input must is integer or exception 
     */
    public static int getInt() {
        int userInput = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                //user enter input
                userInput = Integer.parseInt(sc.nextLine());
                break;
            } //if input is not number tell user enter number
            catch (Exception e) {
                System.out.println("Please enter number");
            }
        } while (true);
        return userInput;
    }

}
