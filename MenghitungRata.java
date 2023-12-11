// Yusuf - UAS Java (Soal 1)
public class MenghitungRata {
    public static void main(String[] args) {
        int nilai1 = 3; // integer (bilangan bulat)
        int nilai2 = 5; // integer (bilangan bulat)
        int nilai3 = 2; // integer (bilangan bulat)
        //? mengapa integer?
        //* karena value dari variabel diatas semua nya bilangan bulat, maka dalam java di set menjadi "int"
        
        double result = (nilai1 + nilai2 + nilai3) / 3.0; // double (bilangan desimal)
        //? mengapa double?
        //* karena output value result kemungkinan akan berupa desimal, sebab ada proses pembagian. akan aneh jika set int, hasilnya tidak akan akurat. jadi disini saya set "double" saja

        // tampilkan output yang akan dibaca oleh user
        System.out.println("Nilai ke-1 : " + nilai1);
        System.out.println("Nilai ke-2 : " + nilai2);
        System.out.println("Nilai ke-3 : " + nilai3);
        System.out.printf("Rata-rata (formatted) : %.2f%n", result);
        System.out.println("Hasil Rata-rata adalah : " + result);
    }
}