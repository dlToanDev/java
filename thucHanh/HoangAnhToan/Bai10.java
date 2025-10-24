import java.util.Scanner;

public class Bai10 {

    public static void xuLyMaTran() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số dòng m = ");
        int m = sc.nextInt();

        System.out.print("Nhập số cột n = ");
        int n = sc.nextInt();

        int[][] a = new int[m][n];

        // a) Nhập ma trận
        System.out.println("Nhập các phần tử của ma trận:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("a[" + i + "][" + j + "] = ");
                a[i][j] = sc.nextInt();
            }
        }

        // b) In ma trận
        System.out.println("\nMa trận vừa nhập:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }

        // c) Tìm phần tử nhỏ nhất
        int min = a[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] < min) min = a[i][j];
            }
        }
        System.out.println("\nPhần tử nhỏ nhất trong ma trận: " + min);

        // d) Tìm phần tử lẻ lớn nhất
        int maxLe = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] % 2 != 0 && a[i][j] > maxLe) {
                    maxLe = a[i][j];
                }
            }
        }
        if (maxLe == Integer.MIN_VALUE)
            System.out.println("Không có phần tử lẻ trong ma trận.");
        else
            System.out.println("Phần tử lẻ lớn nhất: " + maxLe);

        // e) Tìm dòng có tổng lớn nhất
        int dongMax = 0;
        int tongMax = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            int tongDong = 0;
            for (int j = 0; j < n; j++) {
                tongDong += a[i][j];
            }
            if (tongDong > tongMax) {
                tongMax = tongDong;
                dongMax = i;
            }
        }

        System.out.println("Dòng có tổng lớn nhất là dòng " + dongMax + " (Tổng = " + tongMax + ")");
    }
}
