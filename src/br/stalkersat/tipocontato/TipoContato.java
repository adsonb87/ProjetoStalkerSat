package br.stalkersat.tipocontato;

public class TipoContato {
	
	private Integer idTipoContato;
	private String tipo;
	
	public TipoContato(String tipo) {
		this.tipo = tipo;
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
