package br.stalkersat.tipousuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import br.stalkersat.conexao.Conexao;

public class RepositorioTipoUsuarioJDBC implements IRepositorioTipoUsuario{
	
	private Connection con;
	
	public RepositorioTipoUsuarioJDBC() {
		try {
			con = Conexao.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void cadastrar(TipoUsuario tipoUsuario) {
		String sql = "insert into tipo_do_usuario (tipo) values (?)";
		
		try {
			PreparedStatement pStmnt = con.prepareStatement(sql);
			pStmnt.setString(1, tipoUsuario.getTipo());
			pStmnt.execute();
			pStmnt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public TipoUsuario procurar(Integer id) {
		String sql = "select * from tipo_do_usuario where idTipoUsuario = ?";
		
		PreparedStatement pStmnt;
		try {
			pStmnt = con.prepareStatement(sql);
			pStmnt.setInt(1, id);
			ResultSet resultSet = pStmnt.executeQuery();
			
			if(resultSet.next()){
				return new TipoUsuario(resultSet.getInt(1), resultSet.getString(2));
			}
			
			pStmnt.close();
			resultSet.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void atualizar(TipoUsuario tipoUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remover(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existe(String tipo) {
		String sql = "select * from bem";
		
		try {
			PreparedStatement pStmnt = con.prepareStatement(sql);
			ResultSet resultSet = pStmnt.executeQuery();
			
			while(resultSet.next()){
				if(resultSet.getString(2).equalsIgnoreCase(tipo)){
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public ArrayList<TipoUsuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
