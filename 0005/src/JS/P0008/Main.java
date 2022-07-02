package JS.P0008;

/**
 *
 * @author Duy Thanh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private final static ContactManagement CM = new ContactManagement();

    public static void main(String[] args) {
        //loop to display menu again after finish option
        while (true) {
            //display menu for user
            displayer.displayMenu();
            //user choose option
            int userOption = validator.getInputMenu(1, 4);
            switch (userOption) {
                //Option 1: add contact
                case 1:
                    CM.addContact();
                    break;
                //Option 2:display all contact 
                case 2:
                    CM.displayAll();
                    break;
                //Option 3: delete contact
                case 3:
                    CM.deleteContact();
                    break;
                //Option 4: exit program
                case 4:
                    return;
            }
        }
    }

}
