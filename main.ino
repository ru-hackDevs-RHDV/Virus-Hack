#include <DHT.h>
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <Arduino_JSON.h>
#include <SimpleTimer.h>

#define DHTTYPE DHT22
#define DHTPIN D2

#define WATERING D7

char ssid[] = "ssid"; 
char pass[] = "pass";   

SimpleTimer timer; 

DHT dht(DHTPIN, DHTTYPE);

int humidity = 0;  

int temperature = 0;

void sendUptime(){
  
  humidity = dht.readHumidity();
  
  temperature = dht.readTemperature();

}

void setup() {
  
  Serial.begin(115200);

  WiFi.begin(ssid, pass);

  dht.begin();

  while (WiFi.status() != WL_CONNECTED) {
 
    delay(500);
    Serial.println("Waiting for connection");
 
  }

  timer.setInterval(1500, sendUptime);
}

void loop() {

  timer.run();
  
  if (WiFi.status()== WL_CONNECTED) {
 
   HTTPClient temp;
   HTTPClient humid;
 
   temp.begin("server_url/temperature");
   temp.addHeader("Content-Type", "text/plain");
   int httpCode = temp.POST(temperature);
   String payload = temp.getString();
   Serial.println(httpCode);
   Serial.println(payload);  
   temp.end();

   humid.begin("server_url/humidity");
   humid.addHeader("Content-Type", "text/plain");
   int httpCode = humid.POST(humidity);
   String payload = humid.getString();
   Serial.println(httpCode);
   Serial.println(payload);  
   humid.end();
 
 } else {
 
    Serial.println("Error in WiFi connection");   
 
 }

}