import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collections;

public class Calculator {
    public static void main(String[] args) {
        String line = "";
        String splitBy = ",";


        try   
        {  
            //parsing a CSV file into BufferedReader class constructor
            ArrayList<String[]> boats = new ArrayList<String[]>();
            //int i = 0;
  
            BufferedReader br = new BufferedReader(new FileReader("DB.csv"));  
            while ((line = br.readLine()) != null) {  //returns a Boolean value  

            String[] employee = line.split(splitBy);    // use comma as separator
            boats.add(employee);
            //System.out.print(employee[1]);
            //System.out.println(employee[1].contains("B1"));  
            }

            System.out.println("Use this chart for reference of boat codes: ");

            Thread.sleep(2000);
            


            for(int p = 0; p < boats.size(); p++){
                //System.out.println(boats.get(p));
                for(int t = 0; t < 2; t++){
                    System.out.print(boats.get(p)[t] + " | ");
                }
                System.out.println();
            }

            System.out.println("\n\n\n\n");
            Scanner myScan = new Scanner(System.in);

            System.out.print("Insert Number of Races: ");
            int numRaces = Integer.parseInt(myScan.nextLine());
            System.out.println();

            for(int i = 0; i < numRaces; i++){
                System.out.print("Input the Name of the inserted CSV: ");
                String csv = myScan.nextLine();

                if(!csv.contains(".csv") && !csv.contains(".CSV")){
                    csv = csv + ".csv";
                }
                //csv = csv + ".csv";
                while(true){
                    try{
                        ArrayList<String[]> data = new ArrayList<String[]>();
                        BufferedReader fileReader = new BufferedReader(new FileReader(csv));

                        while((line = fileReader.readLine()) != null){
                            String[] row = line.split(splitBy);
                            data.add(row);

                        }

                        for(int p = 0; p < data.size(); p++){
                            //System.out.println(boats.get(p));
                            for(int t = 0; t < data.get(p).length; t++){
                                //System.out.print(data.get(p)[t] + " | ");
                            }
                            //System.out.println();
                        }
                        //System.out.println("\n\n\n");

                        for(int s = 0; s < data.size(); s++){
                            String theString = data.get(s)[0];

                            for(int g = 0; g < boats.size(); g++){
                                boolean contains = boats.get(s)[1].equals(theString);
                                if(contains){
                                    //System.out.println();

                                    break;
                                }
                                else if(!contains && g == boats.size()-1){
                                    System.out.println("a boat cannot be identified at line: " + (s+1));
                                }
                            }

                            
                            





                        }

                        /*System.out.println("windspeed in knots? (true or false)");
                        boolean knots = Boolean.parseBoolean(myScan.nextLine());
                        
                        if(knots){
                            String[] array = data.get(0);
                            array[5] = Double.toString((Double.parseDouble(array[5])+5)/5);
                            data.set(0, array);
                        }
                        //System.out.println(data.get(0)[5] + " Beaufort");*/

                        for(int l = 0; l < data.size(); l ++){
                            String[] thArray = new String[5];
                            thArray = data.get(l);
                            
                            for(int z = 0; z < boats.size(); z++){
                                if(boats.get(z)[1].equalsIgnoreCase(thArray[0])){
                                    //System.out.println("yep");
                                    thArray[2] = boats.get(z)[2];
                                    data.set(l, thArray);
                                    
                                }


                            }


                                                         
                            
                        }
                        for(int p = 0; p < data.size(); p++){
                            //System.out.println(boats.get(p));
                            for(int t = 0; t < data.get(p).length; t++){
                                //System.out.print(data.get(p)[t] + " | ");
                            }
                            //System.out.println();
                        }
                        for(int c =0; c < data.size(); c++){
                                String[] theString = data.get(c);
                                theString[3] = Double.toString((Double.parseDouble(theString[1])/Double.parseDouble(theString[2])*100));
                                data.set(c, theString);
                        }

                        for(int x =0; x < data.size(); x ++){
                            //System.out.println(data.get(x)[2]);

                        }

                        for(int p = 0; p < data.size(); p++){
                            //System.out.println(boats.get(p));
                            for(int t = 0; t < data.get(p).length; t++){
                                //System.out.print(data.get(p)[t] + " | ");
                            }
                            //System.out.println();
                        }
                        Double[] leaderboard = new Double[data.size()];

                        for(int q = 0; q < data.size(); q ++){
                            leaderboard[q] = Double.parseDouble(data.get(q)[3]);
                        }

                        Double[] sortedLeaderboard = leaderboard;

                        Arrays.sort(sortedLeaderboard, Collections.reverseOrder());

                        //System.out.println(Arrays.toString(sortedLeaderboard));

                        for(int q = sortedLeaderboard.length-1; q >= 0; q--){
                            Double g = sortedLeaderboard[q];

                            for(int p = 0; p < data.size(); p++){
                                if(Double.parseDouble(data.get(p)[3]) == sortedLeaderboard[q]){
                                    System.out.println((q+1) + ". "+ data.get(p)[0] + " " + data.get(p)[4]);
                                    break;
                                }
                            }
                        }





                                          

                        

                        fileReader.close();
                        break;
                    }
                    catch(IOException e){
                        //e.printStackTrace();
                        System.out.println("file cannot be found\n\n\n\n\n");
                        i--;
                        break;
                    }
                }



            }


            

            
             
            

            //System.out.println(boats.get(1));
            myScan.close();
            br.close();
        }   
        catch (IOException | InterruptedException e)   
        {  
            e.printStackTrace();  
        }

        
        
        
    }
    
}
