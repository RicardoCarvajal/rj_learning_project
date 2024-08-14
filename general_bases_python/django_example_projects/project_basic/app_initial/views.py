from django.shortcuts import render

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
