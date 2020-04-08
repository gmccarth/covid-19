package org.acme;

public class Country {

    private String countryId;
    private String countryRegion;
    private String lastUpdate;
    private String confirmedCases;
    private String deaths;
    private String provinceState;

	public String getCountryRegion() {
		return countryRegion;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getProvinceState() {
		return provinceState;
	}
	public void setProvinceState(String provinceState) {
		this.provinceState = provinceState;
	}
	public String getDeaths() {
		return deaths;
	}
	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}
	public String getConfirmedCases() {
		return confirmedCases;
	}
	public void setConfirmedCases(String confirmedCases) {
		this.confirmedCases = confirmedCases;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}

}