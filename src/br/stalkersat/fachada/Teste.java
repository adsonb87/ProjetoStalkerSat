package br.stalkersat.fachada;

import java.util.ArrayList;

import br.stalkersat.endereco.Endereco;
import br.stalkersat.usuario.Usuario;

public class Teste {
	public static void main (String[] args){
		
		Fachada f = Fachada.getInstance();
		
		System.out.println(f.listarBens());
		
	}
}
