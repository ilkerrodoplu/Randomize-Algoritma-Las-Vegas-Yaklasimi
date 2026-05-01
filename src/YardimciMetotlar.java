public class YardimciMetotlar {
    public static double ortalama(int[] a) {
        long toplam = 0;
        for (int v : a) toplam += v;
        return (double) toplam / a.length;
    }

    public static double ortalama(long[] a) {
        long toplam = 0;
        for (long v : a) toplam += v;
        return (double) toplam / a.length;
    }

    public static double standartSapma(int[] a, double ort) {
        double toplam = 0;
        for (int v : a) toplam += (v - ort) * (v - ort);
        return Math.sqrt(toplam / (a.length - 1));
    }

    public static double standartSapma(long[] a, double ort) {
        double toplam = 0;
        for (long v : a) toplam += (v - ort) * (v - ort);
        return Math.sqrt(toplam / (a.length - 1));
    }
    public static int min(int[] a) { int m = a[0]; for (int v : a) if (v < m) m = v; return m; }
    public static int max(int[] a) { int m = a[0]; for (int v : a) if (v > m) m = v; return m; }

    //Formül => E[x] = 1/p -> beklenen adım sayısı
    public static double E (double p){
        return 1.0/p;
    }
    public static double varyans(double p){
        return (1.0 - p) / (p * p);
    }
    //p: başarı olasılığı
    public static double p(long hedefSayisi,int veriUzunlugu){
        return (double) hedefSayisi /veriUzunlugu;
    }
}
