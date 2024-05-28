/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ude.poo.procesospoliticos.util.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author camil
 */
public class DBConection {
    Connection con = null;
    public static Connection ConnectionDB(){
        // se requiere conectar a SQLite
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:DB_ProcesosPoliticos.db");
            System.out.println("Conexión exitosa");
            return con;
        }catch(Exception e){
            System.out.println("Conexión fallida: " + e);
            return null;
        }
    }
    
    public static void main(String[] args){
        ConnectionDB();
    }
}
