package br.stalkersat.contato;

import br.stalkersat.tipocontato.TipoContato;
import br.stalkersat.usuario.Usuario;

public class Contato {
	
	private Integer idContato;
	private String telefone;
	private Usuario usuario;
	private TipoContato tipoContato;
	
	public Contato(String telefone, Usuario usuario, TipoContato tipoContato) {
		this.telefone = telefone;
		this.usuario = usuario;
		this.tipoContato = tipoContato;
	}
	
	public Contato(Integer id, String telefone, Usuario usuario, TipoContato tipoContato) {
		this.idContato = id;
		this.telefone = telefone;
		this.usuario = usuario;
		this.tipoContato = tipoContato;
	}
	
	public Contato() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdContato() {
		return idContato;
	}

	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}

	@Override
	public String toString() {
		return "\nId Contato: " + idContato + "\nTelefone: " + telefone + "\nUsuario: " + usuario.getIdUsuario() + " - " + usuario.getNome() + "\nTipo Contato: "
				+ tipoContato.getTipo() + "\n";
	}
	
}
