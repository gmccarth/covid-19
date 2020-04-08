// camel-k: language=java

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

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
      .unmarshal().bindy(BindyType.Csv, JhuCsseDailyReportCsvRecord.class)
      .marshal().json(JsonLibrary.Jackson)
      .to("kafka:jhucsse");
  }

  @XmlRootElement(name="jhu-csse-report")
  @CsvRecord(separator = ",", skipField=true, quote="\"")
  public static class JhuCsseDailyReportCsvRecord {

    @DataField(pos = 2)
    private String admin2;

    @DataField(pos = 3)
    private String provinceState;

    @DataField(pos = 4)
    private String countryRegion;

    @DataField(pos = 5)
    private String lastUpdate;

    @DataField(pos = 8)
    private int confirmedCases;

    @DataField(pos = 9)
    private int deaths;

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

    @XmlElement(name = "country")
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

  }
}
