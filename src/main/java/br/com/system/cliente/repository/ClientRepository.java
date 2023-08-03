package br.com.system.cliente.repository;

import br.com.system.cliente.model.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {
}
