package com.example.demo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Player> list = CsvUtilFile.getPlayers();
		Flux<Player> observable = Flux.fromIterable(list);

		observable.collect(Collectors.maxBy(Comparator.comparingInt(j -> j.getWinners()))).map(j -> j.get()).flux()
				.subscribe(j -> {
					System.out.println("RESULTADO: 😈​");
					System.out.println("Nombre: " + j.getName());
					System.out.println("Ganados: " + j.getWinners());
				});

		List<Player> lista = CsvUtilFile.getPlayers();
		Flux<Player> fluxLista = Flux.fromIterable(lista);

		fluxLista.filter(jugador -> jugador.getNational().equalsIgnoreCase("france"))
				.collect(Collectors.maxBy(Comparator.comparingInt(j -> j.getWinners()))).map(j -> j.get())
				.subscribe(j -> {
					System.out.println("RESULTADO: 😈​");
					System.out.println("Nombre: " + j.getName());
					System.out.println("Ganados: " + j.getWinners());
				});

	}

}
