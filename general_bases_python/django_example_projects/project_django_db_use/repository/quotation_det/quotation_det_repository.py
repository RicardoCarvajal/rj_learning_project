from abc import ABCMeta,abstractmethod

class QueryObjectQuotationDet(metaclass=ABCMeta):
       
    @abstractmethod
    def get_quote_det_by_id(self, id):
        pass