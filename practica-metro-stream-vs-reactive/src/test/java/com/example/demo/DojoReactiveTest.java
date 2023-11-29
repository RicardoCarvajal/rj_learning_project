package com.example.demo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class DojoReactiveTest {

	@Test
	void converterData() {
		List<Player> list = CsvUtilFile.getPlayers();
		assert list.size() == 18207;
	}

	@Test
	void jugadoresMayoresA35() {
		List<Player> list = CsvUtilFile.getPlayers();
		Flux<Player> observable = Flux.fromIterable(list);

		observable.filter(jugador -> jugador.getAge() > 35).subscribe(System.out::println);
	}

	@Test
	void jugadoresMayoresA35SegunClub() {
		List<Player> readCsv = CsvUtilFile.getPlayers();
		Flux<Player> observable = Flux.fromIterable(readCsv);

		observable.filter(player -> player.getAge() > 35).distinct().groupBy(Player::getClub)
				.flatMap(groupedFlux -> groupedFlux.collectList().map(list -> {
					Map<String, List<Player>> map = new HashMap<>();
					map.put(groupedFlux.key(), list);
					return map;
				})).subscribe(map -> {
					map.forEach((key, value) -> {
						System.out.println("\n");
						System.out.println(key + ": ");
						value.forEach(System.out::println);
					});
				});

	}

	/* ############################################## */

	@Test
	void ElMejorJugador() {
		List<Player> list = CsvUtilFile.getPlayers();
		Flux<Player> observable = Flux.fromIterable(list);

		observable.collect(Collectors.maxBy(Comparator.comparingInt(j -> j.getWinners()))).map(j -> j.get())
				.subscribe(j -> {
					System.out.println("RESULTADO: 😈​");
					System.out.println("Nombre: " + j.getName());
					System.out.println("Ganados: " + j.getWinners());
				});
	}

	@Test
	void mejorJugadorConNacionalidadFrancia() {
		List<Player> list = CsvUtilFile.getPlayers();
		Flux<Player> observable = Flux.fromIterable(list);

		observable.filter(jugador -> jugador.getNational().equalsIgnoreCase("france"))
				.collect(Collectors.maxBy(Comparator.comparingInt(j -> j.getWinners()))).map(j -> j.get())
				.subscribe(j -> {
					System.out.println("RESULTADO: 😈​");
					System.out.println("Nombre: " + j.getName());
					System.out.println("Ganados: " + j.getWinners());
				});
	}

	@Test
	void clubsAgrupadosPorNacionalidad() {
		List<Player> list = CsvUtilFile.getPlayers();
		Flux<Player> observable = Flux.fromIterable(list);

		observable.distinct().groupBy(Player::getNational, Player::getClub).flatMap(g -> g.collectList().map(l -> {
			Map<String, List<String>> map = new HashMap<>();
			map.put(g.key(), l);
			return map;
		})).subscribe(map -> {
			map.forEach((pais, clubs) -> {
				System.out.println("----------------------------------");
				System.out.println(pais + ": ");
				System.out.println(clubs);
			});
		});
	}

	@Test
	void clubsAgrupadosPorNacionalidadOtraForma() {
		List<Player> list = CsvUtilFile.getPlayers();
		Flux<Player> observable = Flux.fromIterable(list);

		observable.distinct()
				.collect(Collectors.groupingBy(Player::getNational, Collectors.groupingBy(Player::getClub)))
				.subscribe(map -> {
					System.out.println("FUEGO PAPÁ ");
					map.forEach((pais, mapClubs) -> {
						System.out.println("------------------------------");
						System.out.println("CLUBS DE: " + pais.toUpperCase());
						mapClubs.entrySet().forEach(p -> System.out.println(p.getKey()));
					});

				});
	}

	@Test
	void clubConElMejorJugador() {
		List<Player> list = CsvUtilFile.getPlayers();
		Flux<Player> observable = Flux.fromIterable(list);
		observable.distinct().collect(
				Collectors.groupingBy(Player::getClub, Collectors.maxBy(Comparator.comparingInt(p -> p.getWinners()))))
				.subscribe(map -> {
					System.out.println("FUEGO PAPÁ ");
					map.forEach((club, mapClubs) -> {
						System.out.println("------------------------------");
						System.out.println("CLUBS: " + club.toUpperCase());
						System.out.println("Jugador: " + mapClubs.get().getName());
					});

				});
	}

	@Test
	void mejorJugadorSegunNacionalidad() {
		List<Player> list = CsvUtilFile.getPlayers();
		Flux<Player> observable = Flux.fromIterable(list);

		observable.distinct().collect(Collectors.groupingBy(Player::getNational,
				Collectors.maxBy(Comparator.comparingInt(p -> p.getWinners())))).subscribe(map -> {
					System.out.println("FUEGO PAPÁ ");
					map.forEach((pais, mapClubs) -> {
						System.out.println("------------------------------");
						System.out.println("PAIS: " + pais.toUpperCase());
						System.out.println("Jugador: " + mapClubs.get().getName());
					});

				});
	}

	@Test
	void clubConElMejorJugador2() {
		List<Player> list = CsvUtilFile.getPlayers();
		Flux<Player> observable = Flux.fromIterable(list);

		observable.flatMap(p -> {
			return Mono.just(p);
		}).distinct().collect(
				Collectors.groupingBy(Player::getClub, Collectors.maxBy(Comparator.comparingInt(p -> p.getWinners()))))
				.flux().subscribe(map -> {
					System.out.println("FUEGO PAPÁ ");
					map.forEach((club, mapClubs) -> {
						System.out.println("------------------------------");
						System.out.println("CLUBS: " + club.toUpperCase());
						System.out.println("Jugador: " + mapClubs.get().getName());
					});

				});

	}

	@Test
	void ElMejorJugador2() {

		List<Player> list = CsvUtilFile.getPlayers();
		Flux<Player> observable = Flux.fromIterable(list);

		observable.collect(Collectors.maxBy(Comparator.comparingInt(j -> j.getWinners()))).map(j -> j.get()).flux()
				.subscribe(j -> {
					System.out.println("RESULTADO: 😈​");
					System.out.println("Nombre: " + j.getName());
					System.out.println("Ganados: " + j.getWinners());
				});
	}

}
