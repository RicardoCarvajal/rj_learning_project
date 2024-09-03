from model.product import Product
from model.quotation import Quotation

class QuotationGetUseCase():

    def __init__(self, queryobject,queryobjectdet):
        self.queryobject = queryobject
        self.queryobjectdet = queryobjectdet
       
    def get_quote_to_send(self, id):
        q = self.queryobject.get_quote_by_id(id)
        quote = Quotation(q.quote_origin,q.customer_id,q.branch_office_id.duns,q.quote_id)
        list_q_det = self.queryobjectdet.get_quote_det_by_id(id)
        print(list_q_det)
        for q_det in list_q_det:
            product = Product(q_det.product_code.value, q_det.quantity,q_det.product_price,q_det.percentage_tax,q_det.discount_unit_ammount)
            quote.addProduct(product)
        return quote