import java.util.Scanner;

public class Bai6 {
    public static void tinhGiaiThua() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n = ");
        int n = sc.nextInt();
        long gt = 1;
        for (int i = 2; i <= n; i++) 
            gt *= i;
        System.out.println(n + "! = " + gt);
    }
}
