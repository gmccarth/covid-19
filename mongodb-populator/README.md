# Covid Tracker MongoDB populator

Takes data out of Apache Kafka and populates MongoDB with it.

## Trigger OpenShift Build
./mvnw clean package -Dquarkus.container-image.build=true -Dquarkus.kubernetes.deployment-target=openshift -Dquarkus.kubernetes-client.trust-certs=true

## Trigger OpenShift Deployment

./mvnw clean package -Dquarkus.kubernetes.deploy=true -Dquarkus.kubernetes.deployment-target=openshift -Dquarkus.kubernetes-client.trust-certs=true
