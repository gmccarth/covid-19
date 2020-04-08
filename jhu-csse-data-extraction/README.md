# John Hopkins University CSSE Covid Data Extractor

## Preprequisites

- AMQ Streams (Apache Kafka) up and running

## Setup

### Create Project on OpenShift

oc new-project jhu-csse

### Create configmap

oc create cm jhu-csse --from-file=application.properties

### Run Camel-K integration

kamel run -d camel-bindy -d camel-jaxb Extractor.java --configmap=jhu-csse

