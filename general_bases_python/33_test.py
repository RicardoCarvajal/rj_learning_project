def calculate_total(products):
    total = 0
    for product in products:
        total += product['price']
    return total

def test_calculate_total_with_total_empty():
    assert calculate_total([]) == 0

def test_calculate_total_with_one_item():
    products = [
        {
            'name': 'A',
            'price': 5
        },
        {
            'name': 'B',
            'price': 5
        }
    ]
    assert calculate_total(products) == 10


if __name__ == "__main__":
    test_calculate_total_with_total_empty()
    test_calculate_total_with_one_item()