package br.stalkersat.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	Connection con = new ConnectionFactory().getConnectionMySQL();
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/stalkersat_db", "root","");
	}
	
	private Conexao() {}

}
