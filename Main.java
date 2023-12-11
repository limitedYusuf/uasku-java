// Yusuf - UAS Java (Soal 3)
public class Main {
   public static void main(String[] args) {
      Matematika obj1 = new Segitiga(7, 10);
      Matematika obj2 = new PersegiPanjang(8, 12);

      // nah disini proses polymorpism nya, dan disini saat nya memakai luas() namun bukan dari class "Matematika". tapi dari Class lain yang memiliki luas() juga
      double outputLuas1 = obj1.luas();
      double outputLuas2 = obj2.luas();

      System.out.println("Output Luas Segitiga: " + outputLuas1);
      System.out.println("Output Luas Persegi Panjang: " + outputLuas2);
   }
}
