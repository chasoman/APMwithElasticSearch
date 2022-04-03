#!/bin/sh

echo "##################### BEGIN ##########################"
echo "This script creates the following applications "
echo "  * travelpedia-paxbooking"
echo "  * travelpedia-paxdetails"
echo "  * travelpedia-paxsearch"
echo " travelpedia-paxsearch will be exposed as a route"
echo " it integrates with the other applications to get data"
echo "#############"
echo "Creating travelpedia-paxbooking"
echo "#############"
echo "The source to image strategy will be used where the source is - "
echo "    https://github.com/chasoman/APMwithElasticSearch/paxbooking"
echo "The s2i builder image is - java:11"
echo "The script assumes that oc cli is installed, logged into OCP4 and connected to a project"
oc new-app \
--name travelpedia-paxbooking \
java:11~https://github.com/chasoman/APMwithElasticSearch \
--context-dir paxbooking \
--as-deployment-config
echo "#############"
echo "Creating travelpedia-paxdetails"
echo "#############"
echo "The source to image strategy will be used where the source is - "
echo "    https://github.com/chasoman/APMwithElasticSearch/paxdetails"
echo "The s2i builder image is - java:11"
echo "The script assumes that oc cli is installed, logged into OCP4 and connected to a project"
oc new-app \
--name travelpedia-paxdetails \
java:11~https://github.com/chasoman/APMwithElasticSearch \
--context-dir paxdetails \
--as-deployment-config
echo "#############"
echo "Creating travelpedia-paxsearch"
echo "#############"
echo "The source to image strategy will be used where the source is - "
echo "    https://github.com/chasoman/APMwithElasticSearch/paxsearch"
echo "The s2i builder image is - java:11"
echo "The script assumes that oc cli is installed, logged into OCP4 and connected to a project"
oc new-app \
--name travelpedia-paxsearch \
java:11~https://github.com/chasoman/APMwithElasticSearch \
--context-dir paxsearch \
--as-deployment-config \
-e PAX_DETAILS_HOST_PORT='${TRAVELPEDIA_PAXDETAILS_SERVICE_HOST}':8080 \
-e PAX_BOOKING_HOST_PORT='${TRAVELPEDIA_PAXBOOKING_SERVICE_HOST}':8080
echo "#############"
echo "Exposing travelpedia-paxsearch"
echo "#############"
oc expose svc/travelpedia-paxsearch
oc get routes
