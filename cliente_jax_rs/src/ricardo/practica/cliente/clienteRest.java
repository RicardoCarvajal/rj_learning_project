package ricardo.practica.cliente;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class clienteRest {

    public static void main(String[] args) throws Exception {

        Client client = ClientBuilder.newClient();

        try {

            /************* EJEMPLO DE USO DE POST CON XML ***************/
            System.out.println("***Create a new Customer ***");

            String xml = "<customer>" + "<first-name>Bill</first-name>" + "<last-name>Burke</last-name>"
                    + "<street>256 Clarendon Street</street>" + "<city>Boston</city>" + "<state>MA</state>"
                    + "<zip>02115</zip>" + "<country>USA</country>" + "</customer>";

            Response response = client.target("http://localhost:8080/servicio/customers").request()
                    .post(Entity.xml(xml));

            if (response.getStatus() != 201)
                throw new RuntimeException("Failed to create customer");
            String location = response.getLocation().toString();
            System.out.println("Location: " + location);
            response.close();

            /************* EJEMPLO DE USO DE GET CON PARAMETROS EN URI ***************/

            Response responseSerch = client.target("http://localhost:8080/servicio/customers/name/Bill-Burke")
                    .request().get();

            if (responseSerch.getStatus() != 201)
                throw new RuntimeException("Failed to serch customer");
            String locationSerch = responseSerch.getLocation().toString();
            System.out.println("Location: " + locationSerch);
            responseSerch.close();

            /************* EJEMPLO DE USO DE GET CON QUERYPARAM ***************/

            Response responseSerchQuery = client
                    .target("http://localhost:8080/servicio/customers/concret?start=2&size=3").request().get();

            if (responseSerchQuery.getStatus() != 201)
                throw new RuntimeException("Failed to serch customer");
            String locationSerchQuery = responseSerchQuery.getLocation().toString();
            System.out.println("Location: " + locationSerchQuery);
            responseSerchQuery.close();

        } finally {
            client.close();
        }

    }

}
