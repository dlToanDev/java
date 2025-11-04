import java.util.Scanner;

class HinhChuNhat {
    private double chieuDai;
    private double chieuRong;

    public HinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    public double tinhChuVi() {
        return 2 * (chieuDai + chieuRong);
    }

    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }
}

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chieu dai: ");
        double dai = sc.nextDouble();
        System.out.print("Nhap chieu rong: ");
        double rong = sc.nextDouble();

        HinhChuNhat hcn = new HinhChuNhat(dai, rong);
        System.out.println("Chu vi: " + hcn.tinhChuVi());
        System.out.println("Dien tich: " + hcn.tinhDienTich());
    }
}
