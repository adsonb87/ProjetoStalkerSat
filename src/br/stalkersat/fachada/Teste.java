package br.stalkersat.fachada;

import br.stalkersat.bem.Bem;
import br.stalkersat.bem.ControladorBem;
import br.stalkersat.bem.RepositorioBemJDBC;
import br.stalkersat.contato.ControladorContato;
import br.stalkersat.contato.RepositorioContatoJDBC;
import br.stalkersat.endereco.ControladorEndereco;
import br.stalkersat.tipobem.ControladorTipoBem;
import br.stalkersat.tipobem.TipoBem;
import br.stalkersat.usuario.ControladorUsuario;
import br.stalkersat.usuario.Usuario;

public class Teste {
	
	public static void main(String[] args){
	
		ControladorBem cBem = ControladorBem.getInstance();
		ControladorContato cContato = ControladorContato.getInstance();
		ControladorEndereco cEndereco = ControladorEndereco.getInstance();
		ControladorUsuario cUsuario = ControladorUsuario.getInstance();
		ControladorTipoBem cTipoBem = ControladorTipoBem.getInstance();
		
		TipoBem tipoBem = cTipoBem.procurarTipoBem(1);
		Usuario usuario = cUsuario.procurarUsuario(2);
		
		RepositorioBemJDBC r = new RepositorioBemJDBC();
		
		Bem bem = new Bem();
		bem.setChassi("chassi");
		bem.setTipoBem(tipoBem);
		bem.setUsuario(usuario);
		bem.setPlaca("kgh3720");
		bem.setIdBem(1);
		
		r.atualizar(bem);
		
		
		
		System.out.println(r.procurar(1));
		
		
	}
}
