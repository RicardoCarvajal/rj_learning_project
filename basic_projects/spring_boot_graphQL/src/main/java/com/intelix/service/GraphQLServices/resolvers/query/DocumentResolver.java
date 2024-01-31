package com.intelix.service.GraphQLServices.resolvers.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intelix.service.GraphQLServices.entitys.Transaccion;
import com.intelix.service.GraphQLServices.models.Documento;
import com.intelix.service.GraphQLServices.repository.TransaccionRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.log4j.Log4j2;

/**
 * Clase que resuelve el schema de documento para graphQL, la clase implementa la clase
 * GraphQLQueryResolver
 * 
 * @see GraphQLQueryResolver
 * 
 * @author Ricardo J. Carvajal F.
 */
@Log4j2
@Component
public class DocumentResolver implements GraphQLQueryResolver {

    @Autowired
    TransaccionRepository transaccionRepository;

    /**
     * Metodo que recibe los parametros del query del cliente, lo resuelve y entrega al
     * cliente la data solicitada, este metodo usa
     * {@link TransaccionRepository#findByNumeroAndCaja(int, String)} para buscar
     * primeramente la transaccion en la BD de las tiendas de EPA
     * 
     * @param numero El numero de la transaccion de la cual se quiere generar el documento
     * @param caja El numero de la caja de la cual se quiere generar el documento
     * @return El documento generado y solicitado por el cliente
     * 
     * @see TransaccionRepository#findByNumeroAndCaja(int, String)
     */
    public Documento documento(Integer numero, String caja) {

        log.info("Generando documento para transacción numero " + numero + " de la caja " + caja);

        Transaccion transaccion = transaccionRepository.findByNumeroAndCaja(numero, caja);

        Documento documento = Documento.builder().id(transaccion.getId()).numero(transaccion.getNumero())
                .parentTransaction(transaccion).build();

        return documento;
    }

}
