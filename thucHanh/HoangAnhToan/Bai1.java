public  class Bai1 {
    public static void tinhTong10SoChanDauTien() {
        int tong=0;
        for(int i=0, dem =0; dem<10; i++) {
            if(i%2==0) {
                tong += i;
                dem++;
            }
        }
        System.out.println("Tong 10 so chan dau tien: " + tong);
    }
}