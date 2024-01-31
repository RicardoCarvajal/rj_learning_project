package com.intelix.service.GraphQLServices.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intelix.service.GraphQLServices.conf.PropertiesDataBaseConf;
import com.intelix.service.GraphQLServices.models.Direccion;
import com.intelix.service.GraphQLServices.models.Sucursal;
import com.intelix.service.GraphQLServices.repository.OpcionRepository;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.log4j.Log4j2;

/**
 * Clase que resuelve el schema de direccion para graphQL, la clase implementa la clase
 * GraphQLResolver de tipo Sucursal
 * 
 * @see GraphQLResolver
 * @see Sucursal
 * 
 * @author Ricardo J. Carvajal F.
 */
@Log4j2
@Component
public class DireccionSucursalResolver implements GraphQLResolver<Sucursal> {

    @Autowired
    private PropertiesDataBaseConf properties;

    @Autowired
    OpcionRepository opcionRepository;

    /**
     * Metodo que recibe los parametros del query resolver de la Sucursal, lo resuelve y
     * entrega al cliente la data solicitada.
     * 
     * @param sucursal La sucursal resuelta en la clase SucursalResolver
     * @return direccion construido a partir de las opciones de la BD obtenida en
     *         SucursalResolver
     * 
     * @see SucursalResolver#sucursal(com.intelix.service.GraphQLServices.models.Emisor)
     */
    public Direccion direccion(Sucursal sucursal) {

        log.info("Creando direccion para la sucursal " + sucursal.getNombre());

        // TODO para todo lo que esta en null se debe hacer un registro en la tabla opcion
        Direccion direccion = Direccion.builder().departamento(null).municipio(null)
                .complemento(opcionRepository.findById(properties.getDirectionStore()).get().getValor().trim())
                .build();

        return direccion;

    }

}
