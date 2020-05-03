from django.contrib.auth import get_user_model
from django.db import models
from django.http import JsonResponse

#скрипт по состояниям
#отправлять коле

User = get_user_model()

class Light(models.Model):
    id = models.AutoField(primary_key=True)
    grow_box = models.ForeignKey(
        'GrowBox', on_delete=models.CASCADE)
    ident = models.IntegerField(blank=False, default=0)
    status = models.CharField(max_length=3)
    turn_on_time = models.DateTimeField(auto_now=True)
    how_mutch_time = models.DateTimeField(auto_now=True)

    def info(self):
        return JsonResponse({
            'ident': self.ident,
            'status': self.status,
    })

    def __str__(self):
        return ''.join( str(self.grow_box.ident) + str(self.ident) + str(self.status))

class WaterShare(models.Model):
    id = models.AutoField(primary_key=True)
    grow_box = models.ForeignKey(
        'GrowBox', on_delete=models.CASCADE)
    ident = models.IntegerField(blank=False, default=0)
    turn_on_time = models.DateTimeField(auto_now=True)
    how_mutch_time = models.DateTimeField(auto_now=True)
    status = models.CharField(max_length=3)
    def info(self):
        return JsonResponse({
            'ident': self.ident,
            'status': self.status,
    })

    def __str__(self):
        return ''.join( str(self.grow_box.ident) + str(self.ident) + str(self.status))

class DHT22(models.Model):
    id = models.AutoField(primary_key=True)
    grow_box = models.ForeignKey(
        'GrowBox', on_delete=models.CASCADE)
    ident = models.IntegerField(blank=False, default=0)
    humidity = models.FloatField(blank=True, null=None, default=0)

    def info(self):
        return JsonResponse({
            'ident': self.ident,
            'humidity': self.humidity,
    })

    def __str__(self):
        return ''.join( str(self.grow_box.ident) + str(self.ident) + str(self.humidity))

class CO2(models.Model):
    id = models.AutoField(primary_key=True)
    grow_box = models.ForeignKey(
        'GrowBox', on_delete=models.CASCADE)
    ident = models.IntegerField(blank=False, default=0)
    cou2_proc = models.FloatField(blank=True, null=None, default=0)

    def info(self):
        return JsonResponse({
            'ident': self.ident,
            'cou2_proc': self.cou2_proc,
    })

    def __str__(self):
        return ''.join( str(self.grow_box.ident) + str(self.ident) + str(self.humidity))


class temperature(models.Model):
    id = models.AutoField(primary_key=True)
    grow_box = models.ForeignKey(
        'GrowBox', on_delete=models.CASCADE)
    ident = models.IntegerField(blank=False, default=0)
    _temperature = models.FloatField(blank=True, null=None, default=0)

    def info(self):
        return JsonResponse({
            'ident': self.ident,
            '_temperature': self._temperature,
    })
    def __str__(self):
        return ''.join( str(self.grow_box.ident) + str(self.ident) + str(self.humidity))


class humidity_of_earth(models.Model):
    id = models.AutoField(primary_key=True)
    grow_box = models.ForeignKey(
        'GrowBox', on_delete=models.CASCADE)
    ident = models.IntegerField(blank=False, default=0)
    humidity = models.FloatField(blank=True, null=None, default=0)
    def info(self):
        return JsonResponse({
            'ident': self.ident,
            'humidity': self.humidity,
        })
    def __str__(self):
        return ''.join( str(self.grow_box.ident) + str(self.ident) + str(self.humidity))


class GrowBox(models.Model):
    id = models.AutoField(primary_key=True)
    #person = models.ForeignKey(
    #    'Pi', on_delete=models.CASCADE)
    ident = models.IntegerField(blank=False, default=0)
    count = models.IntegerField(default=0, blank=False)
    _light = models.ForeignKey(Light, blank=True, null=True, on_delete=models.CASCADE)
    _WaterShare = models.ForeignKey(WaterShare, blank=True, null=True, on_delete=models.CASCADE)
    _DHT22 = models.ForeignKey(DHT22, blank=True, null=True, on_delete=models.CASCADE)
    _CO2 = models.ForeignKey(CO2, blank=True, null=True, on_delete=models.CASCADE)
    _temperature = models.ForeignKey(temperature, blank=True, null=True, on_delete=models.CASCADE)
    _humidity_of_earth = models.ForeignKey(humidity_of_earth, blank=True, null=True, on_delete=models.CASCADE)

    def __str__(self):
        return ''.join( str(self.ident))

    def add_light(self, ident):
        new_light = Light.objects.create(grow_box=self, status='OFF', ident=ident)
        print('OK_light_added', ' ', self.ident)
        new_light.save()
        self._light = new_light
        self.save()

    def add_WaterShare(self, ident):
        new_WaterShare = WaterShare.objects.create(grow_box=self, status='OFF', ident=ident)
        new_WaterShare.save()
        self._WaterShare = new_WaterShare
        self.save()

    def add_DHT22(self, ident):
        new_DHT22 = DHT22.objects.create(grow_box=self, humidity=1001, ident=ident)
        new_DHT22.save()
        self._DHT22 = new_DHT22
        self.save()

    def add_CO2(self, ident):
        new_CO2 = CO2.objects.create(grow_box=self, ident=ident)
        new_CO2.save()
        self._CO2 = new_CO2
        self.save()

    def add_temperature(self, ident):
        new_temperature = temperature.objects.create(grow_box=self, ident=ident)
        new_temperature.save()
        self._temperature = new_temperature
        self.save()

    def add_humidity_of_earth(self, ident):
        new_humidity_of_earth = humidity_of_earth.objects.create(grow_box=self, ident=ident)
        new_humidity_of_earth.save()
        self._humidity_of_earth = new_humidity_of_earth
        self.save()