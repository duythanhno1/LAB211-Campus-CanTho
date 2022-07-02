/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JS.P0022;

/**
 *
 * @author Duy Thanh
 */
public class Account {

    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String dateOfBirth;

    public Account() {
    }
    /**
     * Constructor
     * @param username of user
     * @param password of user
     * @param name of user
     * @param phone of user
     * @param email of user
     * @param address of user
     * @param dateOfBirth  of user
     * 
     */
    public Account(String username, String password, String name, String phone, String email, String address, String dateOfBirth) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }
    /**
     * get method
     * @return username trả về giá trị username 
     */
    public String getUsername() {
        return username;
    }
    /**
     * Set method
     * @param username Nhập giá trị name
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Get method
     * @return password trả về giá trị password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Set method
     * @param password nhập giá trị password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * get method
     * @return name trả về giá trị name
     */
    public String getName() {
        return name;
    }
    /**
     * Set method
     * @param name nhập name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get method
     * @return phone trả về phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Set method
     * @param phone nhập phone 
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * get method
     * @return  email trả về giá trị email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Set method
     * @param email nhập email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * get method
     * @return address trả về giá trị address
     */
    public String getAddress() {
        return address;
    }
    /**
     * Set method
     * @param address nhập address 
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * Get method 
     * @return dateOfBirth trả về giá trị dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     * Set method
     * @param dateOfBirth nhập dateOfBirth 
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
