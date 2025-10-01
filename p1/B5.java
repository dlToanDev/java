import java.util.Scanner;

public class B5 {
    // Hàm kiểm tra số nguyên tố
    public static boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập mảng
        System.out.print("Nhap so phan tu n: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("Nhap cac phan tu:");
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }

        // a) Xuất mảng
        System.out.print("\nCac phan tu trong mang: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        // b) Tìm max, min
        int maxVal = a[0], minVal = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > maxVal) maxVal = a[i];
            if (a[i] < minVal) minVal = a[i];
        }
        System.out.println("Gia tri lon nhat: " + maxVal);
        System.out.println("Gia tri nho nhat: " + minVal);

        // c) Đếm số chẵn
        int countEven = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) countEven++;
        }
        System.out.println("So phan tu chan: " + countEven);

        // d) Các số nguyên tố
        System.out.print("Cac so nguyen to trong mang: ");
        for (int i = 0; i < n; i++) {
            if (isPrime(a[i])) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();

        // e) Sắp xếp tăng dần (Bubble Sort)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.print("Mang sau khi sap xep tang dan: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        // f) Tìm phần tử có giá trị x
        System.out.print("Nhap gia tri x can tim: ");
        int x = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                System.out.println("Tim thay x = " + x + " tai vi tri a[" + i + "]");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay x trong mang");
        }

        sc.close();
    }
}
