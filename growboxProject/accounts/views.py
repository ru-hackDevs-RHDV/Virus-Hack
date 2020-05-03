from django.views.generic.edit import FormView
from .form import SignUpForm
from django.http import HttpResponse
from django.shortcuts import render
from .models import Person


class MyRegisterFormView(FormView):
    form_class = SignUpForm
    success_url = "../login/"
    template_name = "registration/signup.html"

    def form_valid(self, form):
        User = form.save({'mama': 'mama'})
        User.save()
        per = Person.objects.create(user=User)
        per.save()
        return super(MyRegisterFormView, self).form_valid(form)

    def form_invalid(self, form):
        return super(MyRegisterFormView, self).form_invalid(form)