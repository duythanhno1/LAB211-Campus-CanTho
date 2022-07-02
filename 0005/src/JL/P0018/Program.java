package JL.P0018;

import java.text.ParseException;

/**
 *
 * @author Duy Thanh
 */
public class Program {

    /**
     * Main run
     * @param args
     */
    public static void main(String[] args) throws ParseException {
        Menu pr = new Menu();
        //loop until user want to exit
        while (true) {
            int choose = pr.menu();
            switch (choose) {
                case 1:
                    // check phone 
                    pr.phone();
                    break;
                case 2:
                    // check email
                    pr.email();
                    break;
                case 3:
                    // check date
                    pr.date();
                    break;
                case 4:
                    // Exist
                    System.out.println("Good bye!");
                    System.exit(0);
            }
        }
    }
}
