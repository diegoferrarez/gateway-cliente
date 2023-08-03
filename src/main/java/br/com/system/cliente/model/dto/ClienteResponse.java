package br.com.system.cliente.model.dto;

import br.com.system.cliente.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse {

    private String name;
    private String surname;
    private int age;

    public static ClienteResponse conversor(Client c){
        return ClienteResponse.builder()
                .name(c.getName())
                .surname(c.getSurname())
                .age(c.getAge())
                .build();
    }
}
