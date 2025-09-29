
public class B1 {
    public static void main(String[] args) {
        int sum = 0;

        // Cách 1: dùng for
        for (int i = 1; i <= 10; i++) {
            sum += 2 * i;
        }
        System.out.println("Tong 10 so chan dau tien la : " + sum);

        // Cách 2: dùng while
        sum = 0;
        int count = 0;
        int num = 2; // số chẵn bắt đầu
        while (count < 10) {
            sum += num;
            num += 2;
            count++;
        }
        System.out.println("Tong 10 so chan dau tien la : " + sum);
    }
}

