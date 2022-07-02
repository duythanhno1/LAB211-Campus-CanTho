package JS.P0013;

import static Check.Input.InputLab.getInputCode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static Check.Input.InputLab.getInputInteger;
import static Check.Input.InputLab.getInputLocation;
import static Check.Input.InputLab.getInputName;
import static Check.Input.InputLab.getInputSalary;
import static Check.Input.InputLab.getInputString;

//Class for managing the worker and salary change history

/**
 *
 * @author Duy Thanh
 */
public class WorkerManagement {

    //HashMap for storing all the workers base on workers code
    HashMap<String, Worker> workers = new HashMap<>();

    //List for storing all the salary change
    List<SalaryChange> history = new ArrayList<>();

    /**
     * Function to add new worker base on user input
     */
    public void addWorker() {
        System.out.println("\n========= Add Worker =========");
        //new scanner
        Scanner sc = new Scanner(System.in);

        //get code input from user
        String code = null;
        //loop until the code is not null
        while (code == null) {
            code = getInputCode(sc, "Enter code: ");
            if (isExistCode(code)) { //if the code is exist, code = null to continue to loop
                //if the code is exist
                System.out.println("The code of this worker is duplicate");
                code = null;
            }
        }

        //get input name, age, salary, work location of worker from user
        String name = getInputName(sc, "Enter name: ");
        int age = getInputInteger(sc, "Enter age: ", 18, 50);

        //initialize salary = null
        Long salary = getInputSalary(sc, "Enter salary: ");

        String workLocation = getInputLocation(sc, "Enter work location: ");

        //add the worker to HashMap
        workers.put(code, new Worker(name, age, salary, workLocation));
        System.out.println("Add new worker successfully");

    }

    /**
     * Function to increase a worker's salary base on the code
     */
    public void salaryUp() {
        //if there are no worker in the database, no update will happen
        if (this.workers.size() == 0) {
            System.out.println("There are no worker in the database.");
            return;
        }
        System.out.println("\n ========= Up Salary =========");
        //new scanner
        Scanner sc = new Scanner(System.in);
        //get code input from user
        String code = null;
        //loop until the code is not null
        while (code == null) {
            code = getInputString(sc, "Enter code: ");
            if (!isExistCode(code)) { //if the code is exist, code = null to continue to loop
                //if the code is exist
                System.out.println("The code of this worker is not exist");
                code = null;
            }
        }
        //get amount of money from user
        Long salaryChange = getInputSalary(sc, "Enter salary: ");

        //update the worker salary.
        long newSalary = workers.get(code).getSalary() + salaryChange;
        workers.get(code).setSalary(newSalary);

        //get current date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();

        //add the change to the history
        history.add(new SalaryChange(code, workers.get(code).getName(), workers.get(code).getAge() + "",
                newSalary + "", "UP", dtf.format(now)));
        System.out.println("Increase salary successfully");
    }

    /**
     * Function to decrease the worker's salary base on the code
     */
    public void salaryDown() {
        //if there are no worker in the database, no update will happen
        if (this.workers.isEmpty()) {
            System.out.println("There are no worker in the database.");
            return;
        }
        System.out.println("\n ========= Down Salary =========");

        //new scanner
        Scanner sc = new Scanner(System.in);
        //get code input from user
        String code = null;
        //loop until the code is not null
        while (code == null) {
            code = getInputString(sc, "Enter code: ");
            if (!isExistCode(code)) { //if the code is exist, code = null to continue to loop
                //if the code is exist
                System.out.println("The code of this worker is not exist");
                code = null;
            }
        }

        //get current salary of worker from code
        long currentSalary = workers.get(code).getSalary();
        //get amount of money from user
        Long salaryChange = null;
        while (salaryChange == null) {
            salaryChange = getInputSalary(sc, "Enter salary: ");
            if (salaryChange >= currentSalary) {
                System.out.println("The amount of money must less than " + currentSalary);
                salaryChange = null;
            }
        }

        //update the worker salary.
        long newSalary = currentSalary - salaryChange;
        workers.get(code).setSalary(newSalary);

        //get current date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();

        //add the change to the history
        history.add(new SalaryChange(code, workers.get(code).getName(), workers.get(code).getAge() + "",
                newSalary + "", "DOWN", dtf.format(now)));
        System.out.println("Decrease salary successfully");

    }

    /**
     * Function to display all salary changes in the history
     */
    public void getInfomationSalary() {
        //if there is no change in the history, announce and return
        if (this.history.isEmpty()) {
            System.out.println("There are no data in the history currently");
            return;
        }
        //display the result
        System.out.println("\n========= Display Information Salary =========");
        //template for printf
        String template = "%-6s%-14s%-14s%-13s%-13s%-12s\n";
        //columns' name
        System.out.printf(template, "Code", "Name", "Age", "Salary", "Status", "Date");
        //printing each of the change in the history
        for (SalaryChange change : this.history) {
            System.out.printf(template, change.getCode(), change.getName(), change.getAge(), change.getSalary(),
                    change.getStatus(), change.getDate());
        }
    }

    /**
     * Function to check if the code is exist or not
     *
     * @param code _ the code that need to be checked
     * @return true if the code is exist, false otherwise
     */
    public boolean isExistCode(String code) {
        return (workers.get(code) != null);
    }
}
