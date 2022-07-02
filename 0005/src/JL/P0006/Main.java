package JL.P0006;

/**
 *
 * @author Duy Thanh
 */
public class Main extends Validate{
    public static void main(String[] args) {
        Main m = new Main();
        int n = 0;
        n = m.checkInt(n); // nhập n bằng cách gọi lại hàm checkInt;
        System.out.printf("Fibonacci " + n + " are: " );
        Validate v = new Validate();
        v.fibonaci(n);
       
    }
}
