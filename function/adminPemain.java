/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package function;

import databaseConfig.database;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class adminPemain extends CRUD {
    private static int index;
    private static String namaPemain;
    
    public void setNamaPemain(String nama){
        this.namaPemain = nama;
    }
    
    public String getNamaPemain(){
        return namaPemain;
    }
    
    public void tampilkan_data_pemain(JTable tableName){
        String sql = "";
        
        DefaultTableModel event = new DefaultTableModel();
        event.addColumn("No");
        event.addColumn("Nama Pemain");
        event.addColumn("Nama Tim");
        event.addColumn("Kategori");
        event.addColumn("Deskripsi");
        
        try{
            int no = 1;
            
            sql = "SELECT * FROM toppemain";
            
            java.sql.Connection conn = (Connection)database.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rst = stm.executeQuery(sql);
            
            while(rst.next()){
                event.addRow(new Object[]{rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)});
            }
            tableName.setModel(event);
        }catch(SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public void tambah_data(JTextField nama, JTextField tim, JComboBox kategori, JTextField deskripsi){
        try {
            String sql = "INSERT INTO toppemain values ('" + index + "', '" + nama.getText() + "', '" + tim.getText() + "', '" + kategori.getSelectedItem() + "', '" + deskripsi.getText() + "')";
            java.sql.Connection conn = (Connection)database.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            index += 1;
            JOptionPane.showMessageDialog(null, "Berhasil, Menambahkan kandidat pemain");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void hapus_data_pemain(String namaPemain){
        try {
            String sql = "DELETE FROM toppemain WHERE Nama_Pemain='" + namaPemain + "'";
            java.sql.Connection conn = (Connection)database.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Berhasil, Menghapus Data");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
