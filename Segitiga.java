public class Segitiga extends Matematika {
   private double alas;
   private double tinggi;

   public Segitiga(double alas, double tinggi) {
      this.alas = alas;
      this.tinggi = tinggi;
   }

   @Override
   public double luas() {
      // rumus (L = 1/2 x a x t), namun karena 1/2 tidak bisa dibaca, maka diganti ke 0.5
      System.out.println("Contoh Soal Segitiga : Berapakah luas dari alas " + alas + " dan tinggi " + tinggi + "?");
      return 0.5 * alas * tinggi;
   }
}
