 
package ysa;
 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Read {
  public static  ArrayList<Integer[]> girisler;
  public static  ArrayList<Integer[]> cikislar;
    
    public Read(){
        girisler = new ArrayList<>();
        cikislar = new ArrayList<>();
    }
    public  void oku(){
        
         BufferedReader read;
        try {
            read = new BufferedReader(new FileReader("veri.txt"));
            String line;
            
            while((line = read.readLine()) != null){
                String[] dizi = line.split(" ");
                Integer[] a1 = new Integer[4];
                 Integer[] a2 = new Integer[2];
                 int sayac = 0;
                 for (int i = 0; i < dizi.length-2; i++) {
                    
                    a1[i] = Integer.valueOf(dizi[i]);
                     sayac++;
                }
                  for (int i = 0; i < dizi.length-4; i++) {
                    a2[i] = Integer.valueOf(dizi[sayac]);
                    sayac++;
                }
                  girisler.add(a1);
                  cikislar.add(a2);
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
