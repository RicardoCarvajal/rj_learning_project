package com.intelix.service.GraphQLServices.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intelix.service.GraphQLServices.conf.PropertiesDataBaseConf;
import com.intelix.service.GraphQLServices.models.Emisor;
import com.intelix.service.GraphQLServices.models.Sucursal;
import com.intelix.service.GraphQLServices.repository.OpcionRepository;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.log4j.Log4j2;

/**
 * Clase que resuelve el schema de sucursal para graphQL, la clase implementa la clase
 * GraphQLResolver de tipo Emisor
 * 
 * @see GraphQLResolver
 * @see Emisor
 * 
 * @author Ricardo J. Carvajal F.
 */
@Log4j2
@Component
public class SucursalResolver implements GraphQLResolver<Emisor> {

    @Autowired
    private PropertiesDataBaseConf properties;

    @Autowired
    OpcionRepository opcionRepository;

    /**
     * Metodo que recibe los parametros del query resolver de Emisor, lo resuelve y
     * entrega al cliente la data solicitada.
     * 
     * @param emisor El emisor resuelto en la clase EmisorResolver
     * @return sucursal construido a partir de las opciones de la BD obtenida en
     *         EmisorResolver
     * 
     * @see EmisorResolver#emisor(com.intelix.service.GraphQLServices.models.Documento)
     */
    public Sucursal sucursal(Emisor emisor) {

        log.info("Creando sucursal para el emisor " + emisor.getNombre());

        Sucursal sucursal = Sucursal.builder()
                .nombre(opcionRepository.findById(properties.getNamestore()).get().getValor().trim())
                .codigo(opcionRepository.findById(properties.getNumberStore()).get().getValor().trim())
                .puntoVenta(emisor.getCaja())
                .telefono(opcionRepository.findById(properties.getPhone()).get().getValor().trim()).build();

        return sucursal;

    }

}
