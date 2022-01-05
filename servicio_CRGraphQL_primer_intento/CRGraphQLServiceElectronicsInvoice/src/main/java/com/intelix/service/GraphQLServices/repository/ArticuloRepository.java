package com.intelix.service.GraphQLServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intelix.service.GraphQLServices.entitys.Articulo;

/**
 * Clase utilizada para acceder a la base de datos y hacer transacciones de base de datos
 * para la tabla Articulo
 * 
 * @see Articulo
 * @see JpaRepository
 * 
 * @author Ricardo J. Carvajal F.
 */
@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, String> {

}
