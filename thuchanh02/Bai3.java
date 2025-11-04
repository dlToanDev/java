import java.util.Scanner;

// ====== Lớp Address ======
class Address {
    private String streetAddress;
    private String city;
    private String state;
    private long zipCode;

    public Address(String streetAddress, String city, String state, long zipCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return streetAddress + ", " + city + ", " + state + " " + zipCode;
    }
}

// ====== Lớp Student ======
class Student {
    private String firstName;
    private String lastName;
    private Address homeAddress;
    private Address schoolAddress;

    public Student(String firstName, String lastName, Address homeAddress, Address schoolAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
        this.schoolAddress = schoolAddress;
    }

    @Override
    public String toString() {
        return "Ho ten: " + firstName + " " + lastName + "\n" +
               "Dia chi nha: " + homeAddress + "\n" +
               "Dia chi truong: " + schoolAddress + "\n";
    }
}

// ====== Lớp StudentBody (chứa main) ======
public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong sinh vien: ");
        int n = sc.nextInt();
        sc.nextLine(); // bỏ dòng trống

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Sinh vien thu " + (i + 1) + " ---");

            System.out.print("First name: ");
            String firstName = sc.nextLine();

            System.out.print("Last name: ");
            String lastName = sc.nextLine();

            System.out.println("Nhap dia chi nha:");
            System.out.print("  Duong: ");
            String homeStreet = sc.nextLine();
            System.out.print("  Thanh pho: ");
            String homeCity = sc.nextLine();
            System.out.print("  Tinh/State: ");
            String homeState = sc.nextLine();
            System.out.print("  Ma ZIP: ");
            long homeZip = sc.nextLong();
            sc.nextLine();

            System.out.println("Nhap dia chi truong:");
            System.out.print("  Duong: ");
            String schoolStreet = sc.nextLine();
            System.out.print("  Thanh pho: ");
            String schoolCity = sc.nextLine();
            System.out.print("  Tinh/State: ");
            String schoolState = sc.nextLine();
            System.out.print("  Ma ZIP: ");
            long schoolZip = sc.nextLong();
            sc.nextLine();

            Address home = new Address(homeStreet, homeCity, homeState, homeZip);
            Address school = new Address(schoolStreet, schoolCity, schoolState, schoolZip);

            students[i] = new Student(firstName, lastName, home, school);
        }

        System.out.println("\n=== DANH SACH SINH VIEN ===");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
