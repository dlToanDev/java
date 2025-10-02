
import java.util.Scanner;

class NhanVien {

    String maNV;
    private int soSP;

    public NhanVien() {
        this.maNV = " ";
        this.soSP = 0;
    }

    public NhanVien(String ma, int sp) {
        this.maNV = ma;
        if (sp > 0) {
            this.soSP = sp;
        } else {
            this.soSP = 0;
        }
    }

    public String getMaNV() {
        return maNV;
    }
    public void setMaNV(String ma) {
        this.maNV = ma;
    }

    public int getSoSP() {
        return soSP;
    }

    public void setSoSP(int sp) {
        if (sp > 0) {
            this.soSP = sp;
        } else {
            this.soSP = 0;
        }
    }


    public boolean covuotChuan() {
        return soSP > 500;
    }


    public String getTongKet() {
        return covuotChuan() ? "Vuot" : "ko Vuot";
    }

    public double getLuong() {
        int spChuan = Math.min(soSP, 500);
        int spVuot = Math.max(0, soSP - 500);
        return spChuan * 20000 + spVuot * 30000;
    }

    public static void XuatTieuDe() {
        System.out.printf("%-15s %-15s %-15s %-10s\n", 
                          "Mã NV", "Số sản phẩm", "Lương", "Tổng kết");
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15d %-15.0f %-10s",
                             maNV, soSP, getLuong(), getTongKet());
    }

}

public class B6 {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.print("Nhap so luong nhan vien: ");
        int n = sc.nextInt();
        sc.nextLine();
        NhanVien[] dsNV = new NhanVien[n];
        for (int i=0; i<n; i++) {
            System.out.printf("Nhap ma nhan vien thu %d: ", i+1);
            String ma = sc.nextLine();
            System.out.printf("Nhap so san pham cua nhan vien thu %d: ", i+1);
            int sp = sc.nextInt();
            sc.nextLine();
            dsNV[i] = new NhanVien(ma, sp);
        }
        System.out.println("\nDanh sách nhân viên:");
        NhanVien.XuatTieuDe();

        // Xuất thông tin từng nhân viên
        for (NhanVien nv : dsNV) {
            System.out.println(nv);
        }

        sc.close();

    }

}
