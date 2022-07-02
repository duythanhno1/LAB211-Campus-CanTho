package JL.P0023;
import java.util.Scanner;
/**
 *
 * @author Duy Thanh
 */

public class GetInput {

    /**
     * Function check input choice of user input
     * @return choice of user form 1 - 4
     */
    public static int getInputChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        //loop until user input correct
        while (true) {
            try {
                System.out.print("Your choice:");
                choice = Integer.parseInt(scanner.nextLine());
                //Check if value is within range
                if (choice >= 1 && choice <= 4) {
                    break;
                } else {
                    System.out.println("Request to choose from 1-4!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Values of matrix must be the number! and can be empty !");
            }
        }
        return choice;
    }

    /**
     * Function check user input matrix
     * @param mess user input
     * @return result matrix is a integer
     */
    public static int getInputMatrix(String mess) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        //loop until user input correct
        while (true) {
            System.out.print(mess);
            try {
                result = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Value of matrix is digit");
            }
        }
        return result;
    }

    /**
     * Function check user input row and colum
     * @param mess user input
     * @return result row and colum is a integer 
     */
    public static int GetInputRowColumn(String mess) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        //loop until user input correct
        while (true) {
            System.out.print(mess);
            try {
                result = Integer.parseInt(scanner.nextLine());
                //Check if value is positive numbers
                if (result > 0) {
                    break;
                } else {
                    System.out.println("Value must be positive");
                }
            } catch (NumberFormatException e) {
                System.out.println("Values of matrix must be the number and can be empty !");
            }
        }
        return result;
    }
}

