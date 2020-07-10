/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.*;
/**
 *
 * @author farhatdk
 */
public class koneksi {
    private Connection koneksi;
    public Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Berhasil!");
        } catch (ClassNotFoundException ex){
            System.out.println("Gagal!"+ex);
        }
        String url = "jdbc:mysql://localhost/posyandu";
        try{
            koneksi = DriverManager.getConnection(url,"root","");
            System.out.println("Berhasil Mengkoneksikan!");
        } catch (SQLException ex) {
            System.out.println("Gagal Mengkoneksikan!"+ex);
        }
        return koneksi;
    }
}
