const http = require('http');


function router(request, response) {
    console.log("Nueva peticion");
    console.log(request.url);

    switch (request.url) {
        case '/hola':
            response.writeHead(201, { 'Contex-Type': 'plaint-text' });
            response.write("Hola mundo http");
            response.end();
            break;

        default:
            response.writeHead(404, { 'Contex-Type': 'plaint-text' });
            response.write("Error 404");
            response.end();
            break;
    }


}

http.createServer(router).listen(8080);

console.log("Escuchando por el puerto 8080");