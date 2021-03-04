/**
 * @author Farukh Khassan Khojayev.
 * @since 11-21-2019
 * @vesion 1.0
 * 
 * This program converting the RGB into the CMYK. Where the scale for RGB is
 * from 0 to 255, and for CMYK from 0.0 to 1.0.
 * First, the program has two arrays for RGB and CMYK wit max number of 100.
 * To populate RGB array from the file "colors.txt". I used hasNext method to 
 * change the row and the for loop too reed the tree digits. Then, I wrote 
 * validateRGB method. Which receives RGB and determines whether the values are
 * valid. If the values in the range of 0 to 255 method returns true, if not 
 * false. Next, method determines the maximum of three values and return it.
 * Also, I wrote RGBtoCMYK void method which receives array RGB and array CMYK
 * To do conversion first I found what is the value of white color by taking the 
 * maximum of RGB values and dividing it by 255. If the max happens to be 0 
 * then I placed all zeroes for CMY and for K is 1. If the white is not zero
 * I used next formula f=(white-((double)RGB[i]/255.0))/white; for CMY and for 
 * K 1- white. Then I used two print methods to print RGB and CMYK.
                
 * 
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