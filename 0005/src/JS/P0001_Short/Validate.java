package JS.P0001_Short;

import java.util.Scanner;

/**
 *
 * @author Duy Thanh
 */
public class Validate {

    Scanner sc = new Scanner(System.in);

    /**
     * nhap size cho array
     *
     * @param n nhan gia tri nhap tu ban phim
     * @return n : tra ve gia tri duoc nhap tu ban phim
     */
    public int inPutSize(int n) {
        boolean Valid = false;
        do { // bat loi du lieu nhap vao
            Valid = false;
            try {
                System.out.println("Please enter n: ");
                n = Integer.parseInt(sc.nextLine());
                if (n < 0) { // neu nho hon 0 thi nhap lai
                    System.out.println("You cannot enter less than 0!!!Enter again!!!");
                    Valid = true;
                }
            } catch (NumberFormatException e) { // bat ngoai le neu khong nhap dung so nguyen
                System.out.println("You can only enter integers!!Enter again!!");
                Valid = true;
            }
        } while (Valid); // lap lai khi nhap sai

        return n; // tra ve gia tri n sau khi nhap dung
    }

    /**
     * Nhap phan tu cho mang
     *
     * @param n gia tri n duoc nhap tu ban phim truyen vao lam kich thuoc mang
     * @return a tra ve cac phan tu cua mang sau khi duoc nhap vao
     */
    public int[] enterArray(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter " + i + ":");
            while (true) { // neu dung se bo qua con khong se lap
                try { // bat ngoai le neu nhap khong dung dinh dang so nguyen
                    a[i] = Integer.parseInt(sc.nextLine().trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("You can only enter integers!!Enter again!!");
                }
            }
        }
        return a; // tra ve phan tu cua mang sau khi duoc nhap vao dung
    }

    /**
     * bubleShort
     *
     * @param a tra ve gia tri cua mang sau khi da duoc sap xep
     */
    public void bubleShort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) { // duyet qua mang
            for (int j = 0; j < a.length - i - 1; j++) { // duyet qua mang
                if (a[j] > a[j + 1]) { // neu a[j] > a[j+1] thuc hien doi cho cac phan tu
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        // 9 7 5 3 1
        System.out.printf("Sorted array:");
        System.out.print("[");
        for (int i = 0; i < a.length; i++) { // duyet qua
            System.out.print(a[i] + ", ");

        }
        System.out.print("]\n");
    }

}
