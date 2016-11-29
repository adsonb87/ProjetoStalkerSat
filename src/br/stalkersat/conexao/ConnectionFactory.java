package br.stalkersat.conexao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public java.sql.Connection getConnectionMySQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/stalkersat_db",
					"root", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public java.sql.Connection getConnectionORACLE() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			return DriverManager.getConnection("jdbc:oracle://localhost/stalkersat_db", "root", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}
}
