from django.shortcuts import render

def initial_view(request):
    car_list = [
        {"title": "Car 1"},
        {"title": "Car 2"},
        {"title": "Car 3"}
    ]
    context = {
        "car_list": car_list
    }
    return render(request, 'app_initial/car_list.html', context)
