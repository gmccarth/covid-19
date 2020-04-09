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

        MongoCursor<Document> cursor = getCollection().find().sort(new BasicDBObject("lastUpdate",1)).iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Country country = new Country();
                country.setAdmin2(document.getString("admin2"));
                country.setCountryId(document.getString("countryId"));
                country.setCountry(document.getString("country"));
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

    private MongoCollection<Document> getCollection(){
        return mongoClient.getDatabase("country").getCollection("country");
    }

    public List<Country> getByCountryAndProvinceState(String country, String provinceState){
        List<Country> list = new ArrayList<>();
        MongoCollection<Document> collection = mongoClient.getDatabase("country").getCollection("country");
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("country", country);
        whereQuery.put("provinceState", provinceState);
        MongoCursor<Document> cursor = collection.find(whereQuery).sort(new BasicDBObject("lastUpdate",1)).iterator();
        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Country object = new Country();
                object.setAdmin2(document.getString("admin2"));
                object.setCountryId(document.getString("countryId"));
                object.setCountry(document.getString("country"));
                object.setLastUpdate(document.getString("lastUpdate"));
                object.setConfirmedCases(document.getInteger("confirmedCases"));
                object.setDeaths(document.getInteger("deaths"));
                object.setProvinceState(document.getString("provinceState"));
                list.add(object);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public List<Country> getByCountry(String country){
        List<Country> list = new ArrayList<>();
        MongoCollection<Document> collection = mongoClient.getDatabase("country").getCollection("country");
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("country", country);
        MongoCursor<Document> cursor = collection.find(whereQuery).iterator();
        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Country object = new Country();
                object.setAdmin2(document.getString("admin2"));
                object.setCountryId(document.getString("countryId"));
                object.setCountry(document.getString("country"));
                object.setLastUpdate(document.getString("lastUpdate"));
                object.setConfirmedCases(document.getInteger("confirmedCases"));
                object.setDeaths(document.getInteger("deaths"));
                object.setProvinceState(document.getString("provinceState"));
                list.add(object);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public void add(Country country){

        Document document = new Document()
                .append("countryId", country.getCountryId())
                .append("setAdmin2", country.getAdmin2())
                .append("country", country.getCountry())
                .append("lastUpdate", country.getLastUpdate())
                .append("confirmedCases", country.getConfirmedCases())
                .append("deaths", country.getDeaths())
                .append("provinceState", country.getProvinceState());
        getCollection().insertOne(document);
    }

    public void delete(){
        MongoCollection<Document> assassinColl = mongoClient.getDatabase("country").getCollection("country");
        BasicDBObject theQuery = new BasicDBObject();
        theQuery.put("countryId", "1");
        DeleteResult result = assassinColl.deleteMany(theQuery);
        System.out.println("The Numbers of Deleted Document(s) : " + result.getDeletedCount());
    }

}