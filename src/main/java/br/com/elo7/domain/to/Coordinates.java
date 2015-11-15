package br.com.elo7.domain.to;


/**
 * Corresponde a determinada coordenada com base na latitude e longitude
 */
public class Coordinates {

	private Double latitude;
	private Double longitude;

	public Coordinates(Double latitude, Double longitude) {
		this.setLatitude(latitude);
		this.setLongitude(longitude);
	}
	
	public Coordinates() {
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
}