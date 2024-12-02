import logging
import inspect
import datetime

class Logger():

    def __init__(self, name):
        logging.basicConfig(level=logging.DEBUG)
        self.logger = logging.getLogger(name)
        self.name = name
    
    def info(self, message):
        marco_actual = inspect.currentframe().f_back
        info_linea = inspect.getframeinfo(marco_actual)
        self.logger.setLevel("DEBUG")
        self.logger.info('[Time: %s - Function: %s - Line: %s] %s', datetime.datetime.now(), info_linea.function, info_linea.lineno, message)

    def error(self, message):
        marco_actual = inspect.currentframe().f_back
        info_linea = inspect.getframeinfo(marco_actual)
        self.logger.setLevel("DEBUG")
        self.logger.error('[Time: %s - Function: %s - Line: %s] %s', datetime.datetime.now(), info_linea.function, info_linea.lineno, message)