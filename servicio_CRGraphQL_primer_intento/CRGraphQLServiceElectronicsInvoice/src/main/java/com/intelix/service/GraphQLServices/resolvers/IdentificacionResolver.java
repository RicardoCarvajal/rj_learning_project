package com.intelix.service.GraphQLServices.resolvers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intelix.service.GraphQLServices.conf.PropertiesConf;
import com.intelix.service.GraphQLServices.entitys.Transaccion;
import com.intelix.service.GraphQLServices.models.Documento;
import com.intelix.service.GraphQLServices.models.Identificacion;
import com.intelix.service.GraphQLServices.resolvers.query.DocumentResolver;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.log4j.Log4j2;

/**
 * Clase que resuelve el schema de identificacion para graphQL, la clase implementa la
 * clase GraphQLResolver de tipo Documento
 * 
 * @see GraphQLResolver
 * @see Documento
 * 
 * @author Ricardo J. Carvajal F.
 */
@Log4j2
@Component
public class IdentificacionResolver implements GraphQLResolver<Documento> {

    @Autowired
    private PropertiesConf properties;

    /**
     * Metodo que recibe los parametros del query resolver de Documento, lo resuelve y
     * entrega al cliente la data solicitada.
     * 
     * @param documento El documento resuelto en la clase DocumentResolver
     * @return identificacion construido a partir de la transaccion de la BD obtenida en
     *         DocumentResolver
     * 
     * @see DocumentResolver#documento(Integer, String)
     */
    public Identificacion identificacion(Documento documento) {

        log.info("Creando identificación para el documento de la transaccion " + documento.getId());

        Transaccion tran = documento.getParentTransaction();

        // TODO los campos tipoDte - numeroControl - codigoGeneracion posteriormente deben
        // ser sacados de la transaccion
        Identificacion identificacion = Identificacion.builder().version(properties.getVersion())
                .ambiente(properties.getEnv()).tipoModelo(properties.getModeltype())
                .tipoOperacion(properties.getModeloperation()).tipoMoneda(properties.getMoney()).tipoDte("01")
                .codigoGeneracion(UUID.randomUUID().toString()).numeroControl("DTE-01-59002-000000000000001")
                .fecEmi(tran.getFecha()).horEmi(tran.getHora()).build();

        return identificacion;
    }

}
