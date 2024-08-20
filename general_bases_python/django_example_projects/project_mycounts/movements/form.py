from django import forms
from items.models import Item
from .models import Movement

class MovementsForm(forms.Form):
    amount = forms.DecimalField(max_digits=10,decimal_places=2)
    item = forms.ModelChoiceField(queryset=Item.objects.all())
    def save(self):
        Movement.objects.create(
            amount=self.cleaned_data['amount'],
            items=self.cleaned_data['item']
        )