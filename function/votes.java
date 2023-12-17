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
public class votes {
    public void comboBox(JComboBox pemain){
        try {
            String sql = "SELECT * FROM toppemain";
            java.sql.Connection conn = (Connection)database.configDB();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                pemain.addItem(rs.getString("Nama_Pemain"));
            }
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void tambah_votes(JComboBox namaPemain, JTextField nama){
        try {
            String sql = "INSERT INTO voters values ('" + nama.getText() + "', '" +  namaPemain.getSelectedItem() + "')";
            java.sql.Connection conn = (Connection)database.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Berhasil, Memvoting");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
