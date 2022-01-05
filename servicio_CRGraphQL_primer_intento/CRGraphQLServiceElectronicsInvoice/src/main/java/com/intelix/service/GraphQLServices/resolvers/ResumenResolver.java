package com.intelix.service.GraphQLServices.resolvers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intelix.service.GraphQLServices.conf.PropertiesConf;
import com.intelix.service.GraphQLServices.entitys.Transaccion;
import com.intelix.service.GraphQLServices.models.Documento;
import com.intelix.service.GraphQLServices.models.Resumen;
import com.intelix.service.GraphQLServices.resolvers.query.DocumentResolver;
import com.intelix.service.GraphQLServices.utils.NumberToletter;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.log4j.Log4j2;

/**
 * Clase que resuelve el schema de resumen para graphQL, la clase implementa la clase
 * GraphQLResolver de tipo Documento
 * 
 * @see GraphQLResolver
 * @see Documento
 * 
 * @author Ricardo J. Carvajal F.
 */
@Log4j2
@Component
public class ResumenResolver implements GraphQLResolver<Documento> {

    @Autowired
    PropertiesConf properties;

    @Autowired
    NumberToletter numberToletter;

    private BigDecimal totalTransactionExAmount = BigDecimal.ZERO;

    private BigDecimal totalTransactionTaxAmount = BigDecimal.ZERO;

    private BigDecimal payRetention = BigDecimal.ZERO;

    /**
     * Metodo que recibe los parametros del query resolver de Documento, lo resuelve y
     * entrega al cliente la data solicitada.
     * 
     * @param documento El documento resuelto en la clase DocumentResolver
     * @return resumen construido a partir de la transaccion encontrada en la BD, obtenida
     *         en DocumentResolver
     * 
     * @see DocumentResolver#documento(Integer, String)
     */
    public Resumen resumen(Documento documento) {

        log.info("Creando resumen para el documento de la transaccion " + documento.getId());

        Transaccion tran = documento.getParentTransaction();

        totalTransactionExAmount = BigDecimal.ZERO;

        totalTransactionTaxAmount = BigDecimal.ZERO;

        payRetention = BigDecimal.ZERO;

        tran.getTransaccionarticuloList().stream().forEach(articulos -> {

            if (articulos.getIdTasaimpuestovalor().getTasa().compareTo(BigDecimal.ZERO) == 0) {
                totalTransactionExAmount = totalTransactionExAmount.add(articulos.getTotalBase());
            } else {
                totalTransactionTaxAmount = totalTransactionTaxAmount.add(articulos.getTotalBase());
            }

        });

        tran.getTransaccionformadepagoList().stream().forEach(fdp -> {
            if (fdp.getIdFormadepago().getId().compareTo(properties.getRetentionPay()) == 0) {
                payRetention = fdp.getMontoMonedaLocal();
            }

        });

        BigDecimal subTotal = ((totalTransactionTaxAmount.add(totalTransactionExAmount))
                .subtract(tran.getTotalRebaja())).add(tran.getTotalImpuesto());

        // TODO para todo lo que esta en null se debe hacer un registro en la tabla
        // transacción
        Resumen resumen = Resumen.builder().totalNoSuj(null).totalExenta(totalTransactionExAmount)
                .totalGravada(totalTransactionTaxAmount)
                .subTotalVentas(totalTransactionTaxAmount.add(totalTransactionExAmount))
                .descuento(tran.getTotalRebaja()).porcentajeDescuento(null).totalIva(tran.getTotalImpuesto())
                .subTotal(subTotal).ivaPerci1(tran.getTotalPercepcion()).ivaRete1(payRetention)
                .montoTotalOperacion(tran.getTotalTransaccion()).totalPagar(tran.getTotalTransaccion())
                .totalLetras(numberToletter.toLetter(tran.getTotalTransaccion())).condicionOperacion(null)
                .numPagoElectronico(null).formadepagoInfo(tran.getTransaccionformadepagoList()).build();

        return resumen;

    }

}
