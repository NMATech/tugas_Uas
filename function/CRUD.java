/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package function;

import databaseConfig.database;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author LENOVO
 */
public class CRUD {  
    public void tampilkan_data_event(JTable tableName, String field_col, String condition){
        String sql = "";
        
        DefaultTableModel event = new DefaultTableModel();
        event.addColumn("Event Name");
        event.addColumn("Event Date");
        event.addColumn("Event Location");
        event.addColumn("Event Deskription");
        
        try{
            int no = 1;
            if(field_col != "" && condition != ""){
               sql = "SELECT * FROM event WHERE " + field_col + " = '" + condition + "'";
            }else {
                sql = "SELECT * FROM event";
            }
            java.sql.Connection conn = (Connection)database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rst = stm.executeQuery(sql);
            
            while(rst.next()){
                event.addRow(new Object[]{rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)});
            }
            tableName.setModel(event);
        }catch(SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public void tambah_data(JTextField name, JTextField date, JTextField locate, JTextField desk){
        try {
            String sql = "INSERT INTO event values ('" + name.getText() + "', '" + date.getText() + "', '" + locate.getText() + "', '" + desk.getText() + "')";
            java.sql.Connection conn = (Connection)database.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Berhasil, Menambahkan Data");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void edit_data(JTextField name, JTextField date, JTextField locate, JTextField desk){
        try {
            String sql = "UPDATE event SET eventName='" + name.getText() + "', eventDate='" + date.getText() + "',eventLocation='" + locate.getText() + "',eventDeskription='" + desk.getText() + "' WHERE event.eventName = '" + name.getText() + "'";
            java.sql.Connection conn = (Connection)database.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Berhasil, Mengupdate Data");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void hapus_data(String name){
        try {
            String sql = "DELETE FROM event WHERE eventName='" + name + "'";
            java.sql.Connection conn = (Connection)database.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Berhasil, Menghapus Data");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
