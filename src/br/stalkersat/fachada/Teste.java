package br.stalkersat.fachada;

import br.stalkersat.endereco.Endereco;

public class Teste {

	public static void main(String[] args) {
		Endereco end = new Endereco(439, "complemento", "rua", "53.220-530");
		
		System.out.println(end.formatarCep());

	}

}
