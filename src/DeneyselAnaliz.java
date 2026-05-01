
public class DeneyselAnaliz {
    public int calismaSayisi;
    public int hedefBolen;
    public long ogrenciNumarasi;

    public DeneyselAnaliz(int calismaSayisi, int hedefBolen,long ogrenciNumarasi){
        this.calismaSayisi = calismaSayisi;
        this.hedefBolen = hedefBolen;
        this.ogrenciNumarasi = ogrenciNumarasi;
    }
    //Formül => E[x] = 1/p -> beklenen adım sayısı
    public static double E (double p){
        return 1.0/p;
    }
    public static double standartSapma(double p){
        return Math.sqrt((1.0 - p) / (p * p));
    }
    public void deneyselAnaliz(int[] veri) {
        int[]  adimlar = new int[calismaSayisi];
        long[] sureler = new long[calismaSayisi];

        long toplamBaslangic = System.nanoTime();

        LasVegas lasVegas = new LasVegas(ogrenciNumarasi,hedefBolen);

        for (int i = 0; i < calismaSayisi; i++) {
            LasVegas.Sonuc s   = lasVegas.LasVegasAlgoritmasi(veri, i);
            adimlar[i] = s.adimSayisi;
            sureler[i] = s.sureNs;
        }
        long toplamSure = System.nanoTime() - toplamBaslangic;

        double ortalamaAdim = YardimciMetotlar.ortalama(adimlar);
        double standartAdim = YardimciMetotlar.standartSapma(adimlar, ortalamaAdim);
        double ortalamaSure = YardimciMetotlar.ortalama(sureler) / 1_000_000.0;
        double standartSure = YardimciMetotlar.standartSapma(sureler, YardimciMetotlar.ortalama(sureler)) / 1_000_000.0;
        int    minimumAdim = YardimciMetotlar.min(adimlar);
        int    maximumAdim = YardimciMetotlar.max(adimlar);

        System.out.println("\n── DENEYSEL SONUÇLAR ("+calismaSayisi+" çalıştırma) ────────────────\n");
        System.out.printf("  Ortalama adım sayısı     : %.4f \n", ortalamaAdim);
        System.out.printf("  Standart sapma (adım)    : %.4f \n", standartAdim);
        System.out.printf("  Min / Maks adım      : %d / %d \n", minimumAdim, maximumAdim);
        System.out.printf("  Ortalama süre            : %.4f ms \n", ortalamaSure);
        System.out.printf("  Standart sapma (süre)    : %.4f ms \n", standartSure);
        System.out.printf("  Toplam deney süresi  : %.1f ms \n", toplamSure / 1_000_000.0);

        long hedefSayisi = 0;
        for (int x : veri) if (x % hedefBolen == 0) hedefSayisi++;
        //p: başarı olasılığı
        double p = (double) hedefSayisi / veri.length;

        double farkPct = Math.abs(ortalamaAdim - E(p)) / E(p) * 100.0;

        System.out.println("\n── TEORİ vs DENEY KARŞILAŞTIRMASI ───────────────────");
        System.out.printf("  E[X]  (teorik)       : %.4f \n", E(p));
        System.out.printf("  Ort.  (deneysel)     : %.4f \n", ortalamaAdim);
        System.out.printf("  Sapma yüzdesi        : %%%.2f \n", farkPct);

        System.out.println("\n── RASTSALLIĞIN STANDART SAPMAYA ETKİSİ ─────────────");
        System.out.printf("  Teorik Standart Sapma[X]        : %.4f%n", standartSapma(p));
        System.out.printf("  Deneysel standart sapma  : %.4f%n", standartAdim);
        System.out.printf("  Süre standart sapması    : %.4f ms%n", standartSure);
        System.out.println("  Not: Geometrik dağılımda Var[X] = (1-p)/p²");
    }

}
