public class TeorikHesap {
    public int hedefBolen;

    public TeorikHesap(int hedefBolen){
        this.hedefBolen = hedefBolen;
    }

    public void teorikHesap(int[] veri) {
        long hedefSayisi = 0;
        for (int x : veri) if (x % hedefBolen == 0) hedefSayisi++;

        double p = YardimciMetotlar.p(hedefSayisi,veri.length);
        double ex = YardimciMetotlar.E(p);
        double varyans = YardimciMetotlar.varyans(p);
        double standartSapmaX = Math.sqrt(varyans);

        System.out.println("\n── TEORİK HESAP ──────────────────────────────────────");
            System.out.printf("  Hedef eleman sayısı               : %,d%n",  hedefSayisi);
        System.out.printf("  Başarı olasılığı (p)              : %.6f%n", p);
        System.out.printf("  E[X] = 1/p                        : %.4f  adım%n", ex);
        System.out.printf("  Varyans[X] = (1-p)/p^(2)          : %.4f%n", varyans);
        System.out.printf("  StandartSapma[X] = √Varyans[X]    : %.4f%n", standartSapmaX);
    }
}
