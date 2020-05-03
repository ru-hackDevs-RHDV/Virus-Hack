from django.contrib import admin
from .models import GrowBox, Light, WaterShare, DHT22

admin.site.register(GrowBox)
admin.site.register(Light)
admin.site.register(WaterShare)
admin.site.register(DHT22)