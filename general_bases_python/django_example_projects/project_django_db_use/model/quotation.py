class Quotation:
    def __init__(self, quote_origin, id_customer, id_branch, id_quote):
        self.id_customer = id_customer
        self.id_branch = id_branch
        self.quote_origin = quote_origin
        self.id_quote = id_quote
        self.products = []

    def __repr__(self):
        return (f"CustomerQuote(id_customer={self.id_customer}, id_branch={self.id_branch}, "
                f"quote_origin={self.quote_origin}, id_quote={self.id_quote}, products={self.products})")
    
    def addProduct(self, product):
        self.products.append(product)
    
    def to_dict(self):
        return {
                "idCustomer": self.id_customer,
                "idBranch": self.id_branch,
                "quoteOrigin": self.quote_origin,
                "idQuote": self.id_quote,
                "product": self.products
        }



