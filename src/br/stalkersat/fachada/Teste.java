package br.stalkersat.fachada;

import br.stalkersat.bem.Bem;
import br.stalkersat.localizacao.Localizacao;
import br.stalkersat.tipobem.TipoBem;
import br.stalkersat.tipocontato.TipoContato;
import br.stalkersat.tipousuario.TipoUsuario;

public class Teste {
	public static void main (String[] args){
		
		Fachada f = Fachada.getInstance();
		
		TipoContato contato = new TipoContato("Fixo");
		
		TipoContato contato2 = new TipoContato("Celular");
		
		f.cadastrarTipoContato(contato);
		f.cadastrarTipoContato(contato2);
		
		
		
	}
}
