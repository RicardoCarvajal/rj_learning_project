package com.intelix.service.GraphQLServices.resolvers;

import org.springframework.stereotype.Component;

import com.intelix.service.GraphQLServices.models.Actividad;
import com.intelix.service.GraphQLServices.models.Receptor;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.log4j.Log4j2;

/**
 * Clase que resuelve el schema de actividad para graphQL, la clase implementa la clase
 * GraphQLResolver de tipo Receptor
 * 
 * @see GraphQLResolver
 * @see Receptor
 * 
 * @author Ricardo J. Carvajal F.
 */
@Log4j2
@Component
public class ActividadReceptorResolver implements GraphQLResolver<Receptor> {

    /**
     * Metodo que recibe los parametros del query resolver de Receptor, lo resuelve y
     * entrega al cliente la data solicitada.
     * 
     * @param receptor El receptor resuelto en la clase ReceptorResolver
     * @return actividad construido a partir de las opciones de la BD obtenida en
     *         ReceptorResolver
     * 
     * @see ReceptorResolver#receptor(com.intelix.service.GraphQLServices.models.Documento)
     */
    public Actividad actividad(Receptor receptor) {

        log.info("Creando actividad para el receptor " + receptor.getNombre());

        // TODO para todo lo que esta en null se debe hacer un registro en la tabla
        // cliente
        Actividad actividad = Actividad.builder().codActividad(null).descActividad(null).build();

        return actividad;

    }

}
