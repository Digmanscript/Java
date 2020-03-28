package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	
	
	public static Connection getConnection() {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/login_bd";
			String usuario = "root";
			String contraseña = "";
			
			con = DriverManager.getConnection(url,usuario,contraseña);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error ---> al cargar el driver");
			
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error ---> al conectar con la BD");
			
			e.printStackTrace();
		}
		
		return con;
		
	}

}
