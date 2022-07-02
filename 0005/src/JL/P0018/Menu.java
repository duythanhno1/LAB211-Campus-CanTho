/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JL.P0018;

import java.text.ParseException;

/**
 *
 * @author Duy Thanh
 */
public class Menu {

    /**
     * Function show menu
     * @return choose input of user
     */
    public int menu() {
        System.out.println("========== Validation Program ==========");
        System.out.println("1 - Check Phone");
        System.out.println("2 - Check Email");
        System.out.println("3 - Check Date");
        System.out.println("4 - Exit");
        int choose = CheckInput.checkRangeInt(1, 4);
        return choose;
    }

    /**
     * Function show menu input number phone
     */
    public void phone() {
        System.out.println("====== Validate Phone Number ======");
        System.out.println("Phone Number: ");
        String input = CheckInput.checkPhone();
        System.out.println("Correct phone number!");
        System.out.println("Your number is: " + input);
    }

    /** 
     * Function show menu input email
     */
    public void email() {
        System.out.println("====== Validate Email ======");
        System.out.println("Email: ");
        String input = CheckInput.checkEmail();
        System.out.println("Correct email! ");
        System.out.println("Your email is: " + input);
    }

    /**
     * Function show menu input date
     */
    public void date() throws ParseException {
        System.out.println("====== Validate Date ======");
        System.out.println("Date: ");
        String input = CheckInput.checkDate();
        System.out.println("Correct date format!");
        System.out.println("Day is: " + input);
    }
}
