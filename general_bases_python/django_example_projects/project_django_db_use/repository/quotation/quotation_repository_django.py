from entity.quotation import Quotation
from .quotation_repository import QueryObjectQuotation

class QueryObjectQuotationDjango(QueryObjectQuotation):  
    def get_quote_by_id(self, id): 
        return Quotation.objects.get(quote_id=id)