package org.acme;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;

import org.bson.Document;

@ApplicationScoped
public class CountryService {

    @Inject MongoClient mongoClient;

    public List<Country> list(){

        List<Country> list = new ArrayList<>();

        MongoCursor<Document> cursor = getCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Country country = new Country();
                country.setCountryId(document.getString("countryId"));
                country.setCountryRegion(document.getString("countryRegion"));
                country.setLastUpdate(document.getString("lastUpdate"));
                country.setConfirmedCases(document.getInteger("confirmedCases"));
                country.setDeaths(document.getInteger("deaths"));
                country.setProvinceState(document.getString("provinceState"));
                list.add(country);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public void add(Country country){

        Document document = new Document()
                .append("countryId", country.getCountryId())
                .append("countryRegion", country.getCountryRegion())
                .append("lastUpdate", country.getLastUpdate())
                .append("confirmedCases", country.getConfirmedCases())
                .append("deaths", country.getDeaths())
                .append("provinceState", country.getProvinceState());
        getCollection().insertOne(document);
    }

    private MongoCollection<Document> getCollection(){
        return mongoClient.getDatabase("country").getCollection("country");
    }

    public void delete(){
        MongoCollection<Document> assassinColl = mongoClient.getDatabase("country").getCollection("country");
        BasicDBObject theQuery = new BasicDBObject();
        theQuery.put("countryId", "1");
        DeleteResult result = assassinColl.deleteMany(theQuery);
        System.out.println("The Numbers of Deleted Document(s) : " + result.getDeletedCount());
    }

}