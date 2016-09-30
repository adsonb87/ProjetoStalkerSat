package br.stalkersat.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.stalkersat.conexao.Conexao;

public class RepositorioUsuarioJDBC implements IRepositorioUsuario{
	
	private Connection con;
	
	public RepositorioUsuarioJDBC() {
		try {
			con = Conexao.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void cadastrar(Usuario usuario) {
		if(!existe(usuario.getCpf())){
			String sql = "insert into usuario (idEnderecoFk, cpf, nome, login, senha, idTipoUsuarioFk) values (?,?,?,?,?,?)";
			
			try {
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
			}
			
		}
		
	}

	@Override
	public Usuario procurar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remover(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existe(String cpf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
