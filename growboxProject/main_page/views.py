from django.shortcuts import render
from django.contrib.auth import get_user_model
from django.shortcuts import render, get_object_or_404
from django.contrib.auth.decorators import login_required
from .models import Light, WaterShare, DHT22, GrowBox
from accounts.models import Person
from django.http import HttpResponseRedirect

@login_required(login_url='/auth/login/')
def index(request):
    person = Person.objects.get(user=request.user)
    gr_id = [i for i in person.grow_box.all()]
    content = {
            'name': request.user.username,
            'grow_box_id': gr_id,
    }
    return render(request,'index.html', context=content)

User = get_user_model()

@login_required(login_url='/auth/login/')
def set_grow_box(request):
    if request.method == 'GET':
        person = Person.objects.get(user=request.user)
        person.set_grow_box(request.GET['grow_box_id'])
    return HttpResponseRedirect("../../main/")

@login_required(login_url='/auth/login/')
def add_light_to_grow_box(request):
    if request.method == 'GET':
        _person = Person.objects.get(user=request.user)
        needed_gr = [i for i in _person.grow_box.all() if i.ident == int(request.GET['grow_box_id'])]
        if len(needed_gr) == 1:
            needed_gr[0].add_light()
        else:
            print('NOT ONLY ONE GROW BOX WITH THIS IDENT')
    return HttpResponseRedirect("../../main/")


@login_required(login_url='/auth/login/')
def add_DHT22_to_grow_box(request):
    if request.method == 'GET':
        _person = Person.objects.get(user=request.user)
        needed_gr = [i for i in _person.grow_box.all() if i.ident == int(request.GET['grow_box_id'])]
        if len(needed_gr) == 1:
            needed_gr[0].add_DHT22()
        else:
            print('NOT ONLY ONE GROW BOX WITH THIS IDENT')
    return HttpResponseRedirect("../../main/")


@login_required(login_url='/auth/login/')
def add_WaterShare_to_grow_box(request):
    if request.method == 'GET':
        _person = Person.objects.get(user=request.user)
        needed_gr = [i for i in _person.grow_box.all() if i.ident == int(request.GET['grow_box_id'])]
        if len(needed_gr) == 1:
            needed_gr[0].add_WaterShare()
        else:
            print('NOT ONLY ONE GROW BOX WITH THIS IDENT')
    return HttpResponseRedirect("../../main/")