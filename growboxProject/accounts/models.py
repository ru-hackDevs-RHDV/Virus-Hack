from django.db import models
from django.contrib.auth import get_user_model
from main_page.models import GrowBox

User = get_user_model()

class Person(models.Model):
    id = models.AutoField(primary_key=True)
    user = models.ForeignKey(
        User, on_delete=models.CASCADE)
    grow_box = models.ManyToManyField(GrowBox, blank=True)


    def set_grow_box(self, _id):
        new_gr = GrowBox.objects.create(person=self, ident=_id)
        new_gr.save()
        self.grow_box.add(new_gr)
        self.save()

    def __str__(self):
        return self.user.username

