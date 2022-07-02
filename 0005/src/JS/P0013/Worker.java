package JS.P0013;

/**
 *
 * @author Duy Thanh
 */
public class Worker {

    private final String name; //name of worker
    private final int age; //age of worker
    private long salary; //salary of worker
    private final String workLocation; //workLocation of worker

    /**
     * Constructor
     *
     * @param name of worker from user
     * @param age of worker from user
     * @param salary of worker from user
     * @param workLocation of worker from user
     */
    public Worker(String name, int age, long salary, String workLocation) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    //Some usage set/get methods

    /**
     * Get the name of worker
     * @return name getter
     */
    public String getName() {
        return name;
    }

    /**
     * Get the age of worker
     * @return age getter
     */
    public int getAge() {
        return age;
    }

    /**
     * Get the salary of worker
     * @return salary getter
     */
    public long getSalary() {
        return salary;
    }

    /**
     * Set the salary of worker
     * @param salary
     */
    public void setSalary(long salary) {
        this.salary = salary;
    }
}
