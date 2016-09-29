package br.stalkersat.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Conectado");
		return DriverManager.getConnection("jdbc:mysql://localhost/stalkersat_db", "root","");
	}
	
	private Conexao() {
		
	}
}
