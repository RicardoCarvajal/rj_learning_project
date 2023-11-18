package com.rj.practices.service.app.controllers;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rj.practices.service.app.documents.Sale;
import com.rj.practices.service.app.documents.SaleProduct;
import com.rj.practices.service.app.services.SaleProductService;
import com.rj.practices.service.app.services.SaleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Tag(name = "Sale", description = "Metodos de la facturación")
@RequestMapping("/api/sale")
public class SaleControllers {

	private final SaleService saleService;
	private final SaleProductService saleProductService;

	@Autowired
	public SaleControllers(SaleService saleService, SaleProductService saleProductService) {
		this.saleService = saleService;
		this.saleProductService = saleProductService;
	}

	@GetMapping
	@Operation(summary = "Obtener facturas", description = "Permite solicitar todas las facturas que hay almacenadas de forma paginada")
	@ApiResponse(content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "[{\"_id\":\"5bd761deae323e45a93ce36d\",\"saleDate\":\"2017-12-25T07:02:51.283+00:00\",\"products\":[{\"name\":\"binder\",\"tags\":[\"school\",\"general\",\"organization\"],\"price\":10.81,\"quantity\":1},{\"name\":\"binder\",\"tags\":[\"school\",\"general\",\"organization\"],\"price\":18,\"quantity\":10},{\"name\":\"pens\",\"tags\":[\"writing\",\"office\",\"school\",\"stationary\"],\"price\":26.84,\"quantity\":5},{\"name\":\"notepad\",\"tags\":[\"office\",\"writing\",\"school\"],\"price\":28.33,\"quantity\":1},{\"name\":\"printer paper\",\"tags\":[\"office\",\"stationary\"],\"price\":14.24,\"quantity\":4},{\"name\":\"laptop\",\"tags\":[\"electronics\",\"school\",\"office\"],\"price\":780.93,\"quantity\":3},{\"name\":\"envelopes\",\"tags\":[\"stationary\",\"office\",\"general\"],\"price\":17.72,\"quantity\":10},{\"name\":\"backpack\",\"tags\":[\"school\",\"travel\",\"kids\"],\"price\":42.56,\"quantity\":1}],\"storeLocation\":\"Denver\",\"customer\":{\"gender\":\"M\",\"age\":29,\"email\":\"losuhse@eronehjod.np\",\"satisfaction\":4},\"couponUsed\":false,\"purchaseMethod\":\"In store\",\"total\":2972.85},{\"_id\":\"5bd761deae323e45a93ce36c\",\"saleDate\":\"2014-11-29T10:09:41.573+00:00\",\"products\":[{\"name\":\"pens\",\"tags\":[\"writing\",\"office\",\"school\",\"stationary\"],\"price\":63.23,\"quantity\":1},{\"name\":\"binder\",\"tags\":[\"school\",\"general\",\"organization\"],\"price\":13.39,\"quantity\":4},{\"name\":\"printer paper\",\"tags\":[\"office\",\"stationary\"],\"price\":35.32,\"quantity\":1},{\"name\":\"notepad\",\"tags\":[\"office\",\"writing\",\"school\"],\"price\":7.27,\"quantity\":5},{\"name\":\"pens\",\"tags\":[\"writing\",\"office\",\"school\",\"stationary\"],\"price\":65.52,\"quantity\":1}],\"storeLocation\":\"Denver\",\"customer\":{\"gender\":\"F\",\"age\":47,\"email\":\"dup@katjewtep.hr\",\"satisfaction\":3},\"couponUsed\":false,\"purchaseMethod\":\"In store\",\"total\":253.98}]")), description = "Ok", responseCode = "200")
	public Mono<ResponseEntity<Flux<Sale>>> getAvailable(
			@Parameter(description = "Número de página") @RequestParam(defaultValue = "0") int page,
			@Parameter(description = "Número de elementos de la página") @RequestParam(defaultValue = "10") int elements,
			@Parameter(description = "Campo por el cual se puede ordenar") @RequestParam(defaultValue = "_id") String sortBy,
			@Parameter(description = "Tipo de ordenamiento") @RequestParam(defaultValue = "ASC") String sortDirection) {

		return Mono
				.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
						.body(this.saleService.getHundredDocuments(page, elements, sortBy, sortDirection)))
				.defaultIfEmpty(ResponseEntity.notFound().build());

	}

	@GetMapping("/{id}")
	@Operation(summary = "Obtener factura", description = "Permite solicitar una factura por su id")
	@ApiResponse(content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "{\"_id\":\"65491e565c49ee027d514f0f\",\"saleDate\":\"2023-11-06T17:11:50.159+00:00\",\"products\":[{\"name\":\"printer paper\",\"tags\":[\"office\",\"stationary\"],\"price\":40.01,\"quantity\":2},{\"name\":\"notepad\",\"tags\":[\"office\",\"writing\",\"school\"],\"price\":35.29,\"quantity\":2},{\"name\":\"pens\",\"tags\":[\"writing\",\"office\",\"school\",\"stationary\"],\"price\":56.12,\"quantity\":5},{\"name\":\"backpack\",\"tags\":[\"school\",\"travel\",\"kids\"],\"price\":77.71,\"quantity\":2},{\"name\":\"notepad\",\"tags\":[\"office\",\"writing\",\"school\"],\"price\":18.47,\"quantity\":2},{\"name\":\"envelopes\",\"tags\":[\"stationary\",\"office\",\"general\"],\"price\":19.95,\"quantity\":8},{\"name\":\"envelopes\",\"tags\":[\"stationary\",\"office\",\"general\"],\"price\":8.08,\"quantity\":3},{\"name\":\"binder\",\"tags\":[\"school\",\"general\",\"organization\"],\"price\":14.16,\"quantity\":3}],\"storeLocation\":\"Denver\",\"customer\":{\"gender\":\"M\",\"age\":42,\"email\":\"cauho@witwuta.sv\",\"satisfaction\":4},\"couponUsed\":true,\"purchaseMethod\":\"Online\",\"total\":849.88}")), description = "Ok", responseCode = "200")
	public Mono<ResponseEntity<Sale>> getSale(@Parameter(description = "Id de la factura") @PathVariable String id) {
		if (id != null && !id.isEmpty()) {
			return this.saleService.getSale(id)
					.map(s -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(s))
					.defaultIfEmpty(ResponseEntity.notFound().build());
		}
		return Mono.just(ResponseEntity.badRequest().build());

	}

	@PostMapping
	@Operation(summary = "Generar factura", description = "Permite registrar una factura")
	@ApiResponse(content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "{\"_id\":\"65491e565c49ee027d514f0f\",\"saleDate\":\"2023-11-06T17:11:50.159+00:00\",\"products\":[{\"name\":\"printer paper\",\"tags\":[\"office\",\"stationary\"],\"price\":40.01,\"quantity\":2},{\"name\":\"notepad\",\"tags\":[\"office\",\"writing\",\"school\"],\"price\":35.29,\"quantity\":2},{\"name\":\"pens\",\"tags\":[\"writing\",\"office\",\"school\",\"stationary\"],\"price\":56.12,\"quantity\":5},{\"name\":\"backpack\",\"tags\":[\"school\",\"travel\",\"kids\"],\"price\":77.71,\"quantity\":2},{\"name\":\"notepad\",\"tags\":[\"office\",\"writing\",\"school\"],\"price\":18.47,\"quantity\":2},{\"name\":\"envelopes\",\"tags\":[\"stationary\",\"office\",\"general\"],\"price\":19.95,\"quantity\":8},{\"name\":\"envelopes\",\"tags\":[\"stationary\",\"office\",\"general\"],\"price\":8.08,\"quantity\":3},{\"name\":\"binder\",\"tags\":[\"school\",\"general\",\"organization\"],\"price\":14.16,\"quantity\":3}],\"storeLocation\":\"Denver\",\"customer\":{\"gender\":\"M\",\"age\":42,\"email\":\"cauho@witwuta.sv\",\"satisfaction\":4},\"couponUsed\":true,\"purchaseMethod\":\"Online\",\"total\":849.88}")), description = "Created", responseCode = "201")
	public Mono<ResponseEntity<Sale>> registerInvoice(
			@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "Factura", content = @Content(examples = @ExampleObject(value = "{\"products\":[{\"name\":\"binder\",\"tags\":[\"school\",\"general\",\"organization\"],\"price\":14.16,\"quantity\":3}],\"storeLocation\":\"Denver\",\"customer\":{\"gender\":\"M\",\"age\":42,\"email\":\"cauho@witwuta.sv\",\"satisfaction\":4},\"couponUsed\":true,\"purchaseMethod\":\"Online\",\"total\":42.48}"))) @RequestBody Sale sale) {
		if (sale.get_id() == null) {
			sale.setSaleDate(new Date());
			return this.saleService.registerInvoice(sale)
					.map(s -> ResponseEntity.created(URI.create("/api/sale/".concat(s.get_id())))
							.contentType(MediaType.APPLICATION_JSON).body(s));
		}
		return Mono.just(ResponseEntity.badRequest().build());

	}

	@GetMapping("/products")
	public Mono<ResponseEntity<Flux<SaleProduct>>> getProduct(
			@Parameter(description = "Campo por el cual se puede ordenar") @RequestParam(defaultValue = "quantity") String sortBy,
			@Parameter(description = "Tipo de ordenamiento") @RequestParam(defaultValue = "DESC") String sortDirection) {
		return Mono
				.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
						.body(this.saleProductService.generateReport(sortDirection, sortBy)))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@GetMapping("/products/date")
	public Mono<ResponseEntity<Flux<SaleProduct>>> getProductByDate(
			@Parameter(description = "Campo por el cual se puede ordenar") @RequestParam(defaultValue = "quantity") String sortBy,
			@Parameter(description = "Tipo de ordenamiento") @RequestParam(defaultValue = "DESC") String sortDirection,
			@Parameter(description = "Tipo de ordenamiento", example = "2015-08-25") @RequestParam() String date1,
			@Parameter(description = "Tipo de ordenamiento", example = "2016-08-25") @RequestParam() String date2) {

		return Mono
				.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
						.body(this.saleProductService.generateReportByDate(sortDirection, sortBy, date1, date2)))
				.defaultIfEmpty(ResponseEntity.notFound().build());

	}

}
