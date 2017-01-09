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
public class Politician{
  
  //variables
  String name, twitter, party, state, position;
  int IDnum; //immutable
  
  //constuctors
  public Politician(int IDnum){
    name = null;
    twitter = null;
    state = null;
    party = null;
    position = null;
    this.IDnum = IDnum;
  }
  
  //getters and setters
  public void setName(String name){
   this.name = name; 
  }
  
  public String getName(){
   return name; 
  }
  
  public void setTwitter(String twitter){
   this.twitter = twitter; 
  }
  
  public String getTwitter(){
   return twitter; 
  }
  
  public void setState(String state){
   this.state = state; 
  }
  
  public String getState(){
   return state; 
  }
  
  public void setParty(String party){
   this.party = party; 
  }
  
  public String getParty(){
   return party; 
  }
  
  public void setPosition(String position){
   this.position = position; 
  }
  
  public String getPosition(){
   return position; 
  }
  
  public int getIDnum(){
   return IDnum; 
  }
  
  public String toString(){
   return name + " " + state + " " + party + " " + position; 
  }

  
}//end of class
