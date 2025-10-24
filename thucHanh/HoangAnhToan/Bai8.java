import java.util.Scanner;

public class Bai8 {
    public static void timUCLN_BCNN() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap   a = ");
        int a = sc.nextInt();
        System.out.print("Nhap b = ");
        int b = sc.nextInt();

        int x = a, y = b;
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        int ucln = x;
        int bcnn = (a * b) / ucln;
        System.out.println("UCLN = " + ucln + ", BCNN = " + bcnn);
    }
}
