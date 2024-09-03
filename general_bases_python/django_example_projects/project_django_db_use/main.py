from container.container import Container

container = Container()

service = container.get_quotation_use_case()

queote = service.get_quote_to_send('0020000271')

print(type(queote))
print(queote.to_dict())

