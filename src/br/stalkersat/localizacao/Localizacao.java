package br.stalkersat.localizacao;

import br.stalkersat.bem.Bem;

public class Localizacao {
	
	private Integer idLocalizacao;
	private String latitude;
	private String longitude;
	private Bem bem;
	
	public Localizacao(String latitude, String longitude, Bem bem) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.bem = bem;
	}

	public Integer getIdLocalizacao() {
		return idLocalizacao;
	}

	public void setIdLocalizacao(Integer idLocalizacao) {
		this.idLocalizacao = idLocalizacao;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Bem getBem() {
		return bem;
	}

	public void setBem(Bem bem) {
		this.bem = bem;
	}

	@Override
	public String toString() {
		return "Localizacao [idLocalizacao=" + idLocalizacao + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", bem=" + bem + "]";
	}
	
	
}
