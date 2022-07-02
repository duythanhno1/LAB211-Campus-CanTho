package JS.P0013;

import java.util.Scanner;

import static Check.Input.InputLab.getInputInteger;

/**
 *
 * @author Duy Thanh
 */
public class Main {

    /**
     * WorkerManagement as wm
     */
    public static WorkerManagement wm;

    /**
     * main function
     *
     * @param args args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //new WorkerManagement
            wm = new WorkerManagement();

            //variable to store user choice
            int userChoice = -1;

            //loop until user choice is 4
            do {
                //new scanner
                Scanner sc = new Scanner(System.in);

                //printing out the menu
                System.out.println("======== Worker Management =========\n"
                        + "1. Add Worker\n"
                        + "2. Up salary\n"
                        + "3. Down salary\n"
                        + "4. Display Information salary\n"
                        + "5. Exit");

                //get the user choice from user (integer, 1-5)
                userChoice = getInputInteger(sc, " Please choose: ", 1, 5);

                //process base on userChoice
                switch (userChoice) {
                    case 1:
                        //add new worker
                        wm.addWorker();
                        sc.nextLine(); //stop the program for user to see the result
                        break;
                    case 2:
                        //increase salary for a worker
                        wm.salaryUp();
                        sc.nextLine(); //stop the program for user to see the result
                        break;
                    case 3:
                        //decrease salary for a worker
                        wm.salaryDown();
                        sc.nextLine(); //stop the program for user to see the result
                        break;

                    case 4:
                        //display all changes in salary
                        wm.getInfomationSalary();
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
