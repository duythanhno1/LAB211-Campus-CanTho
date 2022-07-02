package JL.P0006;

import java.util.Scanner;

/**
 *
 * @author Duy Thanh
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    /**
     * kiểm tra dữ liệu vào của n
     *
     * @param n : nhận giá trị nhập từ bàn phím
     * @return n: trả về giá trị của n sau khi hợp lệ
     */
    public int checkInt(int n) {
        boolean Valid = false;
        do { // bắt lỗi nhập dữ liệu
            Valid = false;
            try {
                System.out.println("Enter n: ");
                n = Integer.parseInt(sc.nextLine().trim());
                if (n <= 0) { // nếu n nhỏ hơn 0 bắt nhập lại
                    System.out.println("You must enter a positive integer");
                    Valid = true;
                }
            } catch (NumberFormatException e) { // nhập bất cứ thứ gì ngoài số nguyên cho nhập lại
                System.out.println("Error!!!Enter again!!!");
                Valid = true;
            }
        } while (Valid); // lặp khi nhập sai
        return n; // trả về giá trị n sau khi ktra hợp lệ dữ liệu
    }

    /**
     * Tính dãy fibonacci
     *
     * @param n : nhận giá trị được nhập từ bàn phím
     */
    public void fibonaci(int n) {
        int f0 = 0;
        int f1 = 1;
        int fn = 1;

        if (n == 1) { // nếu n = 1 thi in ra 0 
            System.out.println(f0); // n = 2 in ra 0 voi 1
        } else { // Trường hợp còn lại duyệt qua vòng lặp và tính toán
            System.out.printf(f0 + " " + f1);
            for (int i = 2; i < n; i++) { // duyệt qua vòng lặp
                fn = f0 + f1;
                f0 = f1;
                f1 = fn;

                System.out.print(" " + fn);
            }
        }

    }
}
