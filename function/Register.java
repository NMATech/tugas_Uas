/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package function;

import databaseConfig.database;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author LENOVO
 */
public class Register extends CRUD {
    public void tambah_data(JTextField f_name, JTextField l_name, JTextField username, JPasswordField password){
        try {
            String sql = "INSERT INTO user values ('" + f_name.getText() + "', '" + l_name.getText() + "', '" + username.getText() + "', '" + password.getText() + "')";
            java.sql.Connection conn = (Connection)database.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Berhasil, Mendaftar");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
