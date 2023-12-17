/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package function;

/**
 *
 * @author LENOVO
 */
public class adminEvent extends CRUD {
    private static String eventName, eventDate, eventLocate, eventDesk;
    
    public void setName(String eventName){
        this.eventName = eventName;
    }
    
    public void setDate(String eventDate){
        this.eventDate = eventDate;
    }
    
    public void setLocate(String eventLocate){
        this.eventLocate = eventLocate;
    }
    
    public void setDesk(String eventDesk){
        this.eventDesk = eventDesk;
    }
    
    public String getName(){
        return eventName;
    }
    
    public String getLocate(){
        return eventLocate;
    }
    
    public String getDate(){
        return eventDate;
    }
    
    public String getDesk(){
        return eventDesk;
    }
}
