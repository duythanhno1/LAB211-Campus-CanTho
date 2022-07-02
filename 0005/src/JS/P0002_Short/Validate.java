/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JS.P0002_Short;

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
    
    
    

    public void SelectionSort(int arr[]) {
        int n = arr.length;

        // Duyệt qua từng phần tử của mảng
        for (int i = 0; i < n - 1; i++) {

            // Tìm phần tử nhỏ nhất trong mảng chưa được sắp xếp
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            // Hoán đổi phần tử nhỏ nhất và phần tử đầu tiên
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        System.out.print("Sorted array: ");
        System.out.print("[");
        for (int i = 0; i < n; i++) {

            System.out.print(arr[i] + ", ");

        }
        System.out.print("]\n");
    }

}
