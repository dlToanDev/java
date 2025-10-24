import java.util.Scanner;

public class Bai5 {
    public static void tinhTongPhanSo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n = ");
        int n = sc.nextInt();
        double sum = 0;
        for (int i = 1; i <= n; i++) sum += 1 / i;
        System.out.println("TTong S = " + sum);
    }
}
