package ysa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class YSA {

    public static Map<String, Double> agirlik1;
    public static Map<String, Double> agirlik2;
    public static ArrayList<Double> hiddenCikis;
    public static ArrayList<Double> cikis;

    public static void main(String[] args) {
        Read r = new Read();
        r.oku();
        agirlik();
        Ileri i = new Ileri();
        Geri g = new Geri();
        for (int k = 0; k < 10; k++) {
             for (int j = 0; j < 4; j++) {
            i.Hesaplama(j);
            g.Hesaplama(j);
        }
        }
       
        
        kullanici();

    }

    public static void agirlik() {
        agirlik1 = new HashMap<>();
        agirlik2 = new HashMap<>();
        hiddenCikis = new ArrayList<>();
        cikis = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                agirlik1.put(String.valueOf(i) + String.valueOf(j), randomDouble());
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                agirlik2.put(String.valueOf(i) + String.valueOf(j), randomDouble());
            }
        }

    }

    public static double randomDouble() {
        Random r = new Random();
        double bool;
        if (r.nextBoolean()) {
            bool = r.nextDouble();
        } else {
            bool = r.nextDouble() * -1;
        }

        return bool;

    }
    
    public static void kullanici(){
        
        hiddenCikis.clear();
        Scanner input=new Scanner(System.in);
        ArrayList<Integer> myint=new ArrayList<>();
        myint.add(input.nextInt());
        myint.add(input.nextInt());
        myint.add(input.nextInt());
        myint.add(input.nextInt());
        
        
        double t=0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                t=t+myint.get(j)*agirlik1.get(String.valueOf(j)+String.valueOf(i));
            }
            hiddenCikis.add(Sigmoid(t));
            t=0;
        }
        
        double yeni=0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                yeni=yeni+hiddenCikis.get(j)*agirlik2.get(String.valueOf(j)+String.valueOf(i));
            }
            double my=Sigmoid(yeni);
            cikis.add(i, my);
            System.out.println(my);
               yeni=0;
        }
        
        
        
        
        
        
    }
    
    public static double Sigmoid(double toplam){
        return 1/(1+Math.pow(Math.E, (-1*toplam)));
    }
 


}
