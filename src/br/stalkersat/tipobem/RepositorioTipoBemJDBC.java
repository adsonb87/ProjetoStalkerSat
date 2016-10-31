package br.stalkersat.tipobem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.print.DocFlavor.READER;

import br.stalkersat.conexao.Conexao;

public class RepositorioTipoBemJDBC implements IRepositorioTIpoBem{
	
	public RepositorioTipoBemJDBC() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void cadastrar(TipoBem tipoBem) {
		if(!existe(tipoBem.getTipo())){
			String sql = "insert into tipo_do_bem (tipo) values (?)";
			
			try {
				Connection con = Conexao.getConnection();
				
				PreparedStatement pStmnt = con.prepareStatement(sql);
				pStmnt.setString(1, tipoBem.getTipo());
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
	public void atualizar(TipoBem tipoBem) {
		if(existe(tipoBem.getTipo())){
		String sql = "update tipo_do_bem set tipo = ? where idTipoBem = ?";
		
			try {
				Connection con = Conexao.getConnection();
				
				PreparedStatement pStmnt = con.prepareStatement(sql);
				pStmnt.setString(1, tipoBem.getTipo());
				pStmnt.setInt(2, tipoBem.getIdTipoBem());
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
	public TipoBem procurar(Integer id) {
		String sql = "select * from tipo_do_bem where idTipoBem = ?";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStmnt = con.prepareStatement(sql);
			pStmnt.setInt(1, id);
			ResultSet resultSet = pStmnt.executeQuery();
			
			if(resultSet.next()){
				return new TipoBem(resultSet.getInt(1), resultSet.getString(2));
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
		String sql = "delete from tipo_do_bem where idTipoBem = ?";
		
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
		String sql = "select * from tipo_do_bem";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStmnt = con.prepareStatement(sql);
			
			ResultSet resultSet = pStmnt.executeQuery();
			
			while(resultSet.next()){
				if(resultSet.getString(2).equalsIgnoreCase(tipo)){
					return true;
				}
			}
			
			resultSet.close();
			pStmnt.close();
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
	public ArrayList<TipoBem> listar() {
		ArrayList<TipoBem> lista = new ArrayList<>();
		
		String sql = "select * from tipo_do_bem";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStmnt= con.prepareStatement(sql);
			
			ResultSet resultSet = pStmnt.executeQuery();
			
			while(resultSet.next()){
				TipoBem tipoBem = new TipoBem(resultSet.getInt(1), resultSet.getString(2));
				
				lista.add(tipoBem);
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
