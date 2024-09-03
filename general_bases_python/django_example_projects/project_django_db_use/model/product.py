class Product:
    def __init__(self, code_product, quantity, price_product, percentage_tax, discount_unit_amount):
        self.code_product = code_product
        self.quantity = quantity
        self.price_product = price_product
        self.percentage_tax = percentage_tax
        self.discount_unit_amount = discount_unit_amount

    def __repr__(self):
        return f"Product(code_product={self.code_product}, quantity={self.quantity}, price_product={self.price_product}, percentage_tax={self.percentage_tax}, discount_unit_amount={self.discount_unit_amount})"
    
    def to_dict(self):
        return {
            "codeProduct": self.code_product,
            "quantity": self.quantity,
            "priceProduct": self.price_product,
            "percentageTax": self.percentage_tax,
            "discountUnitAmmount": self.discount_unit_amount
        }