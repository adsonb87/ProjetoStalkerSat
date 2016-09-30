package br.stalkersat.bem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import br.stalkersat.conexao.Conexao;

public class RepositorioBemJDBC implements IRepostorioBem{
	
	private Connection con;
	
	public RepositorioBemJDBC() {
		try {
			con = Conexao.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void cadastrar(Bem bem) {
		
		
	}

	@Override
	public void atualizar(Bem bem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bem procurar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remover(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existe(Integer id) {
		String sql = "select * from bem";
		
		try {
			PreparedStatement pStatement = con.prepareStatement(sql);
			ResultSet rSet = pStatement.executeQuery();
			
			while (rSet.next()){
				if(rSet.getInt(1) == id){
					return true;
				}
			}
			
			pStatement.close();
			rSet.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public ArrayList<Bem> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
