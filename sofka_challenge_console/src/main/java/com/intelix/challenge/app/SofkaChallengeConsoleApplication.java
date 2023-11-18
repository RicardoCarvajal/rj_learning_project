package com.intelix.challenge.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.intelix.challenge.app.conf.PropertiesConf;
import com.intelix.challenge.app.services.SaleProductService;
import com.intelix.challenge.app.services.SaleService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class SofkaChallengeConsoleApplication implements CommandLineRunner {

	private final static int CREATE_PRODUCT = 1;

	private final static int TOTAL_SALE = 2;

	PropertiesConf propertiesConf;
	SaleService saleService;
	SaleProductService saleProductService;

	@Autowired
	public SofkaChallengeConsoleApplication(PropertiesConf propertiesConf, SaleService saleService,
			SaleProductService saleProductService) {
		this.propertiesConf = propertiesConf;
		this.saleService = saleService;
		this.saleProductService = saleProductService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SofkaChallengeConsoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Iniciando aplicación");

		log.info("Opción: " + propertiesConf.getType());

		switch (propertiesConf.getType()) {
		case CREATE_PRODUCT: {
			log.info("Generando productos en una nueva colección");
			saleProductService.createCollections();
			break;
		}
		case TOTAL_SALE: {
			log.info("Generando precios totales de las ventas");
			saleService.calculateTotal();
			break;
		}
		default:
			throw new IllegalArgumentException("Opción inválida: " + propertiesConf.getType());
		}

		log.info("Finalizando el proceso");

	}

}
