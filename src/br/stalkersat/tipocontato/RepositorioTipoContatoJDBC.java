package br.stalkersat.tipocontato;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import br.stalkersat.conexao.Conexao;

public class RepositorioTipoContatoJDBC implements IRepositorioTipoContato{
	
	public RepositorioTipoContatoJDBC() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void cadastrar(TipoContato tipoContato) {
		if(!existe(tipoContato.getTipo())){
			String sql = "insert into tipo_do_contato (tipo) values (?)";
			
			try {
				Connection con = Conexao.getConnection();
				
				PreparedStatement pStmnt = con.prepareStatement(sql);
				pStmnt.setString(1, tipoContato.getTipo());
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
	}

	@Override
	public void atualizar(TipoContato tipoContato) {
		if(existe(tipoContato.getTipo())){
			String sql = "update tipo_do_contato set tipo = ? where idTipoContato = ?";
			
			try {
				Connection con = Conexao.getConnection();
				
				PreparedStatement pStmnt = con.prepareStatement(sql);
				pStmnt.setString(1, tipoContato.getTipo());
				pStmnt.setInt(2, tipoContato.getIdTipoContato());
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
		
	}

	@Override
	public TipoContato procurar(Integer id) {
		String sql = "select * from tipo_do_contato where idTipoContato = ?";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStmnt = con.prepareStatement(sql);
			pStmnt.setInt(1, id);
			ResultSet resultSet = pStmnt.executeQuery();
			
			if(resultSet.next()){
				return new TipoContato(resultSet.getInt(1), resultSet.getString(2));
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
	public boolean remover(Integer id) {
		String sql = "delete from tipo_do_contato where idTipoContato = ?";
		
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
		String sql = "select * from tipo_do_contato";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement  pStmnt = con.prepareStatement(sql);
			
			ResultSet resultSet = pStmnt.executeQuery();
			
			while(resultSet.next()){
				if(resultSet.getString(2).equalsIgnoreCase(tipo)){
					return true;
				}
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
		return false;
	}

	@Override
	public ArrayList<TipoContato> listar() {
		ArrayList<TipoContato> lista = new ArrayList<>();
		
		String sql = "select * from tipo_do_contato";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStatement = con.prepareStatement(sql);
			
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()){
				TipoContato tipoContato = new TipoContato(resultSet.getInt(1), resultSet.getString(2));
				
				lista.add(tipoContato);
			}
			
			pStatement.close();
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
