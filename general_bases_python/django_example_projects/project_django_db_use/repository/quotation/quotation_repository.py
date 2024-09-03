from abc import ABCMeta,abstractmethod

class QueryObjectQuotation(metaclass=ABCMeta):
       
    @abstractmethod
    def get_quote_by_id(self, id):
        pass