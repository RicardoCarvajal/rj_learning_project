package com.intelix.service.GraphQLServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intelix.service.GraphQLServices.entitys.Opcion;

/**
 * Clase utilizada para acceder a la base de datos y hacer transacciones de base de datos
 * para la tabla Opcion
 * 
 * @see Opcion
 * @see JpaRepository
 * 
 * @author Ricardo J. Carvajal F.
 */
@Repository
public interface OpcionRepository extends JpaRepository<Opcion, Long> {

}
