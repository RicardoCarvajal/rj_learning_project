package com.intelix.service.GraphQLServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intelix.service.GraphQLServices.entitys.Transaccion;

/**
 * Clase utilizada para acceder a la base de datos y hacer transacciones de base de datos
 * para la tabla Transaccion
 * 
 * @see Transaccion
 * @see JpaRepository
 * 
 * @author Ricardo J. Carvajal F.
 */
@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, String> {

    /**
     * 
     * @param numero de la transaccion que se quiere buscar
     * @param caja de la transaccion que se quiere buscar
     * @return retorna una unica transacción
     * 
     * @see Transaccion
     */
    @Query("select t from Transaccion t where t.numero = :numero and t.idSesion.idCaja = :caja")
    Transaccion findByNumeroAndCaja(int numero, String caja);

}
