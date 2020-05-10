package org.acme;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

@ApplicationScoped
public class ReportRepository implements PanacheMongoRepository<DailyReport> {
	
	public DailyReport findByCountry(String country) {
		return find("country = ?1 and reportDate = ?2", country, LocalDate.of(2020,5,8)).firstResult();
	}
	public List<DailyReport> findAllReportsForCountry(String country){
		return list("country", country);
	}

}
