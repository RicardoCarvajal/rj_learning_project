from rest_framework.response import Response
from rest_framework.views import APIView
from .tasks import process_data
from .models import Article
from .serializers import ArticleSerializer
from django.shortcuts import get_object_or_404

class ArticleAPI(APIView):
    authentication_classes = []
    permission_classes = []
    
    def post(self, request):
        process_data.delay(request.data)
        return Response("Proceso enviado",status=201)
    
    def get(self, request):
        id = request.GET.get('id', None)
        code = int(id)
        if code != None:
            try:
                article = get_object_or_404(Article, product_code=code) 
                serializer = ArticleSerializer(article,many=False)
                return Response(serializer.data,status=200)
            except:
                return Response("No existe el articulo - 1",status=404)
        else:
            return Response("No existe el articulo - 2",status=404)
        
