from typing import Any
from django.views import generic
from .models import Item

class ItemsListView(generic.TemplateView):
    template_name = 'list_items.html'
    
    def get_context_data(self):
        items_list = Item.objects.all()
        print(items_list)
        return {
            'items_list': items_list
        }
