package br.stalkersat.contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import br.stalkersat.conexao.Conexao;
import br.stalkersat.tipocontato.RepositorioTipoContatoJDBC;
import br.stalkersat.usuario.RepositorioUsuarioJDBC;

public class RepositorioContatoJDBC implements IRepositorioContato{

	private Connection con;
	
	public RepositorioContatoJDBC() {
		try {
			con = Conexao.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void cadastrar(Contato contato) {
		String sql = "insert into contato (idUsuarioFk, telefone, idTipoContatoFk) values (?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, contato.getUsuario().getIdUsuario());
			ps.setString(2, contato.getTelefone());
			ps.setInt(3, contato.getTipoContato().getIdTipoContato());
			
			ps.execute();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Contato contato) {
		String sql = "update from contato idUsuarioFk = ?, telefone = ?, idTipoContatoFk = ? where idContato = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, contato.getUsuario().getIdUsuario());
			ps.setString(2, contato.getTelefone());
			ps.setInt(3, contato.getTipoContato().getIdTipoContato());
			ps.setInt(4, contato.getIdContato());
			
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Contato procurar(Integer id) {
		String sql = "select * from contato where idContato = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return new Contato(rs.getInt(1), rs.getString(3), new RepositorioUsuarioJDBC().procurar(rs.getInt(2)), new RepositorioTipoContatoJDBC().procurar(rs.getInt(4)));
			}
			
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean remover(Integer id) {
		String sql = "delete from contato idContato = ?";
		
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
	public ArrayList<Contato> listar() {
		ArrayList<Contato> lista = new ArrayList<>();
		
		String sql = "select * from contato";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Contato contato = new Contato(rs.getInt(1), rs.getString(3), new RepositorioUsuarioJDBC().procurar(rs.getInt(2)), new RepositorioTipoContatoJDBC().procurar(rs.getInt(4)));
				
				lista.add(contato);
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
