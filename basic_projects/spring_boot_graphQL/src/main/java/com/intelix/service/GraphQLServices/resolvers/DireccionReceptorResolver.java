package com.intelix.service.GraphQLServices.resolvers;

import org.springframework.stereotype.Component;

import com.intelix.service.GraphQLServices.models.Direccion;
import com.intelix.service.GraphQLServices.models.Receptor;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.log4j.Log4j2;

/**
 * Clase que resuelve el schema de direccion para graphQL, la clase implementa la clase
 * GraphQLResolver de tipo Receptor
 * 
 * @see GraphQLResolver
 * @see Receptor
 * 
 * @author Ricardo J. Carvajal F.
 */
@Log4j2
@Component
public class DireccionReceptorResolver implements GraphQLResolver<Receptor> {

    /**
     * Metodo que recibe los parametros del query resolver de Receptor, lo resuelve y
     * entrega al cliente la data solicitada.
     * 
     * @param receptor El receptor resuelto en la clase ReceptorResolver
     * @return direccion construido a partir de las opciones de la BD obtenida en
     *         ReceptorResolver
     * 
     * @see ReceptorResolver#emisor(com.intelix.service.GraphQLServices.models.Documento)
     */
    public Direccion direccion(Receptor receptor) {

        log.info("Creando direccion para el receptor " + receptor.getNombre());

        // TODO para todo lo que esta en null se debe hacer un registro en la tabla
        // cliente
        Direccion direccion = Direccion.builder().departamento(null).municipio(null)
                .complemento(receptor.getCliente().getDireccion().trim()).build();

        return direccion;

    }

}
