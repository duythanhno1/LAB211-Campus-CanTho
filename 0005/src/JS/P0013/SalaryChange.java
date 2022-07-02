package JS.P0013;

/**
 *
 * @author Duy Thanh
 */
public class SalaryChange {

    private final String code; //code of the worker that has change in salary
    private final String name; //name of the worker that has change in salary
    private final String age; //age of the worker that has change in salary
    private final String salary; //result salary of the worker that has change in salary
    private final String status; //status of the change (up/down)
    private final String date; //date of the change

    /**
     * Constructor
     *
     * @param code _code of the worker that has change in salary
     * @param name _name of the worker that has change in salary
     * @param age _age of the worker that has change in salary
     * @param salary _result salary of the worker that has change in salary
     * @param status _status of the change
     * @param date _date of the change
     */
    public SalaryChange(String code, String name, String age, String salary, String status, String date) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
        this.date = date;
    }

    //Get methods

    /**
     * Get code of worker
     * @return code getter
     */
    public String getCode() {
        return code;
    }

    /**
     * Get name of worker
     * @return name getter
     */
    public String getName() {
        return name;
    }

    /**
     * Get age of worker
     * @return age getter
     */
    public String getAge() {
        return age;
    }

    /**
     * Get salary  of worker
     * @return salary getter
     */
    public String getSalary() {
        return salary;
    }

    /**
     * Get Status of worker
     * @return status getter
     */
    public String getStatus() {
        return status;
    }

    /**
     * Get Date of worker
     * @return date getter
     */
    public String getDate() {
        return date;
    }
}
