package com.intelix.service.GraphQLServices.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intelix.service.GraphQLServices.conf.PropertiesDataBaseConf;
import com.intelix.service.GraphQLServices.entitys.Transaccion;
import com.intelix.service.GraphQLServices.models.Documento;
import com.intelix.service.GraphQLServices.models.Emisor;
import com.intelix.service.GraphQLServices.repository.OpcionRepository;
import com.intelix.service.GraphQLServices.resolvers.query.DocumentResolver;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.log4j.Log4j2;

/**
 * Clase que resuelve el schema de emisor para graphQL, la clase implementa la clase
 * GraphQLResolver de tipo Documento
 * 
 * @see GraphQLResolver
 * @see Documento
 * 
 * @author Ricardo J. Carvajal F.
 */
@Log4j2
@Component
public class EmisorResolver implements GraphQLResolver<Documento> {

    @Autowired
    private PropertiesDataBaseConf properties;

    @Autowired
    OpcionRepository opcionRepository;

    /**
     * Metodo que recibe los parametros del query resolver de Documento, lo resuelve y
     * entrega al cliente la data solicitada.
     * 
     * @param documento El documento resuelto en la clase DocumentResolver
     * @return emisor construido a partir de las opciones de la BD obtenida en
     *         DocumentResolver
     * 
     * @see DocumentResolver#documento(Integer, String)
     */
    public Emisor emisor(Documento documento) {

        log.info("Creando emisor para el documento de la transaccion " + documento.getId());

        Transaccion tran = documento.getParentTransaction();

        // TODO para todo lo que esta en null se debe hacer un registro en la tabla opcion
        Emisor emisor = Emisor.builder().caja(tran.getIdSesion().getIdCaja())
                .nit(opcionRepository.findById(properties.getEpanit()).get().getValor().trim()).nrc(null)
                .numFacturador(null)
                .nombre(opcionRepository.findById(properties.getNamestore()).get().getValor().trim())
                .nombreComercial(opcionRepository.findById(properties.getNamestore()).get().getValor().trim())
                .correo(null).telefono(opcionRepository.findById(properties.getPhone()).get().getValor().trim())
                .categoria(null).tipoEstablecimiento(null).build();

        return emisor;

    }

}
