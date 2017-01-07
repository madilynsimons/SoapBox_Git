/*
 * Window.java
 * @author Triston Madilyn Simons
 * @version Janurary 6, 2017
**/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Window{
  
  ArrayList<Politician> politicians;
  String[] states;
  
  public Window(){}
  
  public void open(){
    
    //frame itself
    JFrame frame = new JFrame("SoapBox");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(500, 400));
    
    //state combobox
    JComboBox stateBox = new JComboBox(states);
    frame.setContentPane(stateBox);
    
    //final touches c;
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    
  }//end of open()
  
  public void setPoliticians(ArrayList<Politician> politicians){
    this.politicians = politicians;
  }//end of setPoliticians()
  
  public void setStates(ArrayList<String> arr){
    states = new String[arr.size()];
    for(int x = 0; x < arr.size(); x++){
     states[x] = arr.get(x); 
    }
  }//end of setStates()
  
  
}//end of class