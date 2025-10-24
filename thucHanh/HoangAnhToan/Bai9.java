import java.util.*;

public class Bai9 {
    public static void xuLyMang() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so phan tu n = ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }

        System.out.println("MMang vua nhap:");
        System.out.println(Arrays.toString(a));

        int min = a[0], max = a[0], demChan = 0;
        for (int x : a) {
            if (x < min) min = x;
            if (x > max) max = x;
            if (x % 2 == 0) demChan++;
        }

        System.out.println("Phan tu Nho Nhat " + min);
        System.out.println("Phan tu lon nhat: " + max);
        System.out.println("So phan tu chan: " + demChan);


        System.out.print("CCac so nguyen to: ");
        for (int x : a) if (laNguyenTo(x)) System.out.print(x + " ");
        System.out.println();

        Arrays.sort(a);
        System.out.println("MMang sau sap xep: " + Arrays.toString(a));


        System.out.print("Nhap gia tri can tim x = ");
        int x = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                System.out.println("TTim thay tai vi tri " + i);
                found = true;
            }
        }
        if (!found) System.out.println("Khong tim thay phan tu " + x);
    }

    static boolean laNguyenTo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }
}
