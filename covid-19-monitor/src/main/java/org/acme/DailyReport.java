package org.acme;

import java.time.LocalDate;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection="covid19report")
public class DailyReport extends PanacheMongoEntity{
	public ObjectId id;
	public String country;
	
	public Long reportDate;
	
	public String provinceState;
	public String admin2;
	public int confirmedCases;
	public int deaths;
	


}
