from entity.quotation import Quotation
from .query_quotation import QueryObjectQuotation

class QueryObjectQuotationImp(QueryObjectQuotation):
    
    def get_quote_by_id(self, id):
        return Quotation.objects.get(quote_id=id)