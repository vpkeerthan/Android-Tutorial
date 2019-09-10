# Android-Tutorial

1) BasicActivitySwitch - Creating two simple activities, reading the data from activity one and passing the same data as an intent to the next activity.
2) REST API using Volley library(Written over HTTP Library)
Note : For excluding the duplicate entry use this.
implementation 'com.android.volley:volley:1.1.1'
    android{
        configurations {
            all*.exclude group: 'com.android.volley'
        }}

3) Kafka-REST-Android - Creating an Android application that uses kafka for data transmission, please find the below link for the REST end points exposed for kafka services
https://github.com/vpkeerthan/Kafka/tree/master/KafkaRestService
