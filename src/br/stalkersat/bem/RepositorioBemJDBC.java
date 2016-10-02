package br.stalkersat.bem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import br.stalkersat.conexao.Conexao;
import br.stalkersat.tipobem.RepositorioTipoBemJDBC;
import br.stalkersat.tipobem.TipoBem;
import br.stalkersat.usuario.RepositorioUsuarioJDBC;
import br.stalkersat.usuario.Usuario;

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
			String sql = "insert into bem (idUsuarioFk, chassi, placa, idTipoBemFk) values (?,?,?,?)";
			
			try {
				PreparedStatement pStmnt = con.prepareStatement(sql);
				
				pStmnt.setInt(1, bem.getUsuario().getIdUsuario());
				pStmnt.setString(2, bem.getChassi());
				pStmnt.setString(3, bem.getPlaca());
				pStmnt.setInt(4, bem.getTipoBem().getIdTipoBem());
				
				pStmnt.execute();
				con.close();
				pStmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void atualizar(Bem bem) {
			String sql = "update bem set idUsuarioFk = ?, chassi = ?, placa = ?, idTipoBemFk = ? where idBem = ?";
			
			try {
				PreparedStatement pStmnt = con.prepareStatement(sql);
				
				pStmnt.setInt(1, bem.getUsuario().getIdUsuario());
				pStmnt.setString(2, bem.getChassi());
				pStmnt.setString(3, bem.getPlaca());
				pStmnt.setInt(4, bem.getTipoBem().getIdTipoBem());
				pStmnt.setInt(5, bem.getIdBem());
				
				pStmnt.executeUpdate();
				pStmnt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	@Override
	public Bem procurar(Integer id) {
		String sql = "select * from bem where idBem = ?";
		
		try {
			PreparedStatement pStmnt = con.prepareStatement(sql);
			pStmnt.setInt(1, id);
			ResultSet resultSet = pStmnt.executeQuery();
			
			if(resultSet.next()){
				return new Bem(resultSet.getInt(1), resultSet.getString(3), resultSet.getString(4), new RepositorioTipoBemJDBC().procurar(resultSet.getInt(5)), new RepositorioUsuarioJDBC().procurar(resultSet.getInt(2)));
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
	public boolean remover(Integer id) {
		String sql = "delete from bem where idBem = ?";
		
		try {
			PreparedStatement pStmnt = con.prepareStatement(sql);
			pStmnt.setInt(1, id);
			
			pStmnt.executeUpdate();
			pStmnt.close();
			con.close();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean existe(String chassi) {
		String sql = "select * from bem";
		
		try {
			PreparedStatement pStatement = con.prepareStatement(sql);
			ResultSet rSet = pStatement.executeQuery();
			
			while (rSet.next()){
				if(rSet.getString("chassi").equalsIgnoreCase(chassi)){
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
		ArrayList<Bem> listaBem = new ArrayList<>();
		
		String sql = "select * from bem";
		
		try {
			PreparedStatement pStmnt = con.prepareStatement(sql);
			
			ResultSet resultSet = pStmnt.executeQuery();
			
			while(resultSet.next()){
				Bem bem = new Bem();
				
				bem.setIdBem(resultSet.getInt(1));
				bem.setChassi(resultSet.getString(3));
				bem.setPlaca(resultSet.getString(4));
				bem.setUsuario(new RepositorioUsuarioJDBC().procurar(resultSet.getInt(2)));
				bem.setTipoBem(new RepositorioTipoBemJDBC().procurar(resultSet.getInt(5)));
				
				listaBem.add(bem);
			}
			
			pStmnt.close();
			con.close();
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaBem;
	}

}
