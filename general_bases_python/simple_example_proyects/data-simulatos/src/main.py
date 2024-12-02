from log import Logger
from process_file import ProcessFile
from time import time
from fastapi import FastAPI
from fastapi.responses import HTMLResponse

logger = Logger("main")

app = FastAPI()

@app.get('/')
def get_execute():
    return execute()


def execute():
    init = time()
    logger.info(f"Iniciando proceso de simulacion de insercion {init}")
    ProcessFile().apply_reactive('resource/people-2000000.csv')
    #ProcessFile().apply_normal('resource/people-2000000.csv')
    final = time()
    logger.info(f"Finalizando proceso de simulacion de insercion {final}")
    logger.info(f"Tiempo de ejecucion {final-init}")
    return final-init
    
