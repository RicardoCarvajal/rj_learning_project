package com.intelix.service.GraphQLServices.resolvers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intelix.service.GraphQLServices.conf.PropertiesConf;
import com.intelix.service.GraphQLServices.entitys.Transaccion;
import com.intelix.service.GraphQLServices.models.Documento;
import com.intelix.service.GraphQLServices.models.Extension;
import com.intelix.service.GraphQLServices.resolvers.query.DocumentResolver;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.log4j.Log4j2;

/**
 * Clase que resuelve el schema de extension para graphQL, la clase implementa la clase
 * GraphQLResolver de tipo Documento
 * 
 * @see GraphQLResolver
 * @see Documento
 * 
 * @author Ricardo J. Carvajal F.
 */
@Log4j2
@Component
public class ExtensionResolver implements GraphQLResolver<Documento> {

    @Autowired
    PropertiesConf properties;

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
    public Extension extension(Documento documento) {

        log.info("Creando extension para el documento de la transaccion " + documento.getId());

        Transaccion tran = documento.getParentTransaction();

        String nombEntrega = null;
        String docuEntrega = null;
        String nombRecibe = null;
        String docuRecibe = null;

        if (tran.getTotalTransaccion().compareTo(new BigDecimal(properties.getAmountExtension())) >= 0) {
            nombEntrega = tran.getIdUsuario().getNombre().trim();
            docuEntrega = String.valueOf(tran.getIdUsuario().getFicha());
            nombRecibe = tran.getNumeroIdentificacionCliente().getNombre().trim();
            docuRecibe = tran.getNumeroIdentificacionCliente().getNumeroIdentificacionCliente().trim();
        }

        // TODO para todo lo que esta en null se debe hacer un registro en la tabla
        // transacción
        Extension extension = Extension.builder().totalItems(new BigDecimal(tran.getRenglones()))
                .totalDescu(tran.getTotalRebaja()).nombEntrega(nombEntrega).docuEntrega(docuEntrega)
                .codEmpleado(String.valueOf(tran.getIdUsuario().getFicha())).nombRecibe(nombRecibe)
                .docuRecibe(docuRecibe).build();

        return extension;

    }

}
