import java.util.Scanner;

public class B4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap n: ");
        int n = sc.nextInt();

        long result = 1;  
        if (n % 2 == 0) {  
            for (int i = 2; i <= n; i += 2) {
                result *= i;
            }
        } else {  
            for (int i = 1; i <= n; i += 2) {
                result *= i;
            }
        }

        System.out.println(n + "!! = " + result);

        sc.close();
    }
}
