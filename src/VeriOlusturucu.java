import java.util.Random;

public class VeriOlusturucu {
    public int hedefBolen;

    public VeriOlusturucu(int hedefBolen){
        this.hedefBolen =hedefBolen;
    }
    public int[] rastgeleVeriOlustur(int n, long seed) {
        Random random = new Random(seed);
        int[]  veri = new int[n];
        boolean hedefVar = false;

        for (int i = 0; i < n; i++) {
            veri[i] = random.nextInt(10_000_000) + 1;
            if (veri[i] % hedefBolen == 0) hedefVar = true;
        }

        if (!hedefVar) {
            int idx = random.nextInt(n);
            veri[idx] = hedefBolen;
        }
        return veri;
    }

}
