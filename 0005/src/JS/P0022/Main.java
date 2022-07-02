/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JS.P0022;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Duy Thanh
 */
public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static final String PHONE_VALID = "^[0]+[0-9]{9}$";

    /**
     * Lựa chọn chức năng menu
     *
     * @param min số nhỏ nhất có thể lựa chọn
     * @param max số lớn nhất có thể lựa chọn
     * @return trả về giá trị được nhập
     */
    private static int checkIntLimit(int min, int max) {
        while (true) { // lặp cho tới khi nhập đúng
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) { // nếu vượt quá min max quy định thì bắt nhập lại
                    throw new NumberFormatException();
                }
                return n; // trả về giá trị được nhập
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    /**
     * Kiểm tra giá trị date nhập vào
     * @param err : truyền vào giá trị biến err được khởi tạo ở hàm main
     * @return date trả về giá trị date
     */
    private static String checkInputDate(String err) {
         String date;
        //use while loop to read date until the date is valid.
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                date = sc.nextLine();
                //check if the date is in correct format (DD/MM/YYYY)
                if (!date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}$")) {
                    throw new Exception();
                }
                //d = day, m = month, y = year
                int d = Integer.parseInt(date.substring(0,2));
                int m = Integer.parseInt(date.substring(3, 5));
                int y = Integer.parseInt(date.substring(6, 10));

                //get the current date
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date currentDate = new Date();
                String current = dateFormat.format(currentDate).toString();
                int dN = Integer.parseInt(current.substring(0,2));
                int mN = Integer.parseInt(current.substring(3, 5));
                int yN = Integer.parseInt(current.substring(6, 10));
                //check if the date is valid
                if (yN < y || (yN == y && mN < m) || (yN == y && mN == m && dN < d)) // nếu nhập vào giống giá trị mà điều kiện thì quăng ngoại lệ bắt nhập lại
                    throw new Exception();
                if (d < 1 || m < 1 || m > 12 || y < 1) // nếu nhập vào giống giá trị mà điều kiện thì quăng ngoại lệ bắt nhập lại
                    throw new Exception();
                else if (((m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) && d > 31)
                        || ((m == 4 || m == 6 || m == 9 || m == 11) && d > 30)) {// nếu nhập vào giống giá trị mà điều kiện thì quăng ngoại lệ bắt nhập lại
                    throw new Exception();
                } else if ((y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) && m == 2 && d > 29)// nếu nhập vào giống giá trị mà điều kiện thì quăng ngoại lệ bắt nhập lại
                    throw new Exception();
                else if (d > 28 && m == 2)// nếu nhập vào giống giá trị mà điều kiện thì quăng ngoại lệ bắt nhập lại
                    throw new Exception();
                break;
            } catch (Exception e) {
                //print the error and repeat the loop
                System.out.printf("\033[0;31m"+"%s: "+"\033[0m", err);
            }
        }
        return date; // trả về giá trị date nhập vào
    }
    

    /**
     * Kiểm tra định dạng số điện thoại
     *
     * @return result trả về giá trị hợp lệ
     */
    private static String checkInputPhone() {
        while (true) { // lặp cho tới khi nhập đúng
            String result = in.nextLine().trim();
            if (result.matches(PHONE_VALID)) {  // nếu khớp với format thì trả về giá trị nhập
                return result; // trả về giá trị nhập
            } else { // thông báo lỗi 
                System.err.println("Re-input");
            }
        }
    }

    /**
     * Kiểm tra định dạng email
     *
     * @return email trả về giá trị email được nhập
     */
    private static String checkInputEmail() {
        String email = "";
        boolean valid = false;
        do { // kiểm tra giá trị được nhập

            email = in.nextLine();
            //Nếu đúng định dạng thì dừng
            if (email.matches("^(?=.{1,64}@)[A-Za-z_-]+[.A-Za-z0-9_-]*@[A-Za-z0-9]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
                valid = true;
            } else if (email.trim().equals("")) { // bỏ trống hoặc nhập khoảng trắng bắt nhập lại
                System.out.println("Email is not empty!!Enter again!!!");
                valid = false;
            } else { // hien thi thong bao
                System.out.println("Error!!Please enten again!!!!");
                valid = false;
            }

        } while (!valid); // lặp lại khi nhập sai
        return email; // trả về giá trị email
    }

    /**
     * kiểm tra định dạng password
     *
     * @return result trả về giá trị được nhập
     */
    private static String checkInputPassword() {
        String result = "";
        boolean valid = false;
        do { // kiểm tra dữ liệu nhập vào
            result = in.nextLine();
            //Nếu đúng định dạng thì dừng
            if (result.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$") || result.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
                    || result.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$") || result.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
                    || result.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$") || result.matches("[a-zA-Z0-9\\W]{6,}+")) {
                valid = true;
            } else if (result.trim().equals("")) { // nhập trắng hoặc bỏ trống thì nhập lại
                System.out.println("PassWord is not empty!!!!Enter again!!!");
                valid = false;
            } else { // hiển thị thông báo
                System.out.println("Error!!!!Enter again!!!");
                valid = false;
            }
        } while (!valid); // lặp lại khi nhập sai
        return result; // trả về giá trị được nhập
    }

    /**
     * Kiểm tra username
     *
     * @param la truyền vào danh sách
     * @return username trả về giá trị được nhập
     */
    private static String checkInputUsername(ArrayList<Account> la) {
        String userName = "";
        boolean userNameValid = false;
        do { // kiểm tra dữ liệu đầu vào
            userNameValid = false;
            userName = in.nextLine();
            if (userName.matches("[a-zA-Z][a-zA-Z0-9_.]{5,20}")) {
                userNameValid = true; // đúng format thì dừng
            } else if (userName.trim().equals("")) { // bỏ trống hoặc nhập khoảng trắng thì nhập lại
                System.out.println("UserName is not empty!!");
                userNameValid = false;
            } else { // thông báo lỗi bắt nhập lại
                System.out.println("Error!!Enter again!!!");
                userNameValid = false;
            }
        } while (!userNameValid); // lặp lại khi nhập sai

        return userName; // trả về giá trị username

    }

    /**
     * kiểm tra địa chỉ được nhập
     *
     * @return address trả về giá trị address
     */
    public static String checkAdress() {
        String adress = "";
        boolean valid = false;
        do { // kiểm tra dữ liệu nhập
            valid = false;

            adress = in.nextLine();
            if (adress.matches("[a-z0-9A-Z,/ ]+")) { // Nếu đúng định dạng thì dừng 
                valid = true;
            } else if (adress.trim().equals("")) { // nhập trắng hoặc bỏ trống nhập lại
                System.out.println("Address is not empty!!Enter Again!!!");
                valid = false;
            }
            else{ // trường hợp còn lại bắt nhập lại
                System.out.println("Wrong format!!!Enter again!!!");
                valid = false;
            }

        } while (!valid); // lặp lại khi nhập sai
        return adress; // trả về giá trị được nhập
    }

    /**
     * kiểm tra name
     *
     * @return name trả về giá trị được nhập
     */
    public static String checkInputName() {
        String name = "";
        boolean nameValid = false;
        do { // kiểm tra dữ liệu đầu vào
            nameValid = false;
            try {

                name = in.nextLine();
                if (name.charAt(0) < '0' || name.charAt(0) > '9') { // không được bắt đầu bằng số
                    // nhập đúng format thì dừng
                    if (name.matches("[a-zA-Z ]+[.]{0,1}[a-zA-Z0-9 ]+[.]{0,1}[a-zA-Z0-9 ]+[.]{0,1}") ) {
                        nameValid = true;
                    } else if (name.trim().equals("")) { // nhập trắng hoặc bỏ trống thì nhập lại
                        System.out.println("Name is not empty!!!Enter again!!!!");
                        nameValid = false;
                    } else { // hiển thị thông báo lỗi 
                        System.out.println("Error!!!Enter again!!!!");
                        nameValid = false;
                    }
                }
            } catch (Exception e) {
                System.out.println("Erorr!!!Enter Again!!!");
                nameValid = false;
            }
        } while (!nameValid); // lặp lại khi nhập sai
        return name; // trả về giá trị được nhập
    }

    /**
     * Cập nhật password
     *
     * @param password truyền vào giá trị password
     * @return null trả về giá trị
     */
    private static String MD5Encryption(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            return DatatypeConverter.printHexBinary(md.digest()).toLowerCase();// trả về gí trị sau khi được cover
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;// trả về null
    }

    /**
     * Thêm account
     *
     * @param la truyền vào danh sách
     */
    private static void addAccount(ArrayList<Account> la) {
        System.out.print("Enter Username: ");
        String username = checkInputUsername(la);
        System.out.print("Enter Password: ");
        String password = checkInputPassword();
        System.out.print("Enter Name: ");
        String name = checkInputName();
        System.out.print("Enter Phone: ");
        String phone = checkInputPhone();
        System.out.print("Enter email: ");
        String email = checkInputEmail();
        System.out.print("Enter address: ");
        String address = checkAdress();
        System.out.print("Enter Date Of Birth: ");
        String err = "Wrong!!Enter again!!!";
        String dateOfBirth = checkInputDate(err);
        la.add(new Account(username, MD5Encryption(password), name, phone, email,
                address, dateOfBirth));
        System.out.println("Add success!!!");
    }

    /**
     * đăng nhập
     *
     * @param la truyền vào danh sách
     */
    private static void login(ArrayList<Account> la) {
        if (la.isEmpty()) { // nếu danh sách rỗng thì hiển thị thông báo
            System.err.println("Accout empty.");
            return; // trả về
        }
        System.out.print("Enter username: ");
        String username = checkInputUsername(la);
        System.out.print("Enter Password: ");
        String password = checkInputPassword();
        Account accoutLogin = findAccount(la, username, password);
        if (accoutLogin != null) { // nếu khác null thì cho người dùng lựa chọn Y/N
            System.out.println("Wellcome");
            System.out.print("Hi " + accoutLogin.getUsername()
                    + ", do you want chage password now? Y/N: ");
            changePassword(accoutLogin);
        } else { // hiển thị thông báo lỗi 
            System.err.println("Invalid username or password.");
        }
    }

    /**
     * Tìm kiếm accout
     *
     * @param la truyền vào danh sách
     * @param username truyền vào username
     * @param password truyền vào password
     * @return null trả về null
     */
    private static Account findAccount(ArrayList<Account> la, String username,
            String password) {
        for (int i = 0; i < la.size(); i++) { // duyệt qua danh sách
            if (username.equalsIgnoreCase(la.get(i).getUsername())) { // nếu username khớp với danh sách
                if (MD5Encryption(password).equalsIgnoreCase(la.get(i).getPassword())) { //password trùng với danh sách
                    return la.get(i); // trả về giá trị của danh sách tại vị trị thứ i
                } else { // Trả về null
                    return null; // trả về null
                }
            }
        }
        return null; // trả về null
    }

    /**
     * Thay đổi password
     *
     * @param accoutLogin truyền vào giá trị login
     */
    private static void changePassword(Account accoutLogin) {
        String choice;
        while (true) { // lặp tới khi nhập đúng
            choice = in.nextLine().trim();
            if (choice.length() == 0) { // nếu bằng 0 thì hiển thị thông báo bắt nhập lại
                System.err.println("Not empty!!!");
            } else if (choice.length() == 1 && choice.equalsIgnoreCase("Y")
                    || choice.equalsIgnoreCase("N")) { // nếu chọn Y || N thì break
                break;
            } else { // Thông báo bắt nhập lại
                System.err.println("Re-input");
            }
        }
        if (choice.equalsIgnoreCase("Y")) { // nếu chọn bằng y thì cho nhập lại password
            System.out.print("Old password: ");
            String oldPassword = checkInputPassword();
            System.out.print("New password: ");
            String newPassword = checkInputPassword();
            System.out.print("Renew password: ");
            String renewPassword = checkInputPassword();
            // nếu pass cũ nhập vào không trùng với pass cũ hiển thị thông báo
            if (MD5Encryption(oldPassword).equalsIgnoreCase(accoutLogin.getPassword()) == false) {
                System.err.println("Old password incorrect.");
            }
 
            if (newPassword.equalsIgnoreCase(renewPassword) == false) { // nếu mà trùng thì thông báo phải nhập lại không được trùng pass cũ
                System.err.println("New password and Renew password not the same.");
            }
            
            if (MD5Encryption(oldPassword).equalsIgnoreCase(accoutLogin.getPassword()) == true
                    && newPassword.equalsIgnoreCase(renewPassword) == true) { // pass cũ và pass mới khác nhau và đúng định dạng thì thông báo cập nhật thành công 
                accoutLogin.setPassword(MD5Encryption(newPassword));
                System.out.println("Change password success");
            }
        }
    }

    /**
     * Show menu cho người dùng lựa chọn
     */
    private static void display() {
        ArrayList<Account> la = new ArrayList<>();
        while (true) { // lặp cho tới khi nhập đúng
            System.out.println("1. Add user");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = checkIntLimit(1, 3);
            switch (choice) { // theo biến choice
                case 1:
                    addAccount(la);
                    break;
                case 2:
                    login(la);
                    break;
                case 3:
                    return; // thoát
            }
        }
    }

    public static void main(String[] args) throws IOException {
        display();
    }
}
