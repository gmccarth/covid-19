// camel-k: language=java

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;
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
      .log("message: hello ${body}")
      .to("kafka:jhucsse");
  }

  @XmlRootElement(name="jhu-csse-report")
  @XmlAccessorType(XmlAccessType.PROPERTY)
  @CsvRecord(separator = ",")
  public static class JhuCsseDailyReportCsvRecord {

    @DataField(pos = 1)
    @XmlElement
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
  }
}
