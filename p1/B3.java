import java.util.Scanner;

public class B3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap so n: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("n phai la so nguyen duong (>= 0).");
            sc.close();
            return;
        }

        long factorial = 1;
        for (int i = 1; i <= n; i++) {   // CHÚ Ý: i bắt đầu từ 1
            factorial *= i;
        }

        System.out.println(n + "! = " + factorial);
        sc.close();
    }
}
