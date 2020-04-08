package com.redhat.covid19tracker;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class MongoDbPopulator extends RouteBuilder {

    @ConfigProperty(name = "kafka.brokers") 
    String brokers;

    public void configure() {
        from("kafka:jhucsse?brokers="+brokers)
        .log("message: ${body}");
    }
}

