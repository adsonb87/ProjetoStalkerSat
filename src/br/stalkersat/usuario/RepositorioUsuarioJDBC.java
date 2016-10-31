package br.stalkersat.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import br.stalkersat.conexao.Conexao;
import br.stalkersat.endereco.RepositorioEnderecoJDBC;
import br.stalkersat.tipousuario.RepositorioTipoUsuarioJDBC;

public class RepositorioUsuarioJDBC implements IRepositorioUsuario{
	
	public RepositorioUsuarioJDBC() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void cadastrar(Usuario usuario) {
		if(!existe(usuario.getCpf())){
			String sql = "insert into usuario (idEnderecoFk, cpf, nome, login, senha, idTipoUsuarioFk) values (?,?,?,?,?,?)";
			
			try {
				Connection con = Conexao.getConnection();
				
				PreparedStatement pStmnt = con.prepareStatement(sql);
				pStmnt.setInt(1, usuario.getEndereco().getIdEndereco());
				pStmnt.setString(2, usuario.getCpf());
				pStmnt.setString(3, usuario.getNome());
				pStmnt.setString(4, usuario.getLogin());
				pStmnt.setString(5, usuario.getSenha());
				pStmnt.setInt(6, usuario.getTipoUsuario().getIdTipoUsuario());
				
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
	public Usuario procurar(Integer id) {
		String sql = "select * from usuario where idUsuario = ?";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStmnt = con.prepareStatement(sql);
			pStmnt.setInt(1, id);
			ResultSet resultSet = pStmnt.executeQuery();
			
			if(resultSet.next()){
				return new Usuario(resultSet.getInt(1), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), new RepositorioTipoUsuarioJDBC().procurar(resultSet.getInt(7)), new RepositorioEnderecoJDBC().procurar(resultSet.getInt(2)));
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
	public void atualizar(Usuario usuario) {
		if(existe(usuario.getCpf())){
			String sql = "update usuario nome = ?, cpf = ?, login = ?, senha = ?, idTipoUsuarioFk = ? where idUsuario = ?";
			
			try {
				Connection con = Conexao.getConnection();
				
				PreparedStatement pStmnt = con.prepareStatement(sql);
				pStmnt.setString(1, usuario.getNome());
				pStmnt.setString(2, usuario.getCpf());
				pStmnt.setString(3, usuario.getLogin());
				pStmnt.setString(4, usuario.getSenha());
				pStmnt.setInt(5, usuario.getTipoUsuario().getIdTipoUsuario());
				pStmnt.setInt(6, usuario.getIdUsuario());
				
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
	public boolean remover(Integer id) {
		
		Usuario usuario = procurar(id);
		
		String sql = "delete from usuario where idUsuario = ?";
		String sql2 = "delete from contato where idUsuarioFk = ?";
		String sql3 = "delete from bem where idUsuarioFk = ?";
		String sql4 = "delete from endereco where idEndereco = ?";
				
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStmnt = con.prepareStatement(sql);
			pStmnt.setInt(1, id);
			pStmnt.executeUpdate();
			pStmnt.close();
			
			PreparedStatement pStmnt2 = con.prepareStatement(sql2);
			pStmnt2.setInt(1, id);
			pStmnt2.executeUpdate();
			pStmnt2.close();
			
			PreparedStatement pStmnt3 = con.prepareStatement(sql3);
			pStmnt3.setInt(1, id);
			pStmnt3.executeUpdate();
			pStmnt3.close();
			
			PreparedStatement pStmnt4 = con.prepareStatement(sql4);
			pStmnt4.setInt(1, usuario.getEndereco().getIdEndereco());
			pStmnt4.executeUpdate();
			pStmnt4.close();
			
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
	public boolean existe(String cpf) {
		String sql = "select * from usuario";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStmnt = con.prepareStatement(sql);
			
			ResultSet resultSet = pStmnt.executeQuery();
			
			while(resultSet.next()){
				if(resultSet.getString(3).equals(cpf));
				return true;
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
	public ArrayList<Usuario> listar() {
		ArrayList<Usuario> lista = new ArrayList<>();
		
		String sql = "select * from usuario";
		
		try {
			Connection con = Conexao.getConnection();
			
			PreparedStatement pStmnt = con.prepareStatement(sql);
			
			ResultSet resultSet = pStmnt.executeQuery();
			
			while(resultSet.next()){
				Usuario usuario = new Usuario();
				
				usuario.setCpf(resultSet.getString(3));
				usuario.setNome(resultSet.getString(4));
				usuario.setIdUsuario(resultSet.getInt(1));
				usuario.setLogin(resultSet.getString(5));
				usuario.setSenha(resultSet.getString(6));
				usuario.setTipoUsuario(new RepositorioTipoUsuarioJDBC().procurar(resultSet.getInt(7)));
				usuario.setEndereco(new RepositorioEnderecoJDBC().procurar(resultSet.getInt(2)));
				
				lista.add(usuario);
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
		
		return lista;
	}

}
