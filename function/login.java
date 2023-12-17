/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package function;

import databaseConfig.database;
import java.awt.HeadlessException;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author LENOVO
 */
public class login {
    public void login(JTextField name, JPasswordField pass){
        try {
            String sql = "SELECT * FROM user WHERE username='" + name.getText() + "' and password='" + pass.getText() + "'";
            java.sql.Connection conn = (Connection)database.configDB();
            java.sql.Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
               if(name.getText().equals("admin") && pass.getText().equals("admin123")){
                  JOptionPane.showMessageDialog(null, "Selamat Datang Admin !");
               }else {
                  JOptionPane.showMessageDialog(null, "Selamat Datang User !");
               }
            }else {
               JOptionPane.showMessageDialog(null, "username atau password salah ! ");
            }
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
