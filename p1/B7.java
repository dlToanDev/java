
import java.util.List;
import java.util.Scanner;



class KHACHHANG {
    private String ten;
    private boolean caoVoi;
    private boolean tayTrang;
    private int soRangNho;
    private int soRangTram;


    public static final int GIA_CAO_VOI = 10;
    public static final int GIA_TAY_TRANG = 80;
    public static final int GIA_NHO_RANG = 2000;
    public static final int GIA_TRAM_RANG = 1500;

    public KHACHHANG(String ten, boolean caoVoi, boolean tayTrang, int soRangNho, int soRangTram) {
        this.ten = ten;
        this.caoVoi = caoVoi;
        this.tayTrang = tayTrang;
        this.soRangNho = soRangNho;
        this.soRangTram = soRangTram;
    }

    public double tinhTien() {
        double tongTien = 0;
        if (caoVoi) {
            tongTien += GIA_CAO_VOI;
        }
        if (tayTrang) {
            tongTien += GIA_TAY_TRANG;
        }
        tongTien += soRangNho * GIA_NHO_RANG;
        tongTien += soRangTram * GIA_TRAM_RANG;
        return tongTien;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-10.0f", ten, tinhTien());
    }

}

public class B7 {
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        

        System.out.print("Nhap so luong khach hang: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<KHACHHANG> ds = new java.util.ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhap thong tin khach hang thu %d:\n", i + 1);
            System.out.print("Ten: ");
            String ten = sc.nextLine();
            System.out.print("Cao voi (true/false): ");
            boolean caoVoi = sc.nextBoolean();
            System.out.print("Tay trang (true/false): ");
            boolean tayTrang = sc.nextBoolean();
            System.out.print("So rang nho: ");
            int soRangNho = sc.nextInt();
            System.out.print("So rang tram: ");
            int soRangTram = sc.nextInt();
            sc.nextLine(); // Consume newline

            KHACHHANG kh = new KHACHHANG(ten, caoVoi, tayTrang, soRangNho, soRangTram);
            ds.add(kh);
        }


        System.out.println("\n Danh sach khach hang : ");
        System.out.printf("%-20s %-10s\n", "Ten", "Tien");
        for (KHACHHANG kh : ds) {
            System.out.println(kh);
        }

        sc.close();
    }
}