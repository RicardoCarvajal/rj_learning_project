package com.intelix.service.GraphQLServices.models;

import lombok.Builder;
import lombok.Value;

/**
 * Clase modelo para manejar o mapear el actividad.graphqls
 * 
 * @see {@link http://localhost:8080/playground} cuando levanta la aplicación
 * 
 * @author Ricardo J. Carvajal F.
 */
@Value
@Builder
public class Actividad {

    /**
     * Debe colocar código que corresponda a cualquiera de las 3 actividades económicas
     * registradas según tarjeta de contribuyente IVA
     * 
     * Siempre que la actividad económica bajo la cual el contribuyente emisor está
     * realizando la operación sea diferente a las 3 registradas en tarjeta NRC, deberá
     * indicar el código de cualquier actividad económica contenida en catálogo de
     * actividades econámicas proporcionado por el MH.
     * 
     */
    private String codActividad;

    /**
     * Debe colocar nombre que corresponda a cualquiera de las 3 actividades económicas
     * registradas según tarjeta de contribuyente IVA
     * 
     * Siempre que la actividad económica bajo la cual el contribuyente emisor está
     * realizando la operación sea diferente a las 3 registradas en tarjeta NRC, deberá
     * indicar el nombre de cualquier actividad económica contenida en catálogo de
     * actividades econámicas proporcionado por el MH.
     * 
     */
    private String descActividad;

}
