import java.util.Scanner;

public class Bai3 {
    public static void giaiPTBacHai() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a = ");
        double a = sc.nextDouble();
        System.out.print("Nhap b = ");
        double b = sc.nextDouble();
        System.out.print("Nhap c = ");
        double c = sc.nextDouble();

        if (a == 0) {
            Bai2.giaiPTBac1();
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) System.out.println("Vo nghiem");
            else if (delta == 0) System.out.println("Phuong trinh co nghiem kep x = " + (-b / (2 * a)));
            else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Phuong trinh co hai nghiem: x1 = " + x1 + ", x2 = " + x2);
            }
        }
    }
}
