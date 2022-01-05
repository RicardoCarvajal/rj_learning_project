package ricardo.practica.cliente;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class clienteRestArticle {

    public static void main(String[] args) throws Exception {

        Client client = ClientBuilder.newClient();

        try {

            Response response = client
                    .target("http://localhost:8080/Practica_34_servicio_jax_rs_cajas/articles/code?number=0202002")
                    .request().get();

            if (response.getStatus() != 201)
                throw new RuntimeException("Failed to serch resource");
            String location = response.getLocation().toString();
            System.out.println("Location: " + location);
            response.close();

        } finally {
            client.close();
        }

    }

}
