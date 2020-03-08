package ysa;

import java.util.ArrayList;

public class Ileri {

    YSA y;
    Read r;

    public Ileri() {

    }

    public void Hesaplama(int k) {
YSA.hiddenCikis.clear();
        double toplam = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                toplam = toplam + YSA.agirlik1.get(String.valueOf(j) + String.valueOf(i)) * Read.girisler.get(k)[j];
                System.out.println("NetXXX" + i + " --> " + toplam);
            }
            double t = Sigmoid(toplam);

            YSA.hiddenCikis.add(t);

            System.out.println("Net" + i + " --> " + toplam);
            System.out.println("Sgimoid " + t);
            toplam = 0;

        }

        cikisHesapla(k);
    }

    public double Sigmoid(double toplam) {
        return 1 / (1 + Math.pow(Math.E, (-1 * toplam)));
    }

    public void cikisHesapla(int k) {

        YSA.cikis.clear();
        double toplam = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                toplam = toplam + YSA.agirlik2.get(String.valueOf(j) + String.valueOf(i)) * YSA.hiddenCikis.get(j);

            }
            double t = Sigmoid(toplam);
            YSA.cikis.add(t);
            System.out.println("Cikis" + i + " --> " + t);
            toplam = 0;
        }

    }

}
