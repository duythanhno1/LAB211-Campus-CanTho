package JS.P0008;

/**
 *
 * @author Duy Thanh
 */
public class Contact {

    private int id;
    private String name;
    private String firstName;
    private String lastName;
    private String group;
    private String address;
    private String phone;

    /**
     * Constructor
     */
    public Contact() {
    }

    /**
     * Constructor
     * @param id user input
     * @param name user input
     * @param firstName user input
     * @param lastName user input
     * @param group user input
     * @param address user input
     * @param phone user input
     */
    public Contact(int id, String name, String firstName, String lastName, String group, String address, String phone) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    /**
     * Get the value Id
     * @return getter id
     */
    public int getId() {
        return id;
    }

    /**
     * Set value for ID
     * @param id setter
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Get value of name
     * @return getter name
     */
    public String getName() {
        return name;
    }

    /**
     * Set value for name

     * @param name setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get value of first name
     * @return first name getter
     */
    public String getFirstName() {
        return firstName;
    }



    /**
     * Set value for first name
     * @param firstName setter
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get value of last name
     * @return last name getter
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set value for last name
     * @param lastName setter
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * Get value of group
     * @return group getter
     */
    public String getGroup() {
        return group;
    }


    /**
     * Set value for group
     * @param group setter
     */
    public void setGroup(String group) {
        this.group = group;
    }


    /**
     * Get value of address
     * @return address getter
     */
    public String getAddress() {
        return address;
    }


    /**
     * Set value for address
     * @param address setter
     */
    public void setAddress(String address) {
        this.address = address;
    }


    /**
     * Get value of phone
     * @return phone getter
     */
    public String getPhone() {
        return phone;
    }

    /**
     * set value for phone
     * @param phone setter
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
