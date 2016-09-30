package br.stalkersat.fachada;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.stalkersat.bem.RepositorioBemJDBC;
import br.stalkersat.conexao.Conexao;
import br.stalkersat.tipousuario.IRepositorioTipoUsuario;
import br.stalkersat.tipousuario.RepositorioTipoUsuarioJDBC;
import br.stalkersat.tipousuario.TipoUsuario;

public class Teste {
	
	public static void main(String[] args){
	
		RepositorioBemJDBC repo = new RepositorioBemJDBC();
		
		System.out.println(repo.procurar(10));
		
		
		
		
	}
}
