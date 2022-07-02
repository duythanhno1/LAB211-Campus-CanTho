package JL.P0023;

import JL.P0023.Display;
import JL.P0023.GetInput;

/**
 *
 * @author Duy Thanh
 */
public class Main {

    /**
     * Main run
     * @param args
     */
    public static void main(String[] args) {
        while (true) {

            //step1: display menu
            Display.displayMenu();

            //step2: Input choice
            int choice = GetInput.getInputChoice();

            switch (choice) {
                case 1:
                    //Step3: display result addition matrix
                    Display.displayAdditionMatrix();
                    break;
                case 2:
                    //Step4: display result subtraction matrix
                    Display.displaySubtractionMatrix();
                    break;
                case 3:
                    //Step5: display result multiplication matrix
                    Display.displayMultiplicationMatrix();
                    break;
                case 4:
                    //Step6: exit program
                    System.exit(0);
                    break;
            }
        }
    }
}