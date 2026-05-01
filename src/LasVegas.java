import java.util.Random;

public class LasVegas {
    public long ogrenciNumarasi;
    public int hedefBolen;
    public LasVegas(long ogrenciNumarasi, int hedefBolen){
        this.ogrenciNumarasi = ogrenciNumarasi;
        this.hedefBolen= hedefBolen;
    }
    public static class Sonuc {
        public int  indeks;
        public int  deger;
        public int  adimSayisi;
        public long sureNs;

        Sonuc(int indeks, int deger, int adimSayisi, long sureNs) {
            this.indeks      = indeks;
            this.deger       = deger;
            this.adimSayisi  = adimSayisi;
            this.sureNs      = sureNs;
        }
    }
    public Sonuc LasVegasAlgoritmasi(int[] veri, int seedOffset) {
        int    n    = veri.length;
        Random rng  = new Random(ogrenciNumarasi + seedOffset);
        int    adim = 0;
        long   t0   = System.nanoTime();

        while (true) {
            adim++;
            int idx = rng.nextInt(n);
            if (veri[idx] % hedefBolen == 0) {
                long sure = System.nanoTime() - t0;
                return new Sonuc(idx, veri[idx], adim, sure);
            }
        }
    }
}
