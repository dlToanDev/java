import java.util.Scanner;

public class Bai4 {
    public static void tinhTong1DenN() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n = ");
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        System.out.println("TTong S = " + sum);
    }
}
