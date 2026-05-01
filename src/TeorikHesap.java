public class TeorikHesap {
    public int hedefBolen;

    public TeorikHesap(int hedefBolen){
        this.hedefBolen = hedefBolen;
    }

    public void teorikHesap(int[] veri) {
        long hedefSayisi = 0;
        for (int x : veri) if (x % hedefBolen == 0) hedefSayisi++;

        double p    = (double) hedefSayisi / veri.length;
        double ex   = 1.0 / p;
        double varX = (1.0 - p) / (p * p);
        double stdX = Math.sqrt(varX);

        System.out.println("\n── TEORİK HESAP ──────────────────────────────────────");
        System.out.printf("  Hedef eleman sayısı     : %,d%n",  hedefSayisi);
        System.out.printf("  Başarı olasılığı (p)    : %.6f%n", p);
        System.out.printf("  E[X] = 1/p              : %.4f  adım%n", ex);
        System.out.printf("  Var[X] = (1-p)/p^(2)    : %.4f%n", varX);
        System.out.printf("  Std[X] = √Var[X]        : %.4f%n", stdX);
    }
}
