package br.stalkersat.endereco;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.stalkersat.conexao.Conexao;

public class RepositorioEnderecoJDBC implements IRepositorioEndereco{
	
	private Connection con;
	
	public RepositorioEnderecoJDBC() {
		try {
			con = Conexao.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void cadastrar(Endereco endereco) {
		String sql = "insert into endereco (numero, complemento, rua, cep) values (?,?,?,?)";
		
		try {
			PreparedStatement pStmnt = con.prepareStatement(sql);
			pStmnt.setString(1, endereco.getNumero());
			pStmnt.setString(2, endereco.getComplemento());
			pStmnt.setString(3, endereco.getRua());
			pStmnt.setString(4, endereco.formatarCep());
			
			pStmnt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Endereco endereco) {
		String sql = "update endereco set numero = ?, complemento = ?, rua = ?, cep = ? where idEndereco = ?";
		
		try {
			PreparedStatement pStmnt = con.prepareStatement(sql);
			pStmnt.setString(1, endereco.getNumero());
			pStmnt.setString(2, endereco.getComplemento());
			pStmnt.setString(3, endereco.getRua());
			pStmnt.setString(4, endereco.formatarCep());
			pStmnt.setInt(5, endereco.getIdEndereco());
			
			pStmnt.executeUpdate();
			pStmnt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public Endereco procurar(Integer id) {
		String sql = "select * from endereco where idEndereco = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()){
				return new Endereco(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
			}
			
			resultSet.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean remover(Integer id) {
		String sql = "delete from endereco where idEndereco = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean existe(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Endereco> listar() {
		ArrayList<Endereco> lista = new ArrayList<>();
		
		String sql = "select * from endereco";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Endereco endereco = new Endereco(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				
				lista.add(endereco);
			}
			
			ps.close();
			con.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lista;
	}
	
	
}
