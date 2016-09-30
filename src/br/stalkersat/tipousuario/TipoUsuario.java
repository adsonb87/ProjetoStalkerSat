package br.stalkersat.tipousuario;

public class TipoUsuario {

	private Integer idTipoUsuario;
	private String tipo;
	
	 public TipoUsuario(String tipo) {
		this.tipo = tipo;
	}
	 
	public TipoUsuario(Integer id, String tipo) {
		this.idTipoUsuario = id;
		this.tipo = tipo;
	}
	
	public TipoUsuario() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(Integer idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "TipoUsuario [idTipoUsuario=" + idTipoUsuario + ", tipo=" + tipo + "]";
	}
	 
	 
}
