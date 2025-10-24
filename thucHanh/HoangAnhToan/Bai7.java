import java.util.Scanner;

public class Bai7 {
    public static void tinhGiaiThuaKep() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n = ");
        int n = sc.nextInt();
        long gt = 1;
        for (int i = (n % 2 == 0 ? 2 : 1); i <= n; i += 2) {
            gt *= i;
        }
        System.out.println(n + "!! = " + gt);
    }
}
