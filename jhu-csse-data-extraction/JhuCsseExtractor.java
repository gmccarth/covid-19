// camel-k: language=java

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

public class JhuCsseExtractor extends RouteBuilder {
  @Override
  public void configure() throws Exception {

      from("timer:jhucsse?repeatCount=1")
      .to("https:{{jhu.csse.baseUrl}}/04-06-2020.csv")
      .split().tokenize("\n", 1, true)
      .log("message: ${body}")
      .unmarshal().bindy(BindyType.Csv, JhuCsseDailyReportCsvRecord.class)
      .log("message: ${body}")
      .marshal().json(JsonLibrary.Jackson)
      .log("message: ${body}")
      .to("kafka:jhucsse");
  }

  @XmlRootElement(name="jhu-csse-report")
  @CsvRecord(separator = ",", quote="\"")
  public static class JhuCsseDailyReportCsvRecord {

    @DataField(pos = 1)
    private int fips;

    @DataField(pos = 2)
    private String admin2;

    @DataField(pos = 3)
    private String provinceState;

    @DataField(pos = 4)
    private String countryRegion;

    @DataField(pos = 5)
    private String lastUpdate;

    @DataField(pos = 6)
    private String latitude;

    @DataField(pos = 7)
    private String longitude;

    @DataField(pos = 8)
    private int confirmedCases;

    @DataField(pos = 9)
    private int deaths;

    @DataField(pos = 10)
    private int recovered;

    @DataField(pos = 11)
    private int active;

    @DataField(pos = 12)
    private String combinedKey;

    public int getFips() {
      return fips;
    }

    public void setFips(int fips) {
      this.fips = fips;
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

    public String getCountryRegion() {
      return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
      this.countryRegion = countryRegion;
    }

    public String getLastUpdate() {
      return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
      this.lastUpdate = lastUpdate;
    }

    public String getLatitude() {
      return latitude;
    }

    public void setLatitute(String latitude) {
      this.latitude = latitude;
    }

    public String getLongitude() {
      return longitude;
    }

    public void setLongitute(String longitude) {
      this.longitude = longitude;
    }

    public int getConfirmedCases() {
      return confirmedCases;
    }

    public void setConfirmedCases(int confirmedCases) {
      this.confirmedCases = confirmedCases;
    }

    public int getDeaths() {
      return deaths;
    }

    public void setDeats(int deaths) {
      this.deaths = deaths;
    }

    public int getRecovered() {
      return recovered;
    }

    public void setRecovered(int recovered) {
      this.recovered = recovered;
    }

    public int getActive() {
      return active;
    }

    public void setActive( int active) {
      this.active = active;
    }

    public String getCombinedKey() {
      return combinedKey;
    }

    public void setCombinedKey(String combinedKey) {
      this.combinedKey = combinedKey;
    }
  }
}
