from django.contrib import admin
from django.urls import include, path
from .views import index, set_grow_box, add_light_to_grow_box,\
     add_DHT22_to_grow_box, add_WaterShare_to_grow_box

#http://127.0.0.1:8000/main/set_gb?grow_box_id=10000
#http://127.0.0.1:8000/main/add_l?grow_box_id=10000
urlpatterns = [
    path('', index, name='main_page'),
    path('set_gb/', set_grow_box, name='main_page'),
    path('add_l/', add_light_to_grow_box, name='main_page'),
    path('add_DHT/', add_DHT22_to_grow_box, name='main_page'),
    path('accaunt/', index, name='accaunt'),
    path('add_W/', add_WaterShare_to_grow_box, name='main_page'),
]