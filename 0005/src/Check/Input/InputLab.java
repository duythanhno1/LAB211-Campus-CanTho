package Check.Input;

import java.util.Scanner;

/**
 *
 * @author Duy Thanh
 */
public class InputLab {

    /**
     * get user valid integer input
     *
     * @param scanner _ scanner
     * @param message _ instruction message for user input
     * @return the valid Integer
     */
    public static int getInputInteger(Scanner scanner, String message) {
        Integer input = null;
        //loop until the input is valid integer
        while (input == null) {
            try {
                input = Integer.parseInt(getInputString(scanner, message));
            } catch (NumberFormatException e) {
                System.out.println("Your input must be an integer");
            }
        }
        return input;
    }

    /**
     * contain at least one letter character
     *
     * @param scanner _ Scanner from Java Class
     * @param message _ instruction message for user input
     * @return the valid name
     */
    public static String getInputName(Scanner scanner, String message) {
        String input = null;

        //loop until the name is valid
        while (input == null) {
            input = getInputString(scanner, message);
            if (!input.matches("[a-zA-Z ]+[.]{0,1}[a-zA-Z0-9 ]+[.]{0,1}[a-zA-Z0-9 ]+[.]{0,1}")) {
                System.out.println("Worker name must start with a letter ");
                input = null;
            }
        }
        return input;
    }
    /**
     * Function to input from location worker
     *
     * @param scanner _ Scanner from Java Class
     * @param message _ instruction message for user input
     * @return the valid location 
     */
    public static String getInputLocation(Scanner scanner, String message) {
        String input = null;

        //loop until the name is valid
        while (input == null) {
            input = getInputString(scanner, message);
            //[a-zA-Z0-9/ ]+[,]{0,1}[a-zA-Z0-9/ ]+[,]{0,1}[a-zA-Z0-9/ ]+[,]{0,1}
            if (!input.matches("[a-zA-Z ]+[.]{0,1}[a-zA-Z0-9 ]+[.]{0,1}[a-zA-Z0-9 ]+[.]{0,1}")) {
                System.out.println("Worker location must start with a letter ");
                input = null;
            }
        }
        return input;
    }
    /**
     * Function to get integer input from a specific range
     *
     * @param scanner _ Scanner from Java Class
     * @param message _ instruction message for user input
     * @param min _ minimum value of the input
     * @param max _ maximum value of the input
     * @return the correct integer value
     */
    public static int getInputInteger(Scanner scanner, String message, int min, int max) {
        Integer input = null;
        while (input == null) {
            input = getInputInteger(scanner, message);
            if (input < min || input > max) {
                System.out.println("Your input must be from " + min + " to " + max);
                input = null;
            }
        }
        return input;
    }
    
    /**
     * Function to get input string and empty input
     *
     * @param scanner _ Scanner from Java Class
     * @param message _ instruction message for user input
     * @return the input string or empty string
     */
    public static String getInputStringAndEmpty(Scanner scanner, String message) {
        String input = null;
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    /**
     * get user valid string input (not empty)
     *
     * @param scanner _ Scanner from Java Class
     * @param message _ instruction message for user input
     * @return the valid String
     */
    public static String getInputString(Scanner scanner, String message) {
        String input = "";
        //loop until the input is not empty
        while (input.equals("")) {
            System.out.print(message);
            input = scanner.nextLine().trim();
            if (input.equals("")) {
                System.out.println("Your input can not be empty.");
            } 
        }
        return input;
    }

    /**
     * get user valid long input
     *
     * @param scanner _ Scanner from Java Class
     * @param message _ instruction message for user input
     * @return the valid Long
     */
    public static Long getInputLong(Scanner scanner, String message) {
        Long input = null;
        //loop until the input is valid integer
        while (input == null) {
            try {
                input = Long.parseLong(getInputString(scanner, message));
            } catch (NumberFormatException e) {
                System.out.println("Your input must be an integer");
            }
        }
        return input;
    }

    /**
     * get user valid salary input (integer, > 0)
     *
     * @param scanner _ Scanner from Java Class
     * @param message _ instruction message for user input
     * @return the valid salary
     */
    public static long getInputSalary(Scanner scanner, String message) {
        Long salary = null;
        //loop until the salary is not null
        while (salary == null) {
            salary = getInputLong(scanner, "Enter salary: ");
            if (salary <= 0) { //only accept salary > 0
                System.out.println("Amount of money must greater than 0.");
                salary = null;
            }
        }
        return salary;
    }
    
    /**
     * get user code input 
     * @param scanner _ Scanner from Java Class
     * @param message _ instruction message for user input
     * @return the valid code
     */
    public static String getInputCode(Scanner scanner, String message) {
        String code = null;
        while (code == null) {
            code = getInputString(scanner, message);
            if (!code.matches("^[A-Za-z0-9 ]+$")) {
                System.out.println("Code must not contain special character");
                code = null;
            }
        }
         return code;
    }
}
