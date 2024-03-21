package com.intelix.service.GraphQLServices.resolvers;

import org.springframework.stereotype.Component;

import com.intelix.service.GraphQLServices.entitys.Cliente;
import com.intelix.service.GraphQLServices.models.Documento;
import com.intelix.service.GraphQLServices.models.Receptor;
import com.intelix.service.GraphQLServices.resolvers.query.DocumentResolver;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.log4j.Log4j2;

/**
 * Clase que resuelve el schema de receptor para graphQL, la clase implementa la clase
 * GraphQLResolver de tipo Documento
 * 
 * @see GraphQLResolver
 * @see Documento
 * 
 * @author Ricardo J. Carvajal F.
 */
@Log4j2
@Component
public class ReceptorResolver implements GraphQLResolver<Documento> {

    /**
     * Metodo que recibe los parametros del query resolver de Documento, lo resuelve y
     * entrega al cliente la data solicitada.
     * 
     * @param documento El documento resuelto en la clase DocumentResolver
     * @return receptor construido a partir de la transacción encontrada en la BD obtenida
     *         en DocumentResolver
     * 
     * @see DocumentResolver#documento(Integer, String)
     */
    public Receptor receptor(Documento documento) {

        log.info("Creando receptor para el documento de la transacción " + documento.getId());

        Cliente cliente = documento.getParentTransaction().getNumeroIdentificacionCliente();

        // TODO para todo lo que esta en null se debe hacer un registro en la tabla
        // cliente
        Receptor receptor = Receptor.builder().nit(cliente.getNumeroIdentificacionTributario().trim())
                .nrc(cliente.getNumeroIdentificacionCliente().trim()).nombre(cliente.getNombre().trim())
                .nombreComercial(cliente.getNombre().trim()).categoria(null).telefono(cliente.getTelefono().trim())
                .correo(cliente.getCorreoElectronico().trim()).fecSujExcl(null).numFacturador(null)
                .cliente(cliente).build();

        return receptor;

    }

}
