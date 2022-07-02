package JS.P0012;

/**
 *
 * @author Duy Thanh
 */
public class Doctor {
    //initialize variables

    private String name; //name of doctor
    private String specialization; //specialization of doctor
    private int availability; //availability of doctor

    //ceating constructors

    /**
     * Create contractor 
     * @param name of doctor
     * @param specialization of doctor
     * @param availability of doctor
     */
    public Doctor(String name, String specialization, int availability) {
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    /**
     * get doctor's name
     *
     * @return name of doctor
     */
    public String getName() {
        return name;
    }

    /**
     * get doctor's specialization
     *
     * @return specialization of doctor
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * get doctor's availability
     *
     * @return availability of doctor
     */
    public int getAvailability() {
        return availability;
    }

}
