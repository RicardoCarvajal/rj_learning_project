package com.intelix.service.GraphQLServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intelix.service.GraphQLServices.entitys.Usuario;

/**
 * Clase utilizada para acceder a la base de datos y hacer transacciones de base de datos
 * para la tabla Usuario
 * 
 * @see Usuario
 * @see JpaRepository
 * 
 * @author Ricardo J. Carvajal F.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * con este metodo podemos acceder a los datos de un usuario por codigo de barra y
     * clave que normalmente estan en formato md5
     * 
     * @param codigoBarra unico por usuario en formato md5
     * @param Clave unica por usuario en formato md5
     * @return un unico Usuario
     * 
     * @see Usuario
     */
    Usuario findByCodigoBarraAndClave(String codigoBarra, String Clave);

}
