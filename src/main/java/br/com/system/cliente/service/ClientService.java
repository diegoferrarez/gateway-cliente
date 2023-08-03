package br.com.system.cliente.service;

import br.com.system.cliente.model.dto.ClienteRequest;
import br.com.system.cliente.model.dto.ClienteResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {

    Mono<ClienteResponse> save(ClienteRequest request);

    Flux<ClienteResponse> findAll();
}
