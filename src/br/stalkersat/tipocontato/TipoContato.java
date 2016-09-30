package br.stalkersat.tipocontato;

public class TipoContato {
	
	private Integer idTipoContato;
	private String tipo;
	
	public TipoContato(String tipo) {
		this.tipo = tipo;
	}
	
	public TipoContato(Integer id, String tipo) {
		this.idTipoContato = id;
		this.tipo = tipo;
	}
	
	public TipoContato() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdTipoContato() {
		return idTipoContato;
	}

	public void setIdTipoContato(Integer idTipoContato) {
		this.idTipoContato = idTipoContato;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "TipoContato [idTipoContato=" + idTipoContato + ", tipo=" + tipo + "]";
	}
	
	
}
