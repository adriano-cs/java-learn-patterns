package com.ac.learn.patterns.learnpatterns.service.client.impl.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class AtualizarClienteDTO {

    @NotNull(message = "O campo nome é obrigatório")
    private String nome;

    @NotNull(message = "O campo cep é obrigatório")
    @Min(value = 8, message = "O campo cep deve conter 08 caracteres")
    private String cep;
}