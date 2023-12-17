/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package function;

/**
 *
 * @author LENOVO
 */
public class eventFunc {
    public String getFieldCol(int index){
        String col = "";
        switch(index){
            case 0:
                col = "eventName";
                break;
            case 1:
                col = "eventDate";
                break;
            case 2:
                col = "eventLocation";
                break;
            case 3:
                col = "eventDeskription";
                break;
        }
        
        return col;
    }
}
