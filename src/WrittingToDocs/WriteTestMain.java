

package WrittingToDocs;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class WriteTestMain 
{
   private static int[] unsorted_Array = new int[50000];
   private static int[] sorted_Array = new int[50000];
   private static int[] keys_Array = new int[100];
   
    public static void generate()
    {
        for (int i =0; i<unsorted_Array.length; i++)
        unsorted_Array[i] = (int)(Math.random()*100000);
    }
    public static void keyMaker()
    {
        int temp;
       for (int i =0; i<keys_Array.length; i++)
       {
        temp = (int)(Math.random()*50000); 
        keys_Array[i] = unsorted_Array[temp];
       }
    }
    public static void main(String[] args)
    {  
        Quicksort qsort = new Quicksort();
        generate();
        for(int i =0; i<unsorted_Array.length; i++)
            sorted_Array[i] = unsorted_Array[i];
        qsort.qSort(sorted_Array,0,sorted_Array.length-1);
        keyMaker();
        
        
       
        int ha = 5000;
        WriteToWord w = new WriteToWord(ha);
        
        int[] key = new int[ha];
        
        for(int x = 0; x < ha; x++){
            key[x] = x+1;
        }
        
        for(int c = 0; c < ha; c++){
            w.addTo(c, 0, key[c]);
            
            w.addTo(c, 1, rand());
            
            w.addTo(c, 2, rand());
            
            w.addTo(c, 3, rand());
            
            w.addTo(c, 4, rand());
                       
            w.addTo(c, 5, rand());
            
            w.addTo(c, 6, rand());
            
            w.addTo(c, 7, rand());
            
            w.addTo(c, 8, rand()); 
        }
        
       
        try {
            w.WriteToMs();
        } catch (IOException ex) {
            Logger.getLogger(WriteTestMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int [][] test = new int [2][2];
        test[0][0]=1;
        test[0][1]=2;
        test[1][0]=3;
        test[1][1]=4;
        System.out.println(test[0][0] + " " + test[0][1]);
        System.out.println(test[1][0] + " " + test[1][1]);
        
        
        
    }
    
}
