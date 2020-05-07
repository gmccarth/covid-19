package org.acme;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.JhuCsseExtractor.JhuCsseDailyReportCsvRecord;
import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

@ApplicationScoped
public class MongoService {
	
	@Inject MongoClient mongoClient;
	
	public List<JhuCsseDailyReportCsvRecord> list(){
        List<JhuCsseDailyReportCsvRecord> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                JhuCsseDailyReportCsvRecord record = new JhuCsseDailyReportCsvRecord();
                record.setCountryRegion(document.getString("country"));
                list.add(record);
            }
        } finally {
            cursor.close();
        }
        return list;
    }
	
	private MongoCollection getCollection(){
        return mongoClient.getDatabase("covid19").getCollection("covid19");
    }

}
