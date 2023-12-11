public class PersegiPanjang extends Matematika {
   private double panjang;
   private double lebar;

   public PersegiPanjang(double panjang, double lebar) {
      this.panjang = panjang;
      this.lebar = lebar;
   }

   @Override
   public double luas() {
      // rumus (panjang x lebar) = hasil
      System.out.println("Contoh Soal Persegi Panjang : Berapakah luas dari panjang " + panjang + " dan lebar " + lebar + "?");
      return panjang * lebar;
   }
}
