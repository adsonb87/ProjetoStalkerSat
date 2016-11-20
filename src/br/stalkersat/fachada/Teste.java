package br.stalkersat.fachada;

import java.util.ArrayList;

import br.stalkersat.endereco.Endereco;
import br.stalkersat.usuario.Usuario;

public class Teste {
	public static void main (String[] args){
		
		Fachada f = Fachada.getInstance();
		
		Endereco endereco = new Endereco("1001", "complemento", "Rua 48", "53.221-110");
		
		f.cadastrarEndereco(endereco);
		
		ArrayList<Endereco> listaEndereco = f.listarEndereco();
		
		int indice = 0;
		
		for(int i=0;i<listaEndereco.size();i++){
			
			if(listaEndereco.get(i).getRua().equals(endereco.getRua())){
				
				if(listaEndereco.get(i).getNumero().equalsIgnoreCase(endereco.getNumero())){
					indice = listaEndereco.get(i).getIdEndereco();	
				}
				
			}
		}
		
		Usuario u = new Usuario("123.223.111-22", "Hugo Costa", "hcosta", "1234", f.procurarTipoUsuario(2), f.procurarEndereco(indice));
		
		f.cadastrarUsuario(u);
		
		
		ArrayList<Usuario> listaUsuario = f.listarUsuario();
		
		int indiceUsuario = 0;
		
		for(int i=0; i<listaUsuario.size();i++){
			if(listaUsuario.get(i).getCpf().equalsIgnoreCase(u.getCpf())){
				indiceUsuario = listaUsuario.get(i).getIdUsuario();
			}
		}
		
		System.out.println(indiceUsuario);
		
	}
}
