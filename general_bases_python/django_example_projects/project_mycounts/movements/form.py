from django import forms
from .models import Movement

class MovementsForm(forms.Form):
    amount = forms.DecimalField(max_digits=10,decimal_places=2,label='MONTO')
    choises_type_movements = (('1','INGRESO'),('2','EGRESO'))
    type_movements = forms.ChoiceField(choices=choises_type_movements,label='TIPO DE MOVIMIENTO')
    choise_type_currency = (('1','🇻🇪'),('2','🇺🇸'))
    type_currency = forms.ChoiceField(choices=choise_type_currency,label='TIPO DE MONEDA')
    item = forms.CharField(widget=forms.Textarea,label='')
    def save(self):
        final_local_amount = self.cleaned_data['amount']
        final_foreign_exchange = self.cleaned_data['amount']
        print(final_local_amount)
        if self.cleaned_data['type_currency'] == '1':
            if self.cleaned_data['type_movements'] == '2':
                final_local_amount = final_local_amount * -1
            final_foreign_exchange = final_local_amount / 43
        else:
            if self.cleaned_data['type_movements'] == '2':
                final_foreign_exchange = final_foreign_exchange * -1
            final_local_amount = final_foreign_exchange * 43
        Movement.objects.create(
            local_amount=final_local_amount,
            foreign_exchange = final_foreign_exchange,
            items=self.cleaned_data['item'],
        )