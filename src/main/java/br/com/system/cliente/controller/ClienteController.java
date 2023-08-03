package br.com.system.cliente.controller;

import br.com.system.cliente.model.dto.ClienteRequest;
import br.com.system.cliente.model.dto.ClienteResponse;
import br.com.system.cliente.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes-v1")
public class ClienteController {

    private final ClientService service;

    @GetMapping("/buscaCliente")
    public ResponseEntity<Flux<ClienteResponse>> buscaTodosClientes(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/salvarCliente")
    public ResponseEntity<Mono<ClienteResponse>> salvarCliente(@RequestBody ClienteRequest request){
        return ResponseEntity.ok(service.save(request));
    }
}

