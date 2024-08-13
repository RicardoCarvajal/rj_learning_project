package com.danzaseimily.app.services.handlers;

import com.danzaseimily.app.services.dtos.ResponseDto;
import com.danzaseimily.app.services.exceptions.ValidationsParamException;
import com.danzaseimily.app.services.models.Account;
import com.danzaseimily.app.services.usecase.CreateAccoutnUseCase;
import com.danzaseimily.app.services.usecase.GetAccountUseCase;
import com.danzaseimily.app.services.utils.ValidationsParameters;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.File;
import java.util.UUID;

@Component
public class AccountHandler {

    private final CreateAccoutnUseCase createAccount;
    private final GetAccountUseCase getAccount;
    private final ValidationsParameters validations;


    @Value("${config.uploads.path}")
    private String path;

    public AccountHandler(CreateAccoutnUseCase createAccount, GetAccountUseCase getAccount, ValidationsParameters validations) {
        this.createAccount = createAccount;
        this.getAccount = getAccount;
        this.validations = validations;
    }

    public Mono<ServerResponse> get(ServerRequest request) {
        String idRequest = request.pathVariable("id");
        return getAccount.get(idRequest).flatMap(account -> {
                    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(ResponseDto.builder().code(HttpResponseStatus.OK.toString()).message("Cuenta encontrada").data(account).build());
                }).switchIfEmpty(ServerResponse.status(HttpResponseStatus.NOT_FOUND.code()).contentType(MediaType.APPLICATION_JSON).bodyValue(ResponseDto.builder().code(HttpResponseStatus.NOT_FOUND.toString()).message("No existe la cuenta").build()))
                .onErrorResume(e -> {
                    return ServerResponse.status(HttpResponseStatus.INTERNAL_SERVER_ERROR.code()).contentType(MediaType.APPLICATION_JSON).bodyValue(ResponseDto.builder().code(HttpResponseStatus.INTERNAL_SERVER_ERROR.toString()).message("Error de la aplicacion" + " " + e.getMessage()).build());
                });
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        Mono<Account> monoAccount = request.bodyToMono(Account.class);
        return monoAccount.flatMap(account -> {
            return validations.valid(account).flatMap(createAccount::create).flatMap(result -> {
                return ServerResponse.status(HttpResponseStatus.CREATED.code()).contentType(MediaType.APPLICATION_JSON).bodyValue(ResponseDto.builder().code(HttpResponseStatus.CREATED.toString()).message("Cuenta creada").data(result).build());
            });
        }).onErrorResume(ValidationsParamException.class, e -> {
            return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON).bodyValue(e.getMessageResponse());
        }).onErrorResume(e -> {
            return ServerResponse.status(HttpResponseStatus.INTERNAL_SERVER_ERROR.code()).contentType(MediaType.APPLICATION_JSON).bodyValue(ResponseDto.builder().code(HttpResponseStatus.INTERNAL_SERVER_ERROR.toString()).message("Error de la aplicacion" + " " + e.getMessage()).build());
        });
    }

    public Mono<ServerResponse> uploadIMG(ServerRequest request) {
        String idRequest = request.pathVariable("id");
        return request.multipartData().map(multipart -> {
                    return multipart.toSingleValueMap().get("file");
                }).cast(FilePart.class).flatMap(file -> {
                    return getAccount.get(idRequest).flatMap(account -> {
                        account.setPhoto(UUID.randomUUID().toString() + "-" + file.filename()
                                .replace(" ", "-")
                                .replace(":", "")
                                .replace("//", ""));
                        System.out.println(path + account.getPhoto());
                        return file.transferTo(new File(path + account.getPhoto())).then(createAccount.create(account));
                    });
                }).flatMap(result -> {
                    return ServerResponse.status(HttpResponseStatus.CREATED.code()).contentType(MediaType.APPLICATION_JSON).bodyValue(ResponseDto.builder().code(HttpResponseStatus.CREATED.toString()).message("Cuenta actualizada").data(result).build());
                }).switchIfEmpty(ServerResponse.status(HttpResponseStatus.NOT_FOUND.code()).contentType(MediaType.APPLICATION_JSON).bodyValue(ResponseDto.builder().code(HttpResponseStatus.NOT_FOUND.toString()).message("No existe la cuenta").build()))
                .onErrorResume(e -> {
                    return ServerResponse.status(HttpResponseStatus.INTERNAL_SERVER_ERROR.code()).contentType(MediaType.APPLICATION_JSON).bodyValue(ResponseDto.builder().code(HttpResponseStatus.INTERNAL_SERVER_ERROR.toString()).message("Error de la aplicacion" + " " + e.getMessage()).build());
                });
    }
}
