/**
 * Main
 */

import java.io.*;
//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Main {

    public static void main(String[] args) {
        String line = "";  
        String splitBy = ",";  
        try   
        {  
            //parsing a CSV file into BufferedReader class constructor
            ArrayList<String[]> boats = new ArrayList<String[]>();
            int i = 0;
  
            BufferedReader br = new BufferedReader(new FileReader("Centerboard.csv"));  
            while ((line = br.readLine()) != null) {  //returns a Boolean value  

            String[] employee = line.split(splitBy);    // use comma as separator
            boats.add(employee);
            //System.out.print(employee[1]);
            //System.out.println(employee[1].contains("B1"));  
            }


            for(int p = 0; p < boats.size(); p++){
                //System.out.println(boats.get(p));
                for(int t = 0; t < boats.get(p).length; t++){
                    System.out.print(boats.get(p)[t] + " | ");
                }
                System.out.println();
            }

            for(int g = 0; g < boats.size(); g++){
                //for(int h = 0; h < boats.get(g)[h].length(); h++){
                    //String thString = boats.get(g)[0].substring(0, boats.get(g)[0].indexOf("Centerboard"));
                    //System.out.print(boats.get(g)[0].indexOf("Centerboard") + "  ");
                

                if(boats.get(g)[0].indexOf("Centerboard") != -1){
                    System.out.println(boats.get(g)[0].substring(0, boats.get(g)[0].indexOf("Centerboard")-1));
                    //System.out.println();
                }
                else{
                    System.out.println(boats.get(g)[0]);
                }


                
            }
            System.out.println("\n\n");

            for(int j = 0; j < boats.size(); j++){
                if(boats.get(j)[0].indexOf("Centerboard") != -1){
                    //System.out.print(boats.get(j)[0].substring(boats.get(j)[0].indexOf("Centerboard")+12).indexOf(" ")  + "  ");

                    //System.out.println(boats.get(j)[0].substring(boats.get(j)[0].indexOf("Centerboard")+12));

                    String thString = boats.get(j)[0].substring(boats.get(j)[0].indexOf("Centerboard")+12);

                    if(thString.indexOf(' ') != -1){
                        System.out.println(thString.substring(0, thString.indexOf(' ')));
                    }
                    else{
                        System.out.println(thString);
                    }

                    //System.out.println(thString.substring(0, thString.indexOf(' ')));
                }
            }

            System.out.println("\n\n\n");
            for(int k = 0; k < boats.size(); k++){
                String th = boats.get(k)[0].substring(boats.get(k)[0].indexOf("Centerboard")+12);

                th = th.substring(th.indexOf(' ') + 1);

                //System.out.println(th + "  " + th.indexOf(' '));

                if(th.contains(" ")){
                    th = th.substring(0, th.indexOf(' '));
                }
                else{
                    th = th.substring(0) ;
                }

                if(th.charAt(0) == '[' || th.charAt(0) == '('){
                    th = th.substring(1, th.length()-1);
                }

                //th = th.substring(0, th.indexOf(' '));

                System.out.println(th);


            }
             
            

            //System.out.println(boats.get(1));
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  

        
        
        
    }
}