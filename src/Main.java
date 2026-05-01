/**
 * =========================================================
 *   RANDOMİZE ALGORİTMA — LAS VEGAS YAKLAŞIMI
 *   Öğrenci No : 1240505027
 *   Son 2 hane : 27  →  Tek  →  Las Vegas
 *   Son rakam  : 7   →  Y>=5 →  n = 10^6
 *   Koşul       : dizi[i] % 10 == 0
 * =========================================================
 */

public class Main{
    static final long ogrenciNumarasi = 1240505027L;
    static final int veriBoyutu = 1_000_000;
    static final int hedefBolen = 10;
    static final int donguSayisi = 100;

     public static void main(String[] args) {
        String sep = "=".repeat(60);

        System.out.println(sep);
        System.out.println("  LAS VEGAS ALGORİTMASI — SONUÇ RAPORU");
        System.out.println("  Öğrenci No (Aynı zamanda Seed değerimiz) : "+ogrenciNumarasi);
        System.out.printf("  n = %,d  |  Koşul : x %% %d == 0 \n", veriBoyutu, hedefBolen);
        System.out.println(sep);

        System.out.printf("%n[1/3] Veri seti oluşturuluyor (n=%,d, seed=%d)...%n", veriBoyutu, ogrenciNumarasi);
        long t0   = System.nanoTime();

        VeriOlusturucu veriOlusturucu = new VeriOlusturucu(hedefBolen);

        int[] veri = veriOlusturucu.rastgeleVeriOlustur(veriBoyutu, ogrenciNumarasi);
        System.out.printf("      Tamamlandı (%.1f ms). İlk 5 eleman: %d %d %d %d %d%n",
                (System.nanoTime() - t0) / 1_000_000.0,
                veri[0], veri[1], veri[2], veri[3], veri[4]);

        System.out.println("\n[2/3] Teorik hesaplar yapılıyor...");
        TeorikHesap teorikHesap = new TeorikHesap(hedefBolen);
        teorikHesap.teorikHesap(veri);

        System.out.printf("%n[3/3] Las Vegas %d kez çalıştırılıyor...%n", donguSayisi);
        DeneyselAnaliz deneyselAnaliz = new DeneyselAnaliz(donguSayisi,hedefBolen,ogrenciNumarasi);
        deneyselAnaliz.deneyselAnaliz(veri);

        System.out.println("\n" + sep);
    }
}
