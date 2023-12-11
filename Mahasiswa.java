import java.sql.*;
import java.util.Scanner;

// Yusuf - UAS Java (Soal 4)
public class Mahasiswa {

   // set variabel untuk menghubungkan mysql ke java, contoh di env saya root, root
   private static final String DB_URL = "jdbc:mysql://localhost:3306/uas_java";
   private static final String DB_USER = "root";
   private static final String DB_PASSWORD = "root";

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
         createTableIfNotExists(connection);

         int choice;
         do {
            printMenu();
            System.out.print("Pilih menu (0-4) : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            // untuk clean code, saya memakai switch supaya mudah untuk manajemen nya
            switch (choice) {
               case 1:
                  inputData(connection, scanner);
                  break;
               case 2:
                  tampilData(connection);
                  break;
               case 3:
                  updateData(connection, scanner);
                  break;
               case 4:
                  hapusData(connection, scanner);
                  break;
               case 0:
                  System.out.println("Semoga sehat selalu.");
                  break;
               default:
                  System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
         } while (choice != 0);

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   private static void printMenu() {
      System.out.println("===MENU UTAMA (CREATED BY YUSUF)===");
      System.out.println("1. Input Data");
      System.out.println("2. Tampil Data");
      System.out.println("3. Update Data");
      System.out.println("4. Hapus Data");
      System.out.println("0. Keluar");
   }

   // jika belum ada tabel, maka buatkan otomatis saat sistem di jalankan
   private static void createTableIfNotExists(Connection connection) throws SQLException {
      try (Statement statement = connection.createStatement()) {
         String createTableQuery = "CREATE TABLE IF NOT EXISTS mahasiswa (" +
               "id INT AUTO_INCREMENT PRIMARY KEY," +
               "nama VARCHAR(200)," +
               "alamat TEXT)";
         statement.executeUpdate(createTableQuery);
      }
   }

   // proses input (saya menerapkan statement untuk mencegah terjadi nya SQL Injection)
   private static void inputData(Connection connection, Scanner scanner) throws SQLException {
      System.out.print("Masukkan nama: ");
      String nama = scanner.nextLine();

      System.out.print("Masukkan alamat: ");
      String alamat = scanner.nextLine();

      String insertQuery = "INSERT INTO mahasiswa (nama, alamat) VALUES (?, ?)";

      try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
         preparedStatement.setString(1, nama);
         preparedStatement.setString(2, alamat);
         preparedStatement.executeUpdate();
         System.out.println("Data berhasil disimpan.");
      }
   }

   // menampilkan data list dari tabel (urut berdasarkan data terbaru)
   private static void tampilData(Connection connection) throws SQLException {
      String selectQuery = "SELECT * FROM mahasiswa ORDER BY id DESC";

      try (Statement statement = connection.createStatement()) {
         ResultSet resultSet = statement.executeQuery(selectQuery);

         System.out.println("+-----+--------------------------------+------------------------------------------+");
         System.out.printf("| %-3s | %-30s | %-40s |\n", "ID", "Nama", "Alamat");
         System.out.println("+-----+--------------------------------+------------------------------------------+");

         while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nama = resultSet.getString("nama");
            String alamat = resultSet.getString("alamat");
            System.out.printf("| %-3d | %-30s | %-40s |\n", id, nama, alamat);
         }

         System.out.println("+-----+--------------------------------+------------------------------------------+");
      }
   }

   // proses edit. disini saya tampilkan juga posisi data sekarang supaya mempermudah user. (saya menerapkan statement untuk mencegah terjadi nya SQL Injection)
   private static void updateData(Connection connection, Scanner scanner) throws SQLException {
      System.out.print("Masukkan ID data yang akan di-update: ");
      int idToUpdate = scanner.nextInt();
      scanner.nextLine();

      String selectQuery = "SELECT * FROM mahasiswa WHERE id = ?";
      try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
         selectStatement.setInt(1, idToUpdate);
         ResultSet resultSet = selectStatement.executeQuery();

         if (resultSet.next()) {
            System.out.println("Data sekarang yang terpilih :");
            System.out.println("+-----+--------------------------------+------------------------------------------+");
            System.out.printf("| %-4s | %-30s | %-40s |\n", "ID", "Nama", "Alamat");
            System.out.println("+-----+--------------------------------+------------------------------------------+");
            int id = resultSet.getInt("id");
            String nama = resultSet.getString("nama");
            String alamat = resultSet.getString("alamat");
            System.out.printf("| %-4d | %-30s | %-40s |\n", id, nama, alamat);
            System.out.println("+-----+--------------------------------+------------------------------------------+");

            System.out.print("Masukkan nama baru: ");
            String namaBaru = scanner.nextLine();

            System.out.print("Masukkan alamat baru: ");
            String alamatBaru = scanner.nextLine();

            String updateQuery = "UPDATE mahasiswa SET nama = ?, alamat = ? WHERE id = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
               updateStatement.setString(1, namaBaru);
               updateStatement.setString(2, alamatBaru);
               updateStatement.setInt(3, idToUpdate);
               updateStatement.executeUpdate();
               System.out.println("Data berhasil di-update.");
            }
         } else {
            System.out.println("Data dengan ID " + idToUpdate + " tidak ditemukan.");
         }
      }
   }

   // proses hapus (saya menerapkan statement untuk mencegah terjadi nya SQL Injection)
   private static void hapusData(Connection connection, Scanner scanner) throws SQLException {
      System.out.print("Masukkan ID data yang akan dihapus: ");
      int idToDelete = scanner.nextInt();
      scanner.nextLine();

      String selectQuery = "SELECT * FROM mahasiswa WHERE id = ?";
      try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
         selectStatement.setInt(1, idToDelete);
         ResultSet resultSet = selectStatement.executeQuery();

         if (resultSet.next()) {
            System.out.println("+-----+--------------------------------+------------------------------------------+");
            System.out.printf("| %-4s | %-30s | %-40s |\n", "ID", "Nama", "Alamat");
            System.out.println("+-----+--------------------------------+------------------------------------------+");
            int id = resultSet.getInt("id");
            String nama = resultSet.getString("nama");
            String alamat = resultSet.getString("alamat");
            System.out.printf("| %-4d | %-30s | %-40s |\n", id, nama, alamat);
            System.out.println("+-----+--------------------------------+------------------------------------------+");

            System.out.print("Yakin ingin menghapus data? (Y/N): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("Y")) {
               String deleteQuery = "DELETE FROM mahasiswa WHERE id = ?";
               try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                  deleteStatement.setInt(1, idToDelete);
                  deleteStatement.executeUpdate();
                  System.out.println("Data berhasil dihapus.");
               }
            } else {
               System.out.println("Penghapusan data dibatalkan.");
            }
         } else {
            System.out.println("Data dengan ID " + idToDelete + " tidak ditemukan.");
         }
      }
   }
}
