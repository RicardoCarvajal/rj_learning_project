package com.intelix.service.GraphQLServices.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.extern.log4j.Log4j2;

/**
 * 
 * Clase que recibe la configuracion del application.yml de la aplicación
 * 
 * @author Ricardo J. Carvajal F.
 */
@Log4j2
@Configuration
public class DataSourceConf {

    /**
     * DRIVER campo que guarda el nombre del controlador de la base de datos a utilizar,
     * el nombre se obtiene por inyeccion de dependencias desde el propertie de la
     * aplicacion
     */
    @Value("${database.datasource.driver}")
    private String DRIVER;

    /**
     * URL campo que guarda la direccion de la base de datos a utilizar, el direccion se
     * obtiene por inyeccion de dependencias desde el propertie de la aplicacion
     */
    @Value("${database.datasource.url}")
    private String URL;

    /**
     * SCHEMA campo que guarda el esquema de la base de datos a utilizar, el esquema se
     * obtiene por inyeccion de dependencias desde el propertie de la aplicacion
     */
    @Value("${database.datasource.schema}")
    private String SCHEMA;

    /**
     * USER campo que guarda el usuario de la base de datos a utilizar, el usuario se
     * obtiene por inyeccion de dependencias desde el propertie de la aplicacion
     */
    @Value("${database.datasource.username}")
    private String USER;

    /**
     * PASS campo que guarda la clave de la base de datos a utilizar, el clave se obtiene
     * por inyeccion de dependencias desde el propertie de la aplicacion
     */
    @Value("${database.datasource.password}")
    private String PASS;

    /**
     * 
     * Este metodo configura y crea un DataSource necesario para que la aplicacion se
     * pueda conectar a la base de datos, usa la clase {@link DriverManagerDataSource}
     * 
     * @see DriverManagerDataSource#setDriverClassName(String) aca se coloca el nombre del
     *      driver extraido por inyeccion de dependencia desde el application.yml
     * @see DriverManagerDataSource#setUrl(String) aca se coloca la URL extraida por
     *      inyeccion de dependencia desde el application.yml
     * @see DriverManagerDataSource#setUsername(String) aca se coloca el usuario extraido
     *      por inyeccion de dependencia desde el application.yml
     * @see DriverManagerDataSource#setPassword(String) aca se coloca la clave de la bd
     *      extraida por inyeccion de dependencia desde el application.yml
     * 
     * @return dataSource {@link DriverManagerDataSource}
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        log.info("Servidor de base de datos: " + URL);

        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL + SCHEMA);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASS);
        return dataSource;
    }

    /**
     * Este metodo recibe el mismo @Bean de DataSource creado en esta clase para luego
     * configurar y devolver un {@link LocalContainerEntityManagerFactoryBean}
     * 
     * @param dataSource {@link DriverManagerDataSource}
     * @return entityManagerFactory {@link LocalContainerEntityManagerFactoryBean}
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return entityManagerFactory;
    }

    /**
     * Se configura el manejador de transacciones y se utiliza el @Bean que configura el
     * EntityManagerFactory en esta clase {@link #entityManagerFactory(DataSource)}
     * 
     * @return txManager {@link PlatformTransactionManager}
     */
    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory(dataSource()).getObject());
        return txManager;

    }

}
