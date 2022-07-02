package JS.P0012;

import java.util.Scanner;

/**
 *
 * @author Duy Thanh
 */
public class Main {

    /**
     * printing out the menu
     *
     * @param args
     */
    public static void main(String[] args) {
        DoctorManagement dm = new DoctorManagement();
        try {
            //new DoctorHash
            dm = new DoctorManagement();

            //variable to store user choice
            int userChoice = -1;

            //loop until user choice is 5
            do {
                //new scanner
                Scanner sc = new Scanner(System.in);

                //printing out the menu
                System.out.println(" DOCTOR MANAGEMENT\n"
                        + "1. Add Doctor.\n"
                        + "2. Update Doctor.\n"
                        + "3. Delete Doctor.\n"
                        + "4. Search Doctor.\n"
                        + "5. Exit.");

                //get the user choice from user (integer, 1-5)
                userChoice = dm.getInputMaxMin(sc, " Please choose: ", 1, 5);

                //process base on userChoice
                switch (userChoice) {
                    case 1:
                        //add new doctor
                        dm.addDoctor();
                        sc.nextLine(); //stop the program for user to see the result
                        break;
                    case 2:
                        //update existing doctor
                        dm.updateDoctor();
                        sc.nextLine(); //stop the program for user to see the result
                        break;
                    case 3:
                        //delete doctor
                        dm.deleteDoctor();
                        sc.nextLine(); //stop the program for user to see the result
                        break;
                    case 4:
                        //search for doctor base on key word
                        dm.searchDoctor();
                        sc.nextLine(); //stop the program for user to see the result
                        break;
                    case 5:
                        //exit the program
                        System.out.println("\nThank you for using our program.");
                        break;
                    default:
                        break;
                }
            } while (userChoice != 5);
        } catch (Exception e) {
        }
    }
}
