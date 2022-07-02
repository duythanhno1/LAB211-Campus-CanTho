/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JS.P0002_Short;

/**
 *
 * @author Duy Thanh
 */
public class Main extends Validate {

    public static void main(String[] args) {
        Main m = new Main();
        int n = 0;
        n = m.inPutSize(n);
        int a[] = new int[n];
        a = m.enterArray(n);
        System.out.print("Unsorted array: ");
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print("]\n");
        m.SelectionSort(a);

    }

}
