from entity.quotation_det import QuotationDet
from .quotation_det_repository import QueryObjectQuotationDet

class QueryObjectQuotationDetDjango(QueryObjectQuotationDet):  
    def get_quote_det_by_id(self, id): 
        return QuotationDet.objects.filter(quote_id=id)