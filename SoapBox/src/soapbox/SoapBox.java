/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapbox;

/**
 *
 * @author madilynsimons
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SoapBox{
  
  //variables
  static ArrayList<Politician> politicians;
  static ArrayList<String> states;
  static ArrayList<String> counties;
  
  static String myState;
  static String myCounty;
  static ArrayList<Politician> myPoliticians;
  
  static Window window;
  
  //main method
  public static void main(String[] args){
    
    
   politicians = new ArrayList<Politician>();
   states = new ArrayList<String>();
   counties = new ArrayList<String>();
   
   myState = null;
   myCounty = null;
   myPoliticians  = new ArrayList<Politician>();
   
   parseStringList(states, "docs/states.txt");
   parsePoliticians();
   
   window = new Window();
   
   window.execute();
                
  }
  
  public static String[] getStates(){
       String arr[] = new String[states.size()];
        for(int x = 0; x < states.size(); x++){
            arr[x] = states.get(x);
        }
        return arr;
  }
  
  public static void setCounties(String state){
      
      String fileName = "docs/counties/" + state.replace(" ", "").toLowerCase() + ".txt";
      
      if(!(state.equals("CHOOSE A STATE"))){
        Scanner inData = null;
        try{
           inData = new Scanner(new File(fileName));
        }catch(FileNotFoundException e){
            System.err.println("county file not found");
         }
        while(inData.hasNextLine()){
            counties.add(inData.nextLine());
         }
         inData.close();
      }
  }
  
  public static String[] getCounties(String state){
      String[] arr = new String[counties.size()];
      for(int x = 0; x < counties.size(); x++){
          arr[x] = counties.get(x);
      }
      return arr;
  }
  
  public static void parsePoliticians(){
    Scanner inData = null;
    
    try{
      inData = new Scanner(new File("docs/politicians.txt"));
    }catch(FileNotFoundException e){
     System.err.println("politician file not found"); 
    }
    
    String contents[] = new String[5];
    int IDnum = 0;
    
    while(inData.hasNextLine()){
      contents = inData.nextLine().split(",");
      politicians.add(new Politician(IDnum));
      politicians.get(IDnum).setName(contents[0]);
      politicians.get(IDnum).setTwitter(contents[1]);
      politicians.get(IDnum).setState(contents[2]);
      politicians.get(IDnum).setParty(contents[3]);
      politicians.get(IDnum).setPosition(contents[4]);
      IDnum++;
    }
    
    inData.close();
    
  }//end of parsePoliticians
  
  public static void parseStringList(ArrayList<String> list, String fileName){
    Scanner inData = null;
   
   try{
     inData = new Scanner(new File(fileName));
   }catch(FileNotFoundException e){
     System.err.println("file " + fileName + " not found");
   }
   
   while(inData.hasNextLine()){
     list.add(inData.nextLine());
   }
   
   inData.close();
  }//end of parseStringList
  
  public static void setMyState(String temp){
      myState = temp;
      setCounties(myState);
      myPoliticians.clear();
      addPoliticians(myState, "senator");
  }
  
  public static String getMyState(){
      return myState;
  }
  
  public static void setMyCounty(String temp){
      myCounty = temp;
      addPoliticians(myState, "representative");
  }
  
  public static String getMyCounty(){
      return myCounty;
  }
  
  public static void addPoliticians(String state, String position){

      for(int x = 0; x < politicians.size(); x++){
          if(politicians.get(x).getState().toUpperCase().equals(state.toUpperCase())){
              if(politicians.get(x).getPosition().toUpperCase().equals(position.toUpperCase())){
                  myPoliticians.add(politicians.get(x));
              }//end of inner if statement
          }//end of outter if statement
      }//end of for loop
      

      
  }//end of addPoliticians()
  
  //returns an array, not an arraylist
  public static String[] getMyPoliticians(){
    String politicians_arr[] = new String[myPoliticians.size()];
      
      for(int x = 0; x < myPoliticians.size(); x++){
          politicians_arr[x] = myPoliticians.get(x).getName();
       }
      return politicians_arr;
  }
  
  
}//end of class