import java.io.*;
import java.util.Scanner;

public class NotepadUygulamasi {

    public static void main(String[] args) {
        // Dosyada kaydedilmiş son metni ekrana yazdır
        String kaydedilmisMetin = dosyadanMetinOku();
        System.out.println("Kaydedilmiş Metin:");
        System.out.println(kaydedilmisMetin);

        // Kullanıcıdan metin girişi al
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir metin girin: ");
        String metin = scanner.nextLine();

        // Metni dosyaya kaydet
        dosyayaMetinKaydet(metin);
        System.out.println("Metin başarıyla kaydedildi.");
    }

    // Dosyaya metin yazma işlemi
    private static void dosyayaMetinKaydet(String metin) {
        try {
            FileWriter fileWriter = new FileWriter("notlar.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(metin);
            printWriter.close();
        } catch (IOException e) {
            System.err.println("Dosyaya yazma hatası: " + e.getMessage());
        }
    }

    // Dosyadan metin okuma işlemi
    private static String dosyadanMetinOku() {
        StringBuilder metin = new StringBuilder();
        try {
            File dosya = new File("notlar.txt");
            if (!dosya.exists()) {
                dosya.createNewFile();
            }
            FileReader fileReader = new FileReader(dosya);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String satir;
            while ((satir = bufferedReader.readLine()) != null) {
                metin.append(satir).append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Dosyadan okuma hatası: " + e.getMessage());
        }
        return metin.toString();
    }
}
