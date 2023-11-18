package com.rj.practices.service.app;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rj.practices.service.app.model.Comments;
import com.rj.practices.service.app.model.User;
import com.rj.practices.service.app.model.UserComments;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ModelSpringBootReactorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ModelSpringBootReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		practiceJust(false);
		practiceIterable(false);
		practiceFlatMap(false);
		practiceUserToString(false);
		practiceFluxToMono(false);
		practiceMergeFlux(false);
		practiceMergeFluxZipWith(false);
		practiceMergeFluxZipWithTwo(false);
		practiceRange(false);
		practiceInterval(false);
		practiceDelay(false);
		practiceIntervalInfinite(false);
		practiceIntervalInfiniteButWithError(false);
		practiceCreate(false);
		practiceBackPressure(false);
		practiceBackPressuretwo(true);
	}
	
	private void practiceBackPressuretwo(boolean execute) {
		if (execute) {
			System.out.println("#######################Ejemplo16###############");
			Flux.range(1, 30)
				.log()
				.limitRate(20)
				.subscribe(System.out::println);

		}
	}

	private void practiceBackPressure(boolean execute) {
		if (execute) {
			System.out.println("#######################Ejemplo15###############");
			Flux.range(1, 30).log().subscribe(new Subscriber<Integer>() {

				private Subscription s;

				private Integer limit = 20;
				private Integer consumer = 0;
				
				@Override
				public void onSubscribe(Subscription s) {
					this.s = s;
					s.request(limit);
				}

				@Override
				public void onNext(Integer t) {
					System.out.println(t.toString());
					consumer++;
					if(consumer == limit) {
						consumer=0;
						s.request(limit);
					}
				}

				@Override
				public void onError(Throwable t) {

				}

				@Override
				public void onComplete() {

				}
			});

		}
	}

	private void practiceCreate(boolean execute) throws InterruptedException {
		if (execute) {
			System.out.println("#######################Ejemplo14###############");

			Flux.create(emiter -> {
				Timer timer = new Timer();
				timer.schedule(new TimerTask() {

					private Integer counter = 0;

					@Override
					public void run() {
						emiter.next(++counter);
						if (counter == 10) {
							timer.cancel();
							emiter.complete();
						}
					}
				}, 1000, 1000);
			}).doOnNext(System.out::println).doOnComplete(() -> System.out.println("Termino el proceso")).subscribe();

		}
	}

	private void practiceIntervalInfiniteButWithError(boolean execute) throws InterruptedException {
		if (execute) {
			System.out.println("#######################Ejemplo13###############");

			CountDownLatch count = new CountDownLatch(1);

			Flux.interval(Duration.ofSeconds(1)).doOnTerminate(count::countDown).flatMap(i -> {
				if (i >= 5) {
					return Flux.error(new InterruptedException("solo puede tener un rango de 5"));
				}
				return Flux.just(i);
			}).map(i -> "Hola flux " + i).retry(3).subscribe(System.out::println,
					e -> System.out.println(e.getMessage()));

			count.await();
		}
	}

	private void practiceIntervalInfinite(boolean execute) {
		if (execute) {
			System.out.println("#######################Ejemplo12###############");

			CountDownLatch count = new CountDownLatch(1);

			Flux.interval(Duration.ofSeconds(1)).doOnTerminate(count::countDown).map(i -> "Hola flux " + i)
					.doOnNext(System.out::println).subscribe();

			try {
				count.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	private void practiceDelay(boolean execute) {
		if (execute) {
			System.out.println("#######################Ejemplo11###############");

			Flux<Integer> rango = Flux.range(1, 12)
					.delayElements(Duration.ofSeconds(1))
					.doOnNext(System.out::println);
			/*
			 * Este metodo no se debe usar ya que en programacion reactiva no podemos hacer
			 * esto solo es para visualizar el ejemplo del deley
			 */
			rango.blockLast();

		}
	}

	private void practiceInterval(boolean execute) {
		if (execute) {
			System.out.println("#######################Ejemplo10###############");

			Flux<Integer> rango = Flux.range(1, 12);
			Flux<Long> retraso = Flux.interval(Duration.ofSeconds(1));

			rango.zipWith(retraso, (ra, re) -> ra).doOnNext(i -> System.out.println(i.toString()))

					/*
					 * Este metodo no se debe usar ya que en programacion reactiva no podemos hacer
					 * esto solo es para visualizar el ejemplo del interval
					 */
					.blockLast();

		}
	}

	private void practiceRange(boolean execute) {
		if (execute) {
			System.out.println("#######################Ejemplo9###############");
			Flux.just(1, 2, 3, 4).map(i -> i * 2)
					.zipWith(Flux.range(0, 4),
							(uno, dos) -> String.format("Primer flux: %d, Segundo flux: %d", uno, dos))
					.subscribe(texto -> System.out.println(texto));

		}
	}

	private void practiceMergeFluxZipWithTwo(boolean execute) {
		if (execute) {
			System.out.println("#######################Ejemplo8###############");
			Mono<User> monoUser = Mono.fromCallable(() -> new User("Ricardo", "Carvajal"));

			Mono<Comments> monoComments = Mono.fromCallable(() -> {
				Comments comments = new Comments();
				comments.addComment("Ricardo tiene 39 años de edad");
				comments.addComment("Su profecion es programación");
				return comments;
			});

			Mono<UserComments> userComMono = monoUser.zipWith(monoComments).map(tuple -> {
				User u = tuple.getT1();
				Comments c = tuple.getT2();
				return new UserComments(u, c);
			});

			userComMono.subscribe(uc -> System.out.println(uc.toString()));

		}
	}

	private void practiceMergeFluxZipWith(boolean execute) {
		if (execute) {
			System.out.println("#######################Ejemplo7###############");
			Mono<User> monoUser = Mono.fromCallable(() -> new User("Ricardo", "Carvajal"));

			Mono<Comments> monoComments = Mono.fromCallable(() -> {
				Comments comments = new Comments();
				comments.addComment("Ricardo tiene 39 años de edad");
				comments.addComment("Su profecion es programación");
				return comments;
			});

			Mono<UserComments> userComMono = monoUser.zipWith(monoComments,
					(user, comments) -> new UserComments(user, comments));
			userComMono.subscribe(uc -> System.out.println(uc.toString()));

		}
	}

	private void practiceMergeFlux(boolean execute) {
		if (execute) {
			System.out.println("#######################Ejemplo6###############");
			Mono<User> monoUser = Mono.fromCallable(() -> new User("Ricardo", "Carvajal"));

			Mono<Comments> monoComments = Mono.fromCallable(() -> {
				Comments comments = new Comments();
				comments.addComment("Ricardo tiene 39 años de edad");
				comments.addComment("Su profecion es programación");
				return comments;
			});

			monoUser.flatMap(u -> monoComments.map(c -> new UserComments(u, c)))
					.subscribe(uc -> System.out.println("En suscribe: " + uc.toString()));
		}
	}

	private void practiceFluxToMono(boolean execute) {
		if (execute) {
			System.out.println("#######################Ejemplo5###############");
			List<User> userList = new ArrayList<User>();
			userList.add(new User("Ricardo", "Carvajal"));
			userList.add(new User("Emma", "Carvajal"));
			userList.add(new User("Eimy", "Reina"));
			userList.add(new User("Emily", "Carvajal"));

			Flux.fromIterable(userList).collectList().subscribe(list -> {
				list.forEach(item -> System.out.println("En suscribe: " + item.toString()));
			});
		}
	}

	private void practiceUserToString(boolean execute) {
		if (execute) {
			System.out.println("#######################Ejemplo4###############");
			List<User> userList = new ArrayList<User>();
			userList.add(new User("Ricardo", "Carvajal"));
			userList.add(new User("Emma", "Carvajal"));
			userList.add(new User("Eimy", "Reina"));
			userList.add(new User("Emily", "Carvajal"));

			Flux.fromIterable(userList).map(user -> {
				return user.getName().concat(" ").concat(user.getLastName());
			}).flatMap(user -> {
				if (user.contains("Carvajal")) {
					return Mono.just(user);
				} else {
					return Mono.empty();
				}
			}).map(user -> {
				String name = user.toUpperCase();
				return name;
			}).subscribe(user -> System.out.println("En suscribe: " + user.toString()));
		}
	}

	private void practiceFlatMap(boolean execute) {
		if (execute) {
			System.out.println("#######################Ejemplo3###############");
			List<String> userList = new ArrayList<String>();
			userList.add("Emily Reina");
			userList.add("Emma Carvajal");
			userList.add("Eimy Reina");
			userList.add("Ricardo Carvajal");

			Flux.fromIterable(userList).map(nombre -> {
				if (!nombre.isEmpty()) {
					return new User(nombre.split(" ")[0].toUpperCase(), nombre.split(" ")[1].toUpperCase());
				} else {
					return new User();
				}
			}).flatMap(user -> {
				if (user.getLastName().equalsIgnoreCase("Carvajal")) {
					return Mono.just(user);
				} else {
					return Mono.empty();
				}
			}).map(user -> {
				String name = user.getName().toLowerCase();
				user.setName(name);
				return user;
			}).subscribe(user -> System.out.println("En suscribe: " + user.toString()));
		}
	}

	private void practiceIterable(boolean execute) {
		if (execute) {
			System.out.println("#######################Ejemplo2###############");
			List<String> userList = new ArrayList<String>();
			userList.add("Emily Reina");
			userList.add("Emma Carvajal");
			userList.add("Eimy Reina");
			userList.add("Ricardo Carvajal");

			Flux<String> nombres = Flux.fromIterable(userList);

			Flux<User> usuarios = nombres.map(nombre -> {
				if (!nombre.isEmpty()) {
					return new User(nombre.split(" ")[0].toUpperCase(), nombre.split(" ")[1].toUpperCase());
				} else {
					return new User("Sin nombre", "Sin apellido");
				}
			}).filter(user -> user.getLastName().equalsIgnoreCase("Carvajal")).doOnNext(user -> {
				if (user.getLastName().equalsIgnoreCase("Sin apellido")) {
					throw new RuntimeException("Nombre en blanco");
				}
				System.out.println(user.toString());
			}).map(user -> {
				String name = user.getName().toLowerCase();
				user.setName(name);
				return user;
			});

			// El suscribe lleva tres parametros
			usuarios.subscribe(element -> System.out.println("En suscribe: " + element),
					error -> System.out.println(error.getMessage()), new Runnable() {
						@Override
						public void run() {
							System.out.println("Flujo terminado".toUpperCase());
						}
					});
		}
	}

	private void practiceJust(boolean execute) {
		if (execute) {
			System.out.println("#######################Ejemplo1###############");
			List<String> userList = new ArrayList<String>();
			userList.add("Emily Reina");
			userList.add("Emma Carvajal");
			userList.add("Eimy Reina");
			userList.add("Ricardo Carvajal");

			Flux<User> nombres = Flux.just("Emily Carvajal", "Emma Carvajal", "Ricardo Carvajal", "Eimy Reina")
					.map(nombre -> {
						if (!nombre.isEmpty()) {
							return new User(nombre.split(" ")[0].toUpperCase(), nombre.split(" ")[1].toUpperCase());
						} else {
							return new User("Sin nombre", "Sin apellido");
						}
					}).filter(user -> user.getLastName().equalsIgnoreCase("Carvajal")).doOnNext(user -> {
						if (user.getLastName().equalsIgnoreCase("Sin apellido")) {
							throw new RuntimeException("Nombre en blanco");
						}
						System.out.println(user.toString());
					}).map(user -> {
						String name = user.getName().toLowerCase();
						user.setName(name);
						return user;
					});

			// El suscribe lleva tres parametros
			nombres.subscribe(element -> System.out.println("En suscribe: " + element),
					error -> System.out.println(error.getMessage()), new Runnable() {
						@Override
						public void run() {
							System.out.println("Flujo terminado".toUpperCase());
						}
					});
		}
	}

}
