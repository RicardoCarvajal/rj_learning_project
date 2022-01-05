package com.intelix.service.GraphQLServices.resolvers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import com.intelix.service.GraphQLServices.entitys.Transaccion;
import com.intelix.service.GraphQLServices.models.CuerpoDocumento;
import com.intelix.service.GraphQLServices.models.Documento;
import com.intelix.service.GraphQLServices.resolvers.query.DocumentResolver;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.log4j.Log4j2;

/**
 * Clase que resuelve el schema de CuerpoDocumento para graphQL, la clase implementa la
 * clase GraphQLResolver de tipo Documento
 * 
 * @see GraphQLResolver
 * @see Documento
 * 
 * @author Ricardo J. Carvajal F.
 */
@Log4j2
@Component
public class CuerpoDocumentoResolver implements GraphQLResolver<Documento> {

    /**
     * Metodo que recibe los parametros del query resolver de Documento, lo resuelve y
     * entrega al cliente la data solicitada.
     * 
     * @param documento El documento resuelto en la clase DocumentResolver
     * @return cuerpos el cual es un {@code List<CuerpoDocumento>} construido a partir de
     *         la transacción encontrada en la BD obtenida en DocumentResolver
     * 
     * @see DocumentResolver#documento(Integer, String)
     */
    public List<CuerpoDocumento> cuerpoDocumento(Documento documento) {

        List<CuerpoDocumento> cuerpos = new ArrayList<CuerpoDocumento>();

        AtomicInteger count = new AtomicInteger(0);

        log.info("Creando cuerpoDocumento para el documento de la transaccion " + documento.getId());

        Transaccion tran = documento.getParentTransaction();

        tran.getTransaccionarticuloList().stream().forEach(articulos -> {

            BigDecimal ventaNoSuj = BigDecimal.ZERO;
            BigDecimal ventaExenta = BigDecimal.ZERO;
            BigDecimal ventaGravada = BigDecimal.ZERO;

            if (articulos.getIdTasaimpuestovalor().getTasa().compareTo(BigDecimal.ZERO) == 0) {
                ventaExenta = articulos.getTotalBase();
            } else {
                ventaGravada = articulos.getTotalBase();
            }

            // TODO para todo lo que esta en null se debe hacer un registro en la tabla
            // articulos o transaccionarticulo
            CuerpoDocumento cuerpodocumento = CuerpoDocumento.builder().numItem(count.incrementAndGet())
                    .tipoItem(null).codigo(articulos.getIdArticulo().getCodigo().toString())
                    .descripcion(articulos.getIdArticulo().getNombre().trim()).cantidad(articulos.getCantidad())
                    .uniMedida(null).precioUni(articulos.getMontoUnitario())
                    .montoDescu(articulos.getMontoUnitario().subtract(articulos.getMontoBase()))
                    .ventaNoSuj(ventaNoSuj).ventaExenta(ventaExenta).ventaGravada(ventaGravada).noGravado(null)
                    .tributos(null).psv(null).diferencial(null).build();
            cuerpos.add(cuerpodocumento);
        });

        return cuerpos;

    }

}
