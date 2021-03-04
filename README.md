# ConvertRGBintoCMYK
This program is converting the RGB(Red Green Blue three hues of light) into the CMYK(Cyan, Magenta, Yellow, and Key)

 This program converting the RGB into the CMYK. Where the scale for RGB is
 from 0 to 255, and for CMYK from 0.0 to 1.0.
 First, the program has two arrays for RGB and CMYK wit max number of 100.
 To populate RGB array from the file "colors.txt". I used hasNext method to 
 change the row and the for loop too reed the tree digits. Then, I wrote 
 validateRGB method. Which receives RGB and determines whether the values are
 valid. If the values in the range of 0 to 255 method returns true, if not 
 false. Next, method determines the maximum of three values and return it.
 Also, I wrote RGBtoCMYK void method which receives array RGB and array CMYK
 To do conversion first I found what is the value of white color by taking the 
 maximum of RGB values and dividing it by 255. If the max happens to be 0 
 then I placed all zeroes for CMY and for K is 1. If the white is not zero
 I used next formula f=(white-((double)RGB[i]/255.0))/white; for CMY and for 
 K 1- white. Then I used two print methods to print RGB and CMYK.
                
