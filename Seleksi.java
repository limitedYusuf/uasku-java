// Yusuf - UAS Java (Soal 2)
public class Seleksi {
   public static void main(String[] args) {
      // set nilai tono sesuai soal, yaitu 80. disini saya set integer (bilangan bulat)
      int nilaiTono = 80;

      // proses kondisi, karena value variabel diatas 80. Maka tono akan stop di pengecekan kondisi ini (nilaiTono >= 71 && nilaiTono <= 80) dan akan menghasilkan output : "Tono diterima di PT B"

      System.out.println("Nilai Tono : " + nilaiTono);
      
      if (nilaiTono > 81 && nilaiTono <= 100) {
         // jika nilai diatas 81
         System.out.println("Tono diterima di PT A");
      } else if (nilaiTono >= 71 && nilaiTono <= 80) {
         // jika nilai mulai dari 71 dan pas 80
         System.out.println("Tono diterima di PT B");
      } else if (nilaiTono >= 61 && nilaiTono <= 70) {
         // jika nilai mulai dari 61 dan pas 70
         System.out.println("Tono diterima di PT C");
      } else if (nilaiTono >= 0 && nilaiTono <= 60) {
         // jika nilai dibawah 60
         System.out.println("Tono diterima di PT D");
      } else {
         // jika value nilai tidak logis, misal -5 atau 999999
         System.out.println("Nilai tidak wajar & Tono tidak diterima dimanapun");
      }
   }
}
