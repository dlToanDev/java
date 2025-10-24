import java.util.Scanner;

public class Bai2 {
    public static void giaiPTBac1() {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Nhap a= ");
        double a =   sc.nextDouble();
        System.out.println ("Nhap b= ");
        double b = sc.nextDouble();
        if(a == 0) {
            if(b == 0) {
                System.out.println("Phuong trinh vo so nghiem");
            }
            else {
                System.out.println("Phuong trinh vo nghiem");
            }
        }
        else {
            double x = -b/a;
            System.out.println("Nghiem phuong trinh la x= " + x);
        }
    }
}