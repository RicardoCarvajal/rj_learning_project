package com.intelix.service.GraphQLServices.resolvers;

import org.springframework.stereotype.Component;

import com.intelix.service.GraphQLServices.models.Actividad;
import com.intelix.service.GraphQLServices.models.Emisor;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.log4j.Log4j2;

/**
 * Clase que resuelve el schema de actividad1 y actividad2 para graphQL, la clase
 * implementa la clase GraphQLResolver de tipo Emisor
 * 
 * @see GraphQLResolver
 * @see Emisor
 * 
 * @author Ricardo J. Carvajal F.
 */
@Log4j2
@Component
public class ActividadResolver implements GraphQLResolver<Emisor> {

    /**
     * Metodo que recibe los parametros del query resolver de Emisor, lo resuelve y
     * entrega al cliente la data solicitada.
     * 
     * @param emisor El emisor resuelto en la clase EmisorResolver
     * @return actividad1 construido a partir de las opciones de la BD obtenida en
     *         EmisorResolver
     * 
     * @see EmisorResolver#emisor(com.intelix.service.GraphQLServices.models.Documento)
     */
    public Actividad actividad1(Emisor emisor) {

        log.info("Creando actividad1 para el emisor " + emisor.getNombre());

        // TODO para todo lo que esta en null se debe hacer un registro en la tabla opcion
        Actividad actividad = Actividad.builder().codActividad(null).descActividad(null).build();

        return actividad;

    }

    /**
     * Metodo que recibe los parametros del query resolver de Emisor, lo resuelve y
     * entrega al cliente la data solicitada.Por ahora siempre debe ser null
     * 
     * @param emisor El emisor resuelto en la clase EmisorResolver
     * @return actividad2 construido a partir de las opciones de la BD obtenida en
     *         EmisorResolver
     * 
     * @see EmisorResolver#emisor(com.intelix.service.GraphQLServices.models.Documento)
     */
    public Actividad actividad2(Emisor emisor) {

        return null;

    }

}
