package JL.P0018;

/**
 *
 * @author Duy Thanh
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Duy Thanh
 */
public class CheckInput {

    private static Scanner sc = new Scanner(System.in);
    //regex  check input numbers starting with 0 and 10 numbers
    private static final String PHONE_VALID = "^[0]+[0-9]{9}$";
    //regec check email format @abc.xyz......
    private static final String EMAIL_VALID = "^[A-Za-z]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)";
    private static final String EMAIL_VALID_1 = "^[_A-Za-z-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String EMAIL_VALID_2 = "^([_a-zA-Z-]+(\\\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\\\.[a-zA-Z0-9-]+)*(\\\\.[a-zA-Z]{1,6}))?$";
    final static String DATE_FORMAT = "dd/MM/yyyy";

    /**
     * Function check input choose
     *
     * @return input user
     */
    public static int checkInt() {
        try {
            System.out.println("Choose: ");
            int input = sc.nextInt();
            return input;
        } catch (Exception e) {
            System.out.println("Please input a number! Enter again: ");
            sc.nextLine();
            return checkInt();
        }
    }

    /**
     * Function check min and max input menu
     *
     * @param min input
     * @param max input
     * @return checkRangeInt value
     */
    public static int checkRangeInt(int min, int max) {
        int input = checkInt();
        if (input >= min && input <= max) {
            return input;
        } else {
            System.out.println("Out of range [ " + min + " - " + max + " ], type again:");
            return checkRangeInt(min, max);
        }
    }

    /**
     * Function input string
     *
     * @return string of input
     */
    public static String checkString() {
        try {
            String input = new Scanner(System.in).nextLine();
            return input;
        } catch (Exception e) {
            System.out.println("Please input a String! Enter again: ");
            sc.nextLine();
            return checkString();
        }
    }

    /**
     * Function check phone
     *
     * @return checkPhone of user
     */
    public static String checkPhone() {
        String input = checkString();
        if (input.matches(PHONE_VALID)) {
            return input;
        } else {
            System.out.println("Phone number must be 10 digits and start with 0");
            return checkPhone();
        }
    }

    /**
     * Function check email
     *
     * @return checkEmail of user
     */
    public static String checkEmail() {
   
            String input = checkString();
            System.out.print("Email: ");
            if (input.matches(EMAIL_VALID) || input.matches(EMAIL_VALID_1) || input.matches(EMAIL_VALID_2)) {
                return input;
            } else {
                System.out.println("Email must is correct format (abc123@xyz.com)");
                return checkEmail();
            }
     
    }

    /**
     * Function check date is format
     *
     * @return dateCheck of user
     */
    public static String checkDate() throws ParseException {
        Scanner sc = new Scanner(System.in);
        //DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        //Check exception date->30/2,31/2
        //df.setLenient(true);
        //Date date = new Date();
        while (true) {
            try {
                String result = sc.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.err.println("Re-input");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            } catch (ParseException ex) {
                System.err.println("Re-input");
            }
        }

    }

}
