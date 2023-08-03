package br.com.system.cliente.service.impl;

import br.com.system.cliente.model.Client;
import br.com.system.cliente.model.dto.ClienteRequest;
import br.com.system.cliente.model.dto.ClienteResponse;
import br.com.system.cliente.repository.ClientRepository;
import br.com.system.cliente.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    @Transactional
    public Mono<ClienteResponse> save(ClienteRequest dtoRequest) {
        Client client = preparaSaveClient(dtoRequest);
        return repository.save(client).map(ClienteResponse::conversor);
    }

    @Override
    public Flux<ClienteResponse> findAll() {
        return repository.findAll().map(ClienteResponse::conversor);
    }

    private Client preparaSaveClient(ClienteRequest request){
        return Client.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .age(request.getAge())
                .build();
    }
}
