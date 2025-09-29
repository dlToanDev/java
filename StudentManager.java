import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private double gpa;

    public Student(int id, String name, int age, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public void display() {
        System.out.printf("%-5d %-20s %-5d %-5.2f\n", id, name, age, gpa);
    }
}

public class StudentManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng sinh viên: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Sinh viên " + (i + 1) + " ---");

            System.out.print("Mã SV: ");
            int id = sc.nextInt();
            sc.nextLine(); // clear buffer

            System.out.print("Họ tên: ");
            String name = sc.nextLine();

            System.out.print("Tuổi: ");
            int age = sc.nextInt();

            System.out.print("Điểm GPA: ");
            double gpa = sc.nextDouble();

            students[i] = new Student(id, name, age, gpa);
        }

        System.out.println("\n=== DANH SÁCH SINH VIÊN ===");
        System.out.printf("%-5s %-20s %-5s %-5s\n", "ID", "Họ tên", "Tuổi", "GPA");
        for (Student st : students) {
            st.display();
        }

        sc.close();
    }
}
