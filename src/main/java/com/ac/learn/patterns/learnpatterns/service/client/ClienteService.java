package com.ac.learn.patterns.learnpatterns.service.client;

import com.ac.learn.patterns.learnpatterns.entity.cliente.Cliente;
import com.ac.learn.patterns.learnpatterns.service.client.impl.dto.AtualizarClienteDTO;
import com.ac.learn.patterns.learnpatterns.service.client.impl.dto.CriarClientDTO;

public interface ClienteService {
    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    Cliente inserir(CriarClientDTO model);
    Cliente atualizar(Long id, AtualizarClienteDTO model);
    void deletar(Long id);
}
