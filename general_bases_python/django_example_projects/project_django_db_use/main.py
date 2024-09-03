from query.query_quotation_imp import QueryObjectQuotationImp

query = QueryObjectQuotationImp()

queote = query.get_quote_by_id('0020001992')

print(type(queote))
print(queote)