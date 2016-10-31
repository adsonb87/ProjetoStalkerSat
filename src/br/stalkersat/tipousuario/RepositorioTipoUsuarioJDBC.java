package br.stalkersat.tipousuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import br.stalkersat.conexao.Conexao;

public class RepositorioTipoUsuarioJDBC implements IRepositorioTipoUsuario{
	
	public RepositorioTipoUsuarioJDBC() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void cadastrar(TipoUsuario tipoUsuario) {
		String sql = "insert into tipo_do_usuario (tipo) values (?)";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStmnt = con.prepareStatement(sql);
			pStmnt.setString(1, tipoUsuario.getTipo());
			pStmnt.execute();
			pStmnt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public TipoUsuario procurar(Integer id) {
		String sql = "select * from tipo_do_usuario where idTipoUsuario = ?";
		
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStmnt = con.prepareStatement(sql);
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void atualizar(TipoUsuario tipoUsuario) {
		String sql = "update tipo_do_usuario set tipo = ? where idTipoUsuario = ?";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStmnt = con.prepareStatement(sql);
			pStmnt.setString(1, tipoUsuario.getTipo());
			pStmnt.setInt(2, tipoUsuario.getIdTipoUsuario());
			pStmnt.executeUpdate();
			pStmnt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean remover(Integer id) {
		String sql = "delete from tipo_do_usuario where idTipoUsuario = ?";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStmnt = con.prepareStatement(sql);
			pStmnt.setInt(1, id);
			pStmnt.executeUpdate();
			pStmnt.close();
			con.close();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean existe(String tipo) {
		String sql = "select * from tipo_do_usuario";
		
		try {
			Connection con = Conexao.getConnection();
			
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public ArrayList<TipoUsuario> listar() {
		ArrayList<TipoUsuario> lista = new ArrayList<>();
				
		String sql = "select * from tipo_do_usuario";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStmnt = con.prepareStatement(sql);
			
			ResultSet resultSet = pStmnt.executeQuery();
			
			while(resultSet.next()){
				TipoUsuario tipoUsuario = new TipoUsuario(resultSet.getInt(1), resultSet.getString(2));
				lista.add(tipoUsuario);
			}
			
			pStmnt.close();
			con.close();
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

}
