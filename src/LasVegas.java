import java.util.Random;

public class LasVegas {
    public long ogrenciNumarasi;
    public int hedefBolen;
    public LasVegas(long ogrenciNumarasi, int hedefBolen){
        this.ogrenciNumarasi = ogrenciNumarasi;
        this.hedefBolen= hedefBolen;
    }
    public static class Sonuc {

        public int  adimSayisi;
        public long sureNs;

        Sonuc(int adimSayisi, long sureNs) {
            this.adimSayisi  = adimSayisi;
            this.sureNs      = sureNs;
        }
    }
    public Sonuc LasVegasAlgoritmasi(int[] veri, int seedOffset) {
        int    n    = veri.length;
        Random random = new Random(ogrenciNumarasi + seedOffset);
        int    adim = 0;
        long   t0   = System.nanoTime();

        while (true) {
            adim++;
            int indeks = random.nextInt(n);
            if (veri[indeks] % hedefBolen == 0) {
                long sure = System.nanoTime() - t0;
                return new Sonuc(adim, sure);
            }
        }
    }
}
