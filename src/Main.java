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

        System.out.printf("\n [1/3] Veri seti oluşturuluyor (n=%,d, seed="+ogrenciNumarasi+")...\n", veriBoyutu);
        long t0   = System.nanoTime();

        VeriOlusturucu veriOlusturucu = new VeriOlusturucu(hedefBolen);

        int[] veri = veriOlusturucu.rastgeleVeriOlustur(veriBoyutu, ogrenciNumarasi);
         System.out.printf("      Tamamlandı (%.1f ms). İlk 5 eleman: %d %d %d %d %d \n",
                 (System.nanoTime() - t0) / 1_000_000.0,
                 veri[0], veri[1], veri[2], veri[3], veri[4]);

        System.out.println("\n[2/3] Teorik hesaplar yapılıyor...");
        TeorikHesap teorikHesap = new TeorikHesap(hedefBolen);
        teorikHesap.teorikHesap(veri);

        System.out.println("\n [3/3] Las Vegas "+donguSayisi+" kez çalıştırılıyor...\n");
        DeneyselAnaliz deneyselAnaliz = new DeneyselAnaliz(donguSayisi,hedefBolen,ogrenciNumarasi);
        deneyselAnaliz.deneyselAnaliz(veri);

        System.out.println("\n" + sep);
    }
}
