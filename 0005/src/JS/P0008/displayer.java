package JS.P0008;

/**
 *
 * @author Duy Thanh
 */
public class displayer {

    /**
     * Function print menu choose
     */
    public static void displayMenu() {
        System.out.println("===========Menu===========");
        System.out.println("1. Add Contact");
        System.out.println("2. Display All Contact");
        System.out.println("3. Delete contact");
        System.out.println("4. Exit");
        System.out.print("Choose option: ");
    }
    // Contact display 
    static void displayContact(Contact C) {
        System.out.printf("%-5d%-15s%-13s%-10s%-10s%-10s%-15s\n",
                C.getId(), C.getName(), C.getFirstName(), C.getLastName(), C.getGroup(), C.getAddress(), C.getPhone());
    }

}
