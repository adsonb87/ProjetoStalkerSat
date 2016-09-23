package br.stalkersat.endereco;

import java.util.ArrayList;

public interface IRepositorioEndereco {
	
	public void cadastrar (Endereco endereco);
	public void atualizar (Endereco endereco);
	public Endereco procurar (Integer id);
	public boolean remover (Integer id);
	public boolean existe (Integer id);
	public ArrayList<Endereco> listar();
}
