from django.contrib import admin
from .models import GrowBox, Light, WaterShare, DHT22, humidity_of_earth, temperature, CO2

admin.site.register(GrowBox)
admin.site.register(Light)
admin.site.register(WaterShare)
admin.site.register(DHT22)
admin.site.register(humidity_of_earth)
admin.site.register(temperature)
admin.site.register(CO2)