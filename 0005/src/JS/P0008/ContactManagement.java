package JS.P0008;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Duy Thanh
 */
public class ContactManagement {
   
    private ArrayList<Contact> CList = new ArrayList<>();
    private ArrayList<Contact> saveList = new ArrayList<>();

    /**
     * Function add contract user input
     */
    public void addContact() {
        //user enter information
        int id = getID();
        System.out.print("Enter Full Name: ");
        String name = "";
        String firstName = "";
        String lastName = "";
        //loop to enter again if user enter a part of name
        while (true) {
            name = validator.getString();
            //check uẻ enter full name or not
            boolean checkSpace = checkSpace(name);
            //check space in name or not
            if (!checkSpace) {
                System.out.println("Please enter full name!");
            } else {
                String[] fullname = name.split("\\s", 2);
                firstName = fullname[0];
                lastName = fullname[1];
                break;
            }
        }
        System.out.print("Enter Group: ");
        String group = validator.getString();
        System.out.print("Enter Address: ");
        String address = validator.getString();
        System.out.println(" Please input Phone flow:\n"
                + " - 1234567890\n"
                + " - 123-456-7890\n"
                + " - 123-456-7890 x1234\n"
                + " - 123-456-7890 ext1234\n"
                + " - (123)-456-7890\n"
                + " - 123.456.7890\n"
                + " - 123 456 7890");
         System.out.println("Enter Phone: ");
        String phone = validator.getPhone();
        //add contact to list
        CList.add(new Contact(id, name, firstName, lastName, group, address, phone));
        saveList.add(new Contact(id, name, firstName, lastName, group, address, phone));
        System.out.println("Add Contact Successfuly!");
    }

    /**
     * Function show display 
     */
    public void displayAll() {
        //check list is empty or not
        if (CList.isEmpty()) {
            System.out.println("List is empty! Add contact first!");
        } else {
            //display information
            System.out.printf("%-5s%-15s%-13s%-10s%-10s%-10s%-15s\n",
                    "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
            for (int i = 0; i < CList.size(); i++) {
                displayer.displayContact(CList.get(i));
            }
        }
    }

    /**
     * Function delete contract 
     */
    public void deleteContact() {
        //check list is empty or not
        if (CList.isEmpty()) {
            System.out.println("List is empty! Add contact first!");
        } else {
            //User enter ID to delete
            System.out.print("Enter ID to delete: ");
            int IdInput = validator.getInt();
            //check id is in list or not
            boolean checkID = checkIDExist(IdInput);
            if (checkID) {
                //loop to access from first to last element in list
                for (int i = 0; i < CList.size(); i++) {
                    //remove id
                    if (IdInput == CList.get(i).getId()) {
                        CList.remove(i);
                        System.out.println("Delete Successful!");
                        break;
                    }
                }
            } else {
                System.out.println("ID not found!");
            }
        }
    }
    // Check list id 
    private int getID() {
        //check list is empty or not
        if (saveList.isEmpty()) {
            return 1;
        } else {
            int size = saveList.size();
            //take last id in list
            int id = saveList.get(size - 1).getId() + 1;
            return id;
        }
    }
    //Check id in list
    private boolean checkIDExist(int IdInput) {
        boolean check = false;
        //loop to access from first to last element in list
        for (int i = 0; i < CList.size(); i++) {
            //find id in list
            if (IdInput == CList.get(i).getId()) {
                check = true;
                break;
            }
        }
        return check;
    }
    // Check user space in string name
    private boolean checkSpace(String name) {
        //creat regex to check space
        Pattern space = Pattern.compile("[\\s]");
        Matcher hasSpace = space.matcher(name);
        //check space in name
        if (hasSpace.find()) {
            return true;
        } else {
            return false;
        }
    }
}
