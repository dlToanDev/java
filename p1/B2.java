import java.util.Scanner;

public class B2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so nguyen duong n: ");
        int n = sc.nextInt();
        int sum = 0;
        for(int i=0; i<=n; i++){
            sum += i;
        }
        System.out.println("Tong S = 1 + 2 + ... + " + n + " la: " + sum);
        sc.close();
    }
}