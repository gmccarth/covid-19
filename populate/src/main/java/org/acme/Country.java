package org.acme;

public class Country {

	private String countryId;
	private String admin2;
    private String country;
    private String lastUpdate;
    private Integer confirmedCases;
    private Integer deaths;
    private String provinceState;

	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getAdmin2() {
		return admin2;
	}
	public void setAdmin2(String admin2) {
		this.admin2 = admin2;
	}
	public String getProvinceState() {
		return provinceState;
	}
	public void setProvinceState(String provinceState) {
		this.provinceState = provinceState;
	}
	public Integer getDeaths() {
		return deaths;
	}
	public void setDeaths(Integer deaths) {
		this.deaths = deaths;
	}
	public Integer getConfirmedCases() {
		return confirmedCases;
	}
	public void setConfirmedCases(Integer confirmedCases) {
		this.confirmedCases = confirmedCases;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}