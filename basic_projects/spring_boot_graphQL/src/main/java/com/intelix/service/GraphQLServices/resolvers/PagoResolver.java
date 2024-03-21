package com.intelix.service.GraphQLServices.resolvers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.intelix.service.GraphQLServices.models.Pago;
import com.intelix.service.GraphQLServices.models.Resumen;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.log4j.Log4j2;

/**
 * Clase que resuelve el schema de pago para graphQL, la clase implementa la clase
 * GraphQLResolver de tipo Resumen
 * 
 * @see GraphQLResolver
 * @see Resumen
 * 
 * @author Ricardo J. Carvajal F.
 */
@Log4j2
@Component
public class PagoResolver implements GraphQLResolver<Resumen> {

    /**
     * Metodo que recibe los parametros del query resolver de Resumen, lo resuelve y
     * entrega al cliente la data solicitada.
     * 
     * @param resumen El resumen resuelto en la clase ResumenResolver
     * @return pagos {@code List<Pago>} construido a partir de la transaccion encontrada
     *         en la BD, obtenida en ResumenResolver
     * 
     * @see ResumenResolver#resumen(com.intelix.service.GraphQLServices.models.Documento)
     */
    public List<Pago> pago(Resumen resumen) {

        log.info("Creando pago para el resumen");

        List<Pago> pagos = new ArrayList<Pago>();

        resumen.getFormadepagoInfo().stream().forEach(fdp -> {

            // TODO para todo lo que esta en null se debe hacer un registro en la tabla
            // transaccionformadepafo
            Pago pago = Pago.builder().codigo(null).descripcion(null).referencia(fdp.getDocumento().trim())
                    .periodo(null).plazo(null).build();

            pagos.add(pago);

        });

        return pagos;

    }

}
