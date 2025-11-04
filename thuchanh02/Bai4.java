import java.util.*;

class DatPhong {
    private String tenKH;
    private String diaChi;
    private int soNgayO;
    private String loaiPhong;
    private boolean tienNghi;
    private boolean karaoke;
    private boolean anSang;

    public DatPhong(String tenKH, String diaChi, int soNgayO,
                    String loaiPhong, boolean tienNghi, boolean karaoke, boolean anSang) {
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.soNgayO = soNgayO;
        this.loaiPhong = loaiPhong;
        this.tienNghi = tienNghi;
        this.karaoke = karaoke;
        this.anSang = anSang;
    }

    public double tinhTien() {
        double giaPhong = switch (loaiPhong.toLowerCase()) {
            case "don" -> 300000;
            case "doi" -> 350000;
            case "ba" -> 400000;
            default -> 0;
        };
        double tong = giaPhong * soNgayO;
        if (tienNghi) tong += 10000;
        if (karaoke) tong += 50000;
        if (anSang) tong += 15000 * soNgayO;
        return tong;
    }

    public void hienThi() {
        System.out.printf("%-15s %-10s %d ngay - %s - Tien: %.0f%n",
                tenKH, diaChi, soNgayO, loaiPhong, tinhTien());
    }
}

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<DatPhong> ds = new ArrayList<>();

        System.out.print("Nhap so luong dat phong: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nKhach hang " + (i+1) + ":");
            System.out.print("Ten KH: "); String ten = sc.nextLine();
            System.out.print("Dia chi: "); String dc = sc.nextLine();
            System.out.print("So ngay o: "); int soNgay = sc.nextInt(); sc.nextLine();
            System.out.print("Loai phong (don/doi/ba): "); String loai = sc.nextLine();
            System.out.print("Co tien nghi (true/false): "); boolean tn = sc.nextBoolean();
            System.out.print("Co karaoke (true/false): "); boolean kara = sc.nextBoolean();
            System.out.print("Co an sang (true/false): "); boolean as = sc.nextBoolean();
            sc.nextLine();

            ds.add(new DatPhong(ten, dc, soNgay, loai, tn, kara, as));
        }

        double tongTien = 0;
        System.out.println("\n=== DANH SACH DAT PHONG ===");
        for (DatPhong dp : ds) {
            dp.hienThi();
            tongTien += dp.tinhTien();
        }

        System.out.println("\nTong so tien thu trong ngay: " + tongTien);
    }
}
