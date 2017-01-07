/*
 * SoapBox.java
 * @author Triston Madilyn Simons
 * @version Janurary 6, 2017
**/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SoapBox{
  
  //variables
  static ArrayList<Politician> politicians;
  static ArrayList<String> states;
  static ArrayList<String> counties;
  static Window window;
  
  //main method
  public static void main(String[] args){
    
   window = new Window();
    
   politicians = new ArrayList<Politician>();
   states = new ArrayList<String>();
   counties = new ArrayList<String>();
   
   parseStringList(states, "docs/states.txt");
   parsePoliticians();
   
   window.setPoliticians(politicians);
   window.setStates(states);
    
   window.open();
   
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
  
  
}//end of class