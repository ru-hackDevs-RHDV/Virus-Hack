from django.contrib import admin
from django.urls import include, path
from .views import index, set_grow_box, add_light_to_grow_box,\
     add_DHT22_to_grow_box, add_WaterShare_to_grow_box, get_all_information,\
         pomp_action, light_action

#http://127.0.0.1:8000/main/set_gb?grow_box_id=10000
#http://127.0.0.1:8000/main/add_l?grow_box_id=10000
urlpatterns = [
    path('', index, name='main_page'),
    path('set_grow_box/', set_grow_box, name='main_page'),
    path('add_light/', add_light_to_grow_box, name='main_page'),
    path('add_DHT/', add_DHT22_to_grow_box, name='main_page'),
    path('account/', index, name='account'),
    path('get_all/', get_all_information, name='get_all_information'),
    path('add_W/', add_WaterShare_to_grow_box, name='main_page'),
    path('pomp_action/', pomp_action, name='pomp_action'),
    path('light_action/', light_action, name='light_action'),
]