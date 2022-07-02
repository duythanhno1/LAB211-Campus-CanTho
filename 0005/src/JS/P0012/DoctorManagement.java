package JS.P0012;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Duy Thanh
 */
public class DoctorManagement {

    /**
     * get input string from user
     *
     * @param scanner get user input data
     * @param text user request quote
     * @return input check user input null
     */
    public String getInputString(Scanner scanner, String text) {
        //initialize variables
        String input = "";
        //loop until check is empty
        while (input.equals("")) {
            System.out.print(text);
            //get input form user
            input = scanner.nextLine().trim();
            //if input equals be empty
            if (input.equals("")) {
                System.out.println("Your input can not be empty!");
            }
        }
        // return input
        return input;
    }

    /**
     * get input integer from user
     *
     * @param scanner get user input
     * @param text user request quote
     * @return input check user input null
     */
    public int getInputInteger(Scanner scanner, String text) {
        //initializa variables
        Integer input = null;
        //loop until the input is not null  
        while (input == null) {
            try {
                input = Integer.parseInt(getInputString(scanner, text));
            } catch (NumberFormatException e) {
                System.out.println("Your input must be an integer!");
            }
        }
        // return input
        return input;
    }

    /**
     * get input name from user
     *
     * @param scanner get user input
     * @param text user request quote
     * @return input check user input null
     */
    public String getInputName(Scanner scanner, String text) {
        //initializa variables
        String input = null;
        String regex = "^[a-zA-Z ]+[.]{0,1}[a-zA-Z0-9 ]+[.]{0,1}[a-zA-Z0-9 ]+[.]{0,1}";
        //loop until the input is not null 
        while (input == null) {
            //get input from user
            input = getInputString(scanner, text);
            // if input don't matches regex
            if (!input.matches(regex)) {
                System.out.println("The dotor must start a letter");
                input = null;
            }
        }
        //return input
        return input;
    }

    /**
     * get code from user
     *
     * @param scanner get user input
     * @param text user request quote
     * @return input check user input null
     */
    public String getInputCode(Scanner scanner, String text) {
        //initializa variables
        String input = null;
        String regex = "^[A-Za-z0-9 ]+$";
        //loop until the input is not null 
        while (input == null) {
            //get input from user
            input = getInputString(scanner, text);
            // if input don't matches regex
            if (!input.matches(regex)) {
                System.out.println("The code only accept number and letter!");
                input = null;
            }
        }
        //return input
        return input;
    }

    /**
     * get input from user
     *
     * @param scanner get user input
     * @param text user request quote
     * @param min not less than 1
     * @param max Not more than 5
     * @return input check user input null or other value
     */
    public int getInputMaxMin(Scanner scanner, String text, int min, int max) {
        //initializa variables
        Integer input = null;
        //loop until the input is not null
        while (input == null) {
            input = getInputInteger(scanner, text);
            // if input < 1 or input > 5
            if (input < min || input > max) {
                System.out.println("Your input must be from " + min + " to " + max);
                input = null;
            }
        }
        //return input
        return input;
    }

    /**
     * get input string and empty
     *
     * @param scanner get user input
     * @param text user request quote
     */
    public static String getInputStringAndEmpty(Scanner scanner, String text) {
        //initializa variables
        String input = null;
        System.out.print(text);
        return scanner.nextLine().trim();
    }
    //creating HashMap
    HashMap<String, Doctor> DT = new HashMap<String, Doctor>();

    /**
     * check input is exist
     *
     * @param code check code is exist
     * @return get code is not null
     */
    public boolean isExistCode(String code) {
        return (DT.get(code) != null);
    }

    /**
     * Function to add doctor
     */
    public void addDoctor() {
        //Scanner
        Scanner scanner = new Scanner(System.in);
        // initializa variables and get input from user
        String code = getInputCode(scanner, "Enter code: ");
        //if code is exist
        if (!isExistCode(code)) {
            // initializa variables and get input from user
            String name = getInputName(scanner, "Enter name: ");
            String specialization = getInputString(scanner, "Enter specialization: ");
            Integer availablity = null;
            //loop until the availablity is not null
            while (availablity == null) {
                // initializa variables and get input from user
                availablity = getInputInteger(scanner, "Enter availability: ");
                //if availablity < 0
                if (availablity < 0) {
                    System.out.println("Availiability must be larger than 0!");
                    availablity = getInputInteger(scanner, "Enter availability: ");
                }
                // add doctor to HashMap
                DT.put(code, new Doctor(name, specialization, availablity));
                System.out.println("Add new doctor successfully.");
            }

        } else {
            //if doctor is not exist
            System.out.println("The code of this doctor is duplicate!");
        }
    }

