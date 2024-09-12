from django import forms
from .models import DanceEnvent

class DanceEventsForm(forms.Form):
    name = forms.CharField(max_length=100,label='Nombre')
    description = forms.CharField(max_length=300, label='Description')
    date = forms.DateTimeField(label='fecha')
    location = forms.CharField(max_length=100, label='ubicacion')
    image = forms.ImageField(label='imagen',required=False)

    def save(self):
        DanceEnvent.objects.create(
            name = self.cleaned_data['name'],
            description = self.cleaned_data['description'],
            date = self.cleaned_data['date'],
            location = self.cleaned_data['location'],
            image = self.cleaned_data['image'],
        )
