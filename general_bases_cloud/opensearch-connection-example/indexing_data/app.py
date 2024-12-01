from opensearchpy import OpenSearch, RequestsHttpConnection, Search  # type: ignore


def lambda_handler(event, context):

    host = 'search-devate-os-2kvaxk6l6mmzodzppltegk466e.us-west-2.es.amazonaws.com'
    port = 443
    auth = ('masteradmin', "1:ZG^uZ`gJ'*PV1]") 

    client = OpenSearch(
        hosts=[{'host': host, 'port': port}],
        http_auth=auth,
        use_ssl=True,
        verify_certs=True,
        connection_class=RequestsHttpConnection
    )

    movies = '{ "update" : { "_index" : "rcarvajal_index", "_id" : "1" } } \n { "doc" : { "title" : "Interstellar", "director" : "Christopher Nolan", "year" : "2014"} } \n { "update" : { "_index" : "rcarvajal_index", "_id" : "2" } } \n { "doc" : { "title" : "Star Trek Beyond", "director" : "Justin Lin", "year" : "2015"} } \n { "update" : {"_id" : "3", "_index" : "rcarvajal_index" } } \n { "doc" : { "title" : "El Señor de los Anillos: la Comunidad del Anillo ", "director" : "Peter Jackson", "year" : "2001"} }'

    response = client.bulk(movies)

    s = Search(using=client, index="rcarvajal_index").filter("term", year="2014").query("match", title="Interstellar")

    response = s.execute()

    print(response)
    title = response['hits']['hits'][0]['_source']["title" ]

    return {
        "statusCode": 200,
        "body": title
    }