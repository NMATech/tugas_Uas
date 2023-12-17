/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package function;

import databaseConfig.database;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author LENOVO
 */
public class Regist {
    private static int index;
    
    public void comboBox(JComboBox event){
        try {
            String sql = "SELECT * FROM event";
            java.sql.Connection conn = (Connection)database.configDB();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                event.addItem(rs.getString("eventName"));
            }
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void tambah_data(JComboBox event, JTextField nama, JTextField tgl){
        try {
            String sql = "INSERT INTO registrationticket values ('" + index + "', '" + nama.getText() + "', '" + event.getSelectedItem() + "', '" + tgl.getText() + "')";
            java.sql.Connection conn = (Connection)database.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Berhasil, Membeli Ticket");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