    /**
     * Function to update doctor
     */
    public void updateDoctor() {
        //new scanner
        Scanner sc = new Scanner(System.in);
        //get code input from user
        String code = getInputCode(sc, "Enter code: ");
        //check if the code is exist or not
        if (!isExistCode(code)) { //if the code is not exist
            System.out.println("Doctor code does not exist");
        } else { //if the code is exist, update the doctor
            //get name input from user
            String name = getInputStringAndEmpty(sc, "Enter name: ");
            if (name.equals("")) { //if input is empty, name stay the same
                name = DT.get(code).getName();
            }
            //get specialization input from user
            String specialization = getInputStringAndEmpty(sc, "Enter specialization: ");
            if (specialization.equals("")) { //if specialization is empty, specialization stay the same
                specialization = DT.get(code).getSpecialization();
            }
            //get availability input from user
            Integer availability = null;
            //loop until availability is not null
            while (availability == null) {
                //temp var to store string input
                String temp = getInputStringAndEmpty(sc, "Enter availability: ");
                if (temp.equals("")) { //if input is empty, availability stay the same
                    availability = DT.get(code).getAvailability();
                } else { //if not
                    try { //check if the Availability is integer and > 0
                        availability = Integer.parseInt(temp);
                        if (availability < 0) {
                            System.out.println("Availability must be greater than 0");
                            availability = null;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Your input must be an integer");
                    }
                }
            }
            //update the doctor
            DT.put(code, new Doctor(name, specialization, availability));
            System.out.println("Update successfully");
        }
    }

    /**
     * Function to delete doctor
     */
    public void deleteDoctor() {
        //new scanner
        Scanner sc = new Scanner(System.in);
        //get input code from user
        String code = getInputCode(sc, "Enter code: ");
        //check if the code is exist or not
        if (isExistCode(code)) { //if the code is exist, remove the doctor
            DT.remove(code);
            System.out.println("Delete successfully");
        } else { //if not, announce the user
            System.out.println("The code does not exist");
        }
    }

    /**
     * Function to search for Doctors
     */
    public void searchDoctor() {
        //new scanner
        Scanner sc = new Scanner(System.in);
        //get key word from user
        String text = getInputCode(sc, "Enter text: ");
        //HashMap for storing the result
        HashMap<String, Doctor> result = new HashMap<String, Doctor>();
        //variable for storing the widths of the columns
        int widthCode = 4;
        int widthName = 4;
        int widthSpecialization = 14;
        int widthAvailability = 12;
        //iterate through the HashMap
        for (Map.Entry<String, Doctor> doc : this.DT.entrySet()) {
            //if the name of the target doctor contains the keyword ignorecase
            if (doc.getValue().getName().toLowerCase().contains(text.toLowerCase())) {
                //put the target doctor to the HashMap
                result.put(doc.getKey(), doc.getValue());
                //update the width variables
                widthCode = Math.max(widthCode, doc.getKey().length());
                widthName = Math.max(widthName, doc.getValue().getName().length());
                widthSpecialization = Math.max(widthSpecialization, doc.getValue().getSpecialization().length());
                widthAvailability = Math.max(widthAvailability, (doc.getValue().getAvailability() + "").length());
            }
        }
        //if there is a result, display it
        if (result.size() > 0) {
            displayResult(result, widthCode, widthName, widthSpecialization, widthAvailability);
        } else { //if not, print "not found"
            System.out.println("Not found");
        }
    }

    /**
     * Function to display the searching result in table format
     *
     * @param result _ HashMap storing the searching result
     * @param widthCode _ width of the Code column
     * @param widthName _ width of the Name column
     * @param widthSpecialization _ width of the Specialization column
     * @param widthAvailability _ width of the Availability column
     */
    public void displayResult(HashMap<String, Doctor> result, int widthCode, int widthName, int widthSpecialization, int widthAvailability) {
        //Create the bar line of the table base on the columns' width
        String bar = "+";
        for (int i = 0; i < widthCode + 2; i++) {
            bar += "-";
        }
        bar += "+";
        for (int i = 0; i < widthName + 2; i++) {
            bar += "-";
        }
        bar += "+";

        for (int i = 0; i < widthSpecialization + 2; i++) {
            bar += "-";
        }
        bar += "+";

        for (int i = 0; i < widthAvailability + 2; i++) {
            bar += "-";
        }
        bar += "+";

        //create the template for printing the result
        String template = "| %-" + widthCode + "s | %-" + widthName + "s | %-" + widthSpecialization + "s | %" + widthAvailability + "s |\n";

        //print the result
        System.out.println(bar);
        System.out.printf(template, "Code", "Name", "Specialization", "Availability");
        System.out.println(bar);
        //iterate all the results and display them base on the template
        for (Map.Entry<String, Doctor> entry : result.entrySet()) {
            System.out.printf(template, entry.getKey(), entry.getValue().getName(), entry.getValue().getSpecialization(), entry.getValue().getAvailability());
        }
        System.out.println(bar);
    }

}
