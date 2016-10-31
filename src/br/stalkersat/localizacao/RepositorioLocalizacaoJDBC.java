package br.stalkersat.localizacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import br.stalkersat.conexao.Conexao;

public class RepositorioLocalizacaoJDBC implements IRepositorioLocalizacao{
	
	public RepositorioLocalizacaoJDBC() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void cadastrar(Localizacao localizacao) {
		String sql = "insert into localizacao (latitude, longitude) values (?,?)";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStmnt = con.prepareStatement(sql);
			pStmnt.setString(1, localizacao.getLatitude());
			pStmnt.setString(2, localizacao.getLongitude());
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
	public void atualizar(Localizacao localizacao) {
		String sql = "udate localizacao set latitude = ?, longitude = ? where idLocalizaco = ?";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStmnt = con.prepareStatement(sql);
			pStmnt.setString(1, localizacao.getLatitude());
			pStmnt.setString(2, localizacao.getLongitude());
			pStmnt.setInt(3, localizacao.getIdLocalizacao());
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
	public Localizacao procurar(Integer id) {
		String sql = "select * from localizacao where idLocalizacao = ?";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStmnt = con.prepareStatement(sql);
			pStmnt.setInt(1, id);
			
			ResultSet resultSet = pStmnt.executeQuery();
			
			if(resultSet.next()){
				return new Localizacao(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
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
		
		return null;
	}

	@Override
	public boolean remover(Integer id) {
		String sql = "delete from localizacao where idLocalizacao = ?";
		
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
	public boolean existe(Integer id) {
		return false;
	}

	@Override
	public ArrayList<Localizacao> listar() {
		ArrayList<Localizacao> lista = new ArrayList<>();
		
		String sql = "select * from localizacao";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStmnt = con.prepareStatement(sql);
			
			ResultSet resultSet = pStmnt.executeQuery();
			
			while(resultSet.next()){
				Localizacao localizacao = new Localizacao(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
				
				lista.add(localizacao);
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
