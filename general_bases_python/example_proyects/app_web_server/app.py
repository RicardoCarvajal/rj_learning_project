import requests as request
from fastapi import FastAPI
from fastapi.responses import HTMLResponse

app = FastAPI()

@app.get('/')
def get_list():
    return [1,2,3,4]

@app.get('/contact',response_class=HTMLResponse)
def get_contact():
    return """
        <h1>Contactos</h1>
        <h3>Ricardo Carvajal</h3>
        <h3>0416-4589632</h3>
        """

def run():
    get_categories()


def get_categories():
    response = request.get('https://api.escuelajs.co/api/v1/categories')
    categories = response.json()
    for category in categories:
        print(category['name'])


if __name__ == '__main__':
    run()


