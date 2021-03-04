/**
 * @author Farukh Khassan Khojayev.
 * @since 11-21-2019
 * @vesion 1.0
 * 
 */ 
package homework5a;
import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;


public class Homework5a {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("colors.txt"));
        PrintStream ps = new PrintStream("Homework5a.txt");
        final int MAXNUMBER=100;
        int[] RGB = new int[MAXNUMBER];
        double[] CMYK = new double[MAXNUMBER];
        ps.println("        RGB                   CMYK");
        ps.println();
      
        while(sc.hasNext()){
            for(int i=0; i<3; i++){
               RGB[i]=sc.nextInt();
            }
            if(validateRGB(RGB)==true){
            RGBTtoCMYK(RGB,CMYK);
            printRGB(RGB,ps);
            printCMYK(CMYK,ps);
            
            }  
    }
}// This method will return true for arrays fron o to 255 and false for other.
    public static boolean validateRGB (int[] RGB){
        boolean valid = true;
        for(int i=0; i<3; i++){
            if(0<=RGB[i]&&RGB[i]<=255){
                
            }
            else{   valid=false;
            }
            
        }
        return valid;
        
    }
    // This method will return the maximum of three arrayss.
    public static int maximum(int x[]){
        int largest,i;
        largest=x[0];
        for(i=1; i<3; i++){
            if(x[i]>=largest){
                largest=x[i];
            }
        }
        return largest;
    }
//This method will conver from RGB to CMYK and place the values to CMYK arrays    
    public static void RGBTtoCMYK(int RGB[], double CMYK[]){
        double white,f;
        white=(double)maximum(RGB)/255;
            if(white==0){
                for (int i=0; i<3; i++){
                CMYK[i]=0;
                
                }
                CMYK[3]=1;
                
            }else{      
                for(int i=0; i<3; i++){
                    
                f=(white-((double)RGB[i]/255.0))/white;
                CMYK[i]=f;
                
                }
                CMYK[3]=(double)Math.abs(1-white);
                
            }
    }
 // This method wiil print RGB values.   
    public static void printRGB(int RGB[],PrintStream ps){
        for(int i=0; i<3; i++){
            ps.printf("%3d  ",RGB[i]);
        }
     
    }
 // This method wiil print CMYK values.    
    public static void printCMYK(double  CMYK[], PrintStream ps){
        for(int i=0; i<4; i++){
            ps.printf("%6.2f  ",CMYK[i]);
        }
        ps.println();
    }
}
