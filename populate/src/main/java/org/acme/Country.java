package org.acme;

public class Country {

    private String countryId;
    private String countryRegion;
    private String lastUpdate;
    private Integer confirmedCases;
    private Integer deaths;
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
	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}

}