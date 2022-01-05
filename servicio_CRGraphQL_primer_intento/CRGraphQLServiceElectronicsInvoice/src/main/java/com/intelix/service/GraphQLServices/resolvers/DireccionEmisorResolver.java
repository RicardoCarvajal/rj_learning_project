package com.intelix.service.GraphQLServices.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intelix.service.GraphQLServices.conf.PropertiesDataBaseConf;
import com.intelix.service.GraphQLServices.models.Direccion;
import com.intelix.service.GraphQLServices.models.Emisor;
import com.intelix.service.GraphQLServices.repository.OpcionRepository;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.log4j.Log4j2;

/**
 * Clase que resuelve el schema de direccion para graphQL, la clase implementa la clase
 * GraphQLResolver de tipo Emisor
 * 
 * @see GraphQLResolver
 * @see Emisor
 * 
 * @author Ricardo J. Carvajal F.
 */
@Log4j2
@Component
public class DireccionEmisorResolver implements GraphQLResolver<Emisor> {

    @Autowired
    private PropertiesDataBaseConf properties;

    @Autowired
    OpcionRepository opcionRepository;

    /**
     * Metodo que recibe los parametros del query resolver de Emisor, lo resuelve y
     * entrega al cliente la data solicitada.
     * 
     * @param emisor El emisor resuelto en la clase EmisorResolver
     * @return direccion construido a partir de las opciones de la BD obtenida en
     *         EmisorResolver
     * 
     * @see EmisorResolver#emisor(com.intelix.service.GraphQLServices.models.Documento)
     */
    public Direccion direccion(Emisor emisor) {

        log.info("Creando direccion para el emisor " + emisor.getNombre());

        // TODO para todo lo que esta en null se debe hacer un registro en la tabla opcion
        Direccion direccion = Direccion.builder().departamento(null).municipio(null)
                .complemento(opcionRepository.findById(properties.getDirectionEpa()).get().getValor().trim())
                .build();

        return direccion;

    }

}
