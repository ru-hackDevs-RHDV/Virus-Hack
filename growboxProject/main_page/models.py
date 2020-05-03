from django.contrib.auth import get_user_model
from django.db import models


User = get_user_model()

class Light(models.Model):
    id = models.AutoField(primary_key=True)
    grow_box = models.ForeignKey(
        'GrowBox', on_delete=models.CASCADE)
    ident = models.IntegerField(blank=False, default=0)
    status = models.CharField(max_length=3)
    plan = models.DateTimeField(auto_now=True)

    def __str__(self):
        return ''.join( str(self.grow_box.ident) + str(self.ident) + str(self.status))

class WaterShare(models.Model):
    id = models.AutoField(primary_key=True)
    grow_box = models.ForeignKey(
        'GrowBox', on_delete=models.CASCADE)
    ident = models.IntegerField(blank=False, default=0)
    plan = models.DateTimeField(auto_now=True)
    status = models.CharField(max_length=3)

    def __str__(self):
        return ''.join( str(self.grow_box.ident) + str(self.ident) + str(self.status))

class DHT22(models.Model):
    id = models.AutoField(primary_key=True)
    grow_box = models.ForeignKey(
        'GrowBox', on_delete=models.CASCADE)
    ident = models.IntegerField(blank=False, default=0)
    humidity = models.IntegerField(blank=True, null=None)

    def __str__(self):
        return ''.join( str(self.grow_box.ident) + str(self.ident) + str(self.humidity))

class GrowBox(models.Model):
    id = models.AutoField(primary_key=True)
    #person = models.ForeignKey(
    #    'Pi', on_delete=models.CASCADE)
    ident = models.IntegerField(blank=False, default=0)
    count = models.IntegerField(default=0, blank=False)

    def __str__(self):
        return ''.join( str(self.ident))

    def add_light(self):
        new_light = Light.objects.create(grow_box=self, status='OFF')
        print('OK_light_added', ' ', self.ident)
        new_light.save()

    def add_WaterShare(self):
        new_WaterShare = WaterShare.objects.create(grow_box=self, status='OFF')
        new_WaterShare.save()

    def add_DHT22(self):
        new_DHT22 = DHT22.objects.create(grow_box=self, humidity=1001)
        new_DHT22.save()