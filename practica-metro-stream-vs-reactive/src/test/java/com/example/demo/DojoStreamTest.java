package com.example.demo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class DojoStreamTest {

	@Test
	void converterData() {
		List<Player> list = CsvUtilFile.getPlayers();
		assert list.size() == 18207;
	}

	@Test
	void jugadoresMayoresA35() {
		List<Player> list = CsvUtilFile.getPlayers();
		Set<Player> result = list.stream().filter(jugador -> jugador.getAge() > 35).collect(Collectors.toSet());
		result.forEach(System.out::println);
	}

	@Test
	void jugadoresMayoresA35SegunClub() {
		List<Player> list = CsvUtilFile.getPlayers();
		Map<String, List<Player>> result = list.stream().filter(player -> player.getAge() > 35).distinct()
				.collect(Collectors.groupingBy(Player::getClub));

		result.forEach((key, jugadores) -> {
			System.out.println("\n");
			System.out.println(key + ": ");
			jugadores.forEach(System.out::println);
		});

	}

	/* ############################################## */

	@Test
	void mejorJugadorConNacionalidadFrancia() {
		List<Player> list = CsvUtilFile.getPlayers();

		Player player = list.stream().filter(p -> p.getNational().equalsIgnoreCase("france"))
				.collect(Collectors.maxBy(Comparator.comparingInt(p -> p.getWinners()))).get();

		System.out.println("\nMEJOR JUGADOR DE FRANCIA#####################");
		System.out.println("Nombre: " + player.getName() + " Nacionalidad: " + player.getNational());
		System.out.println("Ganados: " + player.getWinners());
		System.out.println("##############################################");

	}

	@Test
	void clubsAgrupadosPorNacionalidad() {
		List<Player> list = CsvUtilFile.getPlayers();

		list.stream().collect(Collectors.groupingBy(Player::getNational, Collectors.groupingBy(Player::getClub)))
				.forEach((national, clubs) -> {
					System.out.println(national.toUpperCase() + ": ");
					clubs.forEach((club, player) -> {
						System.out.println(club);
					});
					System.out.println("-------------------------");
				});

	}

	@Test
	void clubConElMejorJugador() {
		List<Player> list = CsvUtilFile.getPlayers();

		list.stream().collect(Collectors.groupingBy(Player::getClub)).forEach((clubs, players) -> {
			System.out.println(clubs.toUpperCase() + ": ");
			Player player = players.stream().collect(Collectors.maxBy(Comparator.comparingInt(p -> p.getWinners())))
					.get();
			System.out.println(player.getName() + ": ");
			System.out.println("-------------------------\n");

		});

	}

	@Test
	void ElMejorJugador() {
		List<Player> list = CsvUtilFile.getPlayers();

		Player player = list.stream().collect(Collectors.maxBy(Comparator.comparingInt(p -> p.getWinners()))).get();

		System.out.println("\nMEJOR JUGADOR#####################");
		System.out.println("Nombre: " + player.getName() + " Nacionalidad: " + player.getNational());
		System.out.println("Ganados: " + player.getWinners());
		System.out.println("##############################################");
	}

	@Test
	void mejorJugadorSegunNacionalidad() {
		List<Player> list = CsvUtilFile.getPlayers();

		list.stream().collect(Collectors.groupingBy(Player::getNational)).forEach((nationals, players) -> {
			System.out.println(nationals.toUpperCase() + ": ");
			Player player = players.stream().collect(Collectors.maxBy(Comparator.comparingInt(p -> p.getWinners())))
					.get();

			System.out.println(player.getName() + ": ");
			System.out.println("-------------------------\n");

		});
	}

}
