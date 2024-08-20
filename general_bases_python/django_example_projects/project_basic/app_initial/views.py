from django.views import generic
from django.shortcuts import render
from django.http import HttpResponse
from django.http import HttpResponse

def registry_view(request):
    registry_list = [
        {'name': 'John', 'age': 25},
        {'name': 'Jane', 'age': 30},
        {'name': 'Bob', 'age': 35},
    ]
    context = {
        'registry_list': registry_list
    }
    return render(request, 'list_registry.html',context)

def registry_view_test(req, *args, **kwargs):
    print(args)
    print(kwargs)
    return HttpResponse("Hello, World!")


class RegistryListView(generic.TemplateView):
    template_name = "list_registry.html"
    def get_context_data(self):
        registry_list = [
            {'name': 'John', 'age': 25},
            {'name': 'Jane', 'age': 30},
            {'name': 'Bob', 'age': 35},
        ]
        return {
            'registry_list': registry_list
        }