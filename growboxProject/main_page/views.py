from django.shortcuts import render
from django.contrib.auth import get_user_model
from django.shortcuts import render, get_object_or_404
from django.contrib.auth.decorators import login_required
from .models import Light, WaterShare, DHT22, GrowBox, temperature, CO2, humidity_of_earth
from accounts.models import Person
from django.http import HttpResponseRedirect
from django.http import JsonResponse


def find_grow_box(_user):
    _person = Person.objects.get(user=_user)
    needed_gr = [i for i in _person.grow_box.all() if i.ident == int(request.GET['grow_box_id'])]
    if len(needed_gr) == 1:
        return needed_gr[0]
    else:
        print('NOT ONLY ONE GROW BOX WITH THIS IDENT')
    return False

def get_info(grow_box):
    light = grow_box._light.info()
    DHT22 = grow_box._DHT22.info()
    WaterShare = grow_box._WaterShare.info()
    CO2 = grow_box._CO2.info()
    humidity_of_earth = grow_box._humidity_of_earth.info()
    temperature = grow_box._temperature.info()
    return {
        'light': light,
        'DHT22': DHT22,
        'WaterShare': WaterShare,
        'CO2': CO2,
        'humidity_of_earth': humidity_of_earth,
        'temperature': temperature,
    }

@login_required(login_url='/auth/login/')
def index(request):
    person = Person.objects.get(user=request.user)
    gr_id = [i for i in person.grow_box.all()]
    content = {
            'name': request.user.username,
            'grow_box_id': gr_id,
    }
    return render(request,'index.html', context=content)


#Добавление новой Теплицы
@login_required(login_url='/auth/login/')
def set_grow_box(request):
    if request.method == 'GET':
        person = Person.objects.get(user=request.user)
        person.set_grow_box(request.GET['grow_box_id'])
        add_DHT22_to_grow_box(request)
        add_light_to_grow_box(request)
        add_WaterShare_to_grow_box(request)
        add_CO2_to_grow_box(request)
        add_humidity_of_earth_to_grow_box(request)
        add_temperature_to_grow_box(request)
    return HttpResponseRedirect("../../main/")

#Добавление нового light
@login_required(login_url='/auth/login/')
def add_light_to_grow_box(request):
    if request.method == 'GET':
        grow_box = find_grow_box(request.user, request.GET['grow_box_id'])
        grow_box.add_light(request.GET['light_ident'])
    return HttpResponseRedirect("../../main/")

#Добавление нового DHT22
@login_required(login_url='/auth/login/')
def add_DHT22_to_grow_box(request):
    if request.method == 'GET':
        grow_box = find_grow_box(request.user, request.GET['grow_box_id'])
        grow_box.add_DHT22(request.GET['DHT22_ident'])
    return HttpResponseRedirect("../../main/")

#Добавление новой помпы
@login_required(login_url='/auth/login/')
def add_WaterShare_to_grow_box(request):
    if request.method == 'GET':
        grow_box = find_grow_box(request.user, request.GET['grow_box_id'])
        grow_box.add_WaterShare(request.GET['WaterShare_ident'])
    return HttpResponseRedirect("../../main/")

#Добавление новой CO2
@login_required(login_url='/auth/login/')
def add_CO2_to_grow_box(request):
    if request.method == 'GET':
        grow_box = find_grow_box(request.user, request.GET['grow_box_id'])
        grow_box.add_CO2(request.GET['CO2_ident'])
    return HttpResponseRedirect("../../main/")


#Добавление новой humidity_of_earth
@login_required(login_url='/auth/login/')
def add_humidity_of_earth_to_grow_box(request):
    if request.method == 'GET':
        grow_box = find_grow_box(request.user, request.GET['grow_box_id'])
        grow_box.add_humidity_of_earth(request.GET['humidity_of_earth_ident'])
    return HttpResponseRedirect("../../main/")

#Добавление новой temperature
@login_required(login_url='/auth/login/')
def add_temperature_to_grow_box(request):
    if request.method == 'GET':
        grow_box = find_grow_box(request.user, request.GET['grow_box_id'])
        grow_box.add_temperature(request.GET['temperature_to_grow_box_ident'])
    return HttpResponseRedirect("../../main/")

#Получение всей информации от датчиков
@login_required(login_url='/auth/login/')
def get_all_information(request):
    if request.method == 'GET':
        grow_box = find_grow_box(request.user, request.GET['grow_box_id'])
        information = get_info(grow_box)
    return JsonResponse(information)

@login_required(login_url='/auth/login/')
def pomp_action(request):
    if request.method == 'GET':
        grow_box = find_grow_box(request.user, request.GET['grow_box_id'])
        grow_box._WaterShare.status = request.GET['status']

@login_required(login_url='/auth/login/')
def light_action(request):
    if request.method == 'GET':
        grow_box = find_grow_box(request.user, request.GET['grow_box_id'])
        grow_box._light.status = request.GET['status']

