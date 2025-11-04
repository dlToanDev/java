import java.util.*;

class MonHoc {
    protected String maMon;
    protected String tenMon;
    protected int soTinChi;

    public MonHoc(String maMon, String tenMon, int soTinChi) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.soTinChi = soTinChi;
    }
}

class TinChi extends MonHoc {
    private double diemTP;
    private double diemThi;

    public TinChi(String maMon, String tenMon, int soTinChi, double diemTP, double diemThi) {
        super(maMon, tenMon, soTinChi);
        this.diemTP = diemTP;
        this.diemThi = diemThi;
    }

    public double getDiemTongKet() {
        return 0.3 * diemTP + 0.7 * diemThi;
    }

    public int getSoTinChi() {
        return soTinChi;
    }
}

class SinhVien {
    private String maSV;
    private String hoTen;
    private ArrayList<TinChi> danhSachTinChi = new ArrayList<>();

    public SinhVien(String maSV, String hoTen) {
        this.maSV = maSV;
        this.hoTen = hoTen;
    }

    public void themTinChi(TinChi tc) {
        danhSachTinChi.add(tc);
    }

    public double tinhDTB() {
        double tongDiem = 0;
        int tongTC = 0;
        for (TinChi tc : danhSachTinChi) {
            tongDiem += tc.getDiemTongKet() * tc.getSoTinChi();
            tongTC += tc.getSoTinChi();
        }
        return tongTC == 0 ? 0 : tongDiem / tongTC;
    }

    public String xepLoai() {
        double dtb = tinhDTB();
        if (dtb < 6) return "TB";
        else if (dtb < 8) return "Kha";
        else return "Gioi";
    }

    public void hienThi() {
        System.out.printf("%-10s %-20s DTB: %.2f - Xep loai: %s%n",
                maSV, hoTen, tinhDTB(), xepLoai());
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> ds = new ArrayList<>();

        System.out.print("Nhap so sinh vien: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\n==> Sinh vien thu " + (i+1));
            System.out.print("Ma SV: "); String ma = sc.nextLine();
            System.out.print("Ho ten: "); String ten = sc.nextLine();
            SinhVien sv = new SinhVien(ma, ten);

            System.out.print("Nhap so mon hoc: ");
            int m = sc.nextInt(); sc.nextLine();
            for (int j = 0; j < m; j++) {
                System.out.println("Mon hoc " + (j+1) + ": ");
                System.out.print("Ma mon: "); String maMon = sc.nextLine();
                System.out.print("Ten mon: "); String tenMon = sc.nextLine();
                System.out.print("So tin chi: "); int tc = sc.nextInt();
                System.out.print("Diem TP: "); double tp = sc.nextDouble();
                System.out.print("Diem Thi: "); double thi = sc.nextDouble();
                sc.nextLine();

                sv.themTinChi(new TinChi(maMon, tenMon, tc, tp, thi));
            }

            ds.add(sv);
        }

        System.out.println("\n=== DANH SACH SINH VIEN ===");
        ds.forEach(SinhVien::hienThi);

        ds.sort((a, b) -> Double.compare(b.tinhDTB(), a.tinhDTB()));
        System.out.println("\n=== SAP XEP GIAM DAN THEO DTB ===");
        ds.forEach(SinhVien::hienThi);


        System.out.println("\n=== SINH VIEN GIOI ===");
        ds.stream().filter(sv -> sv.tinhDTB() >= 8).forEach(SinhVien::hienThi);
    }
}
