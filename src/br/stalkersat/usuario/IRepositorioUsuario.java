package br.stalkersat.usuario;

import java.util.ArrayList;

public interface IRepositorioUsuario {
	
	public void cadastrar(Usuario usuario);
	public Usuario procurar(Integer id);
	public void atualizar (Usuario usuario);
	public boolean remover (Integer id);
	public boolean existe(String cpf);
	public ArrayList<Usuario> listar();
	
}
