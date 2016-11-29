package br.stalkersat.fachada;

import java.sql.Connection;
import java.util.ArrayList;

import br.stalkersat.conexao.ConnectionFactory;
import br.stalkersat.contato.Contato;
import br.stalkersat.endereco.Endereco;
import br.stalkersat.exceptions.ErrorException;
import br.stalkersat.usuario.Usuario;
import br.stalkersat.usuario.UsuarioProxy;

public class Teste {
	public static void main (String[] args){
		
Fachada fachada = Fachada.getInstance();
		
		System.out.println(ConnectionFactory.getConnectionORACLE());
		
	}
}
