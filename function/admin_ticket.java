/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package function;

import databaseConfig.database;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class admin_ticket {
    public void tampilkan_data_ticket(JTable tableName){
        String sql = "";
        
        DefaultTableModel event = new DefaultTableModel();
        event.addColumn("Regist ID");
        event.addColumn("Nama Registers");
        event.addColumn("Events");
        event.addColumn("Tanggal Pembeli");
        
        try{
            int no = 1;
            sql = "SELECT * FROM registrationticket";
            
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
}
