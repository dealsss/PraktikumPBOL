import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String NIM;  // Ubah NIM menjadi String
    private String nama;

    public Student(String NIM, String nama) {  // Ubah tipe data NIM jadi String
        this.NIM = NIM;
        this.nama = nama;
    }

    public String getId() {  // Ubah return type menjadi String
        return NIM;
    }

    public String getName() {
        return nama;
    }

    public void setName(String nama) {
        this.nama = nama;
    }
    
    @Override
    public String toString() {
        return "NIM: " + NIM + ", Nama: " + nama;
    }
}

public class app {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMAHASISWAAAAA");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan dlu semua mahasiswanya le");
            System.out.println("3. Perbarui Data Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih dlu le (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan Sistem Manajemen Mahasiswa.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Masukkan NIM mahasiswa: ");
        String NIM = scanner.nextLine();  // Ubah ke tipe String
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = scanner.nextLine();

        Student student = new Student(NIM, nama);  // NIM diinput oleh pengguna
        students.add(student);
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Masukkan NIM mahasiswa yang akan diperbarui: ");
        String NIM = scanner.nextLine();  // Sesuaikan NIM sebagai String

        for (Student student : students) {
            if (student.getId().equals(NIM)) {  // Perbandingan String menggunakan equals()
                System.out.print("Masukkan nama baru (biarkan kosong jika tidak ingin mengubah): ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) {
                    student.setName(newName);
                }

                System.out.println("Data mahasiswa berhasil diperbarui.");
                return;
            }
        }
        System.out.println("Mahasiswa dengan NIM " + NIM + "tidak ditemukan.");
    }
    private static void deleteStudent() {
        System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
        String NIM = scanner.nextLine();  // Sesuaikan NIM sebagai String
    
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(NIM)) {  // Perbandingan String menggunakan equals()
                students.remove(i);
                System.out.println("Mahasiswa berhasil dihapus.");
                return;
            }
        }
        System.out.println("Mahasiswa dengan NIM " + NIM + " tidak ditemukan.");
    }
}
