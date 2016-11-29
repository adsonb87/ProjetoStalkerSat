package br.stalkersat.localizacao;

import br.stalkersat.bem.Bem;

public class Localizacao {
	
	private Integer idLocalizacao;
	private String latitude;
	private String longitude;
	
	public Localizacao(String latitude, String longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Localizacao(Integer id, String latitude, String longitude) {
		this.idLocalizacao = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Localizacao() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "\nLatitude: " + latitude + " / Longitude: " + longitude + "\n";
	}
	
	
}
