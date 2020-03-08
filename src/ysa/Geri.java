 
package ysa;
 
import java.util.ArrayList;

public class Geri {
    
    ArrayList<Double> hataCikis;
    ArrayList<Double> hataAraKatman;
    public static final double lamda = 0.1;
    public Geri(){
        hataCikis = new ArrayList<>();
        hataAraKatman = new ArrayList<>();
    }
    
    public void Hesaplama(int k){
        cikisHata(k);
        araKatmanHata();
        System.out.println("");
        System.out.println("=================================");
        System.out.println("");
        araAgirlikGuncelle(k);
    }
    
    public void cikisHata(int k){
hataCikis.clear();
        for (int i = 0; i < 2; i++) {
            double t = YSA.cikis.get(i)*(1-YSA.cikis.get(i))*(Read.cikislar.get(k)[i]-YSA.cikis.get(i));
            hataCikis.add(t);
            
            System.out.println("HATA"+i+" --> "+t);
        }
        cikisAgirlikGuncelle();
    }
    
    public void cikisAgirlikGuncelle(){
        double w = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                w = lamda*YSA.hiddenCikis.get(i)*hataCikis.get(j);
                double w1 = YSA.agirlik2.get(String.valueOf(i)+String.valueOf(j)) +w;
                System.out.print("Delta W --> "+w+" ");
                System.out.print("Önceki Agirlik --> "+YSA.agirlik2.get(String.valueOf(i)+String.valueOf(j))+" ");
                YSA.agirlik2.put(String.valueOf(i)+String.valueOf(j), w1);
                System.out.println("Sonraki Agirlik --> "+i+""+j+" --> "+w1);
            }
        }
    }
    
    public void araKatmanHata(){
        hataAraKatman.clear();
        double t =0,t2=0;
        for (int i = 0; i < 3; i++) {
             t = YSA.hiddenCikis.get(i)*(1-YSA.hiddenCikis.get(i));
            for (int j = 0; j < 2; j++) {
               t2 = t2 +hataCikis.get(j)*YSA.agirlik2.get(String.valueOf(i)+String.valueOf(j));
            }
            System.out.println("S"+i +" --> "+t*t2);
            hataAraKatman.add(t*t2);
        }
    }
    
    public void araAgirlikGuncelle(int k){
        
         double w = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
           
                w = lamda*Read.girisler.get(k)[i]*hataAraKatman.get(j);
                double w1 = YSA.agirlik1.get(String.valueOf(i)+String.valueOf(j)) + w;
                 System.out.print("Delta1 W --> "+w+" ");
                System.out.print("Önceki Agirlik1 --> "+YSA.agirlik1.get(String.valueOf(i)+String.valueOf(j)) +" ");
                YSA.agirlik1.put(String.valueOf(i)+String.valueOf(j), w1);
                System.out.println("Sonraki Agirlik1 --> "+i+""+j+" --> "+w1);
            }
        }
    }
}
