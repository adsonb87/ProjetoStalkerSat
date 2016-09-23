package br.stalkersat.localizacao;

import java.util.ArrayList;

public interface IRepositorioLocalizacao {
	
	public void cadastrar (Localizacao localizacao);
	public void atualizar (Localizacao localizacao);
	public Localizacao procurar (Integer id);
	public boolean remover (Integer id);
	public boolean existe (Integer id);
	public ArrayList<Localizacao> listar ();
	
}
