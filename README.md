# Android-Tutorial

1) BasicActivitySwitch - Creating two simple activities, reading the data from activity one and passing the same data as an intent to the next activity.
2) REST API using Volley library(Written over HTTP Library)
Note : For excluding the duplicate entry use this.
implementation 'com.android.volley:volley:1.1.1'
    android{
        configurations {
            all*.exclude group: 'com.android.volley'
        }}
3) For java.lang.NoClassDefFoundError:failed resolution of :Lorg/apache/http/ProtocolVersion
Add this to your AndroidManifest.xml inside the <application> tag:
<uses-library android:name="org.apache.http.legacy" android:required="false" />
