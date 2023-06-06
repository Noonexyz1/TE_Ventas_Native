
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    /*mi conexion*/
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/bd_ventas";
    String usuario = "root";
    String password = "";

    protected Connection connection = null;

    /*constructor*/
    public ConexionDB() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, usuario, password);

            if (connection != null) {
                System.out.println("Conexion OK: " + connection);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Error en el driver: " + e.getMessage());

        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());

        }

    }

    public void desconectar() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());

        }
    }

    public Connection conectar() {
        return connection;
    }
    
}
