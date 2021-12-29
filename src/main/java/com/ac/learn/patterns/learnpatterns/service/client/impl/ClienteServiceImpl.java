package com.ac.learn.patterns.learnpatterns.service.client.impl;

import com.ac.learn.patterns.learnpatterns.entity.cliente.Cliente;
import com.ac.learn.patterns.learnpatterns.entity.cliente.ClienteRepository;
import com.ac.learn.patterns.learnpatterns.entity.endereco.Endereco;
import com.ac.learn.patterns.learnpatterns.entity.endereco.EnderecoRepository;
import com.ac.learn.patterns.learnpatterns.service.client.ClienteService;
import com.ac.learn.patterns.learnpatterns.service.client.impl.dto.AtualizarClienteDTO;
import com.ac.learn.patterns.learnpatterns.service.client.impl.dto.CriarClientDTO;
import com.ac.learn.patterns.learnpatterns.service.viacep.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente inserir(CriarClientDTO model) {

        Cliente cliente = new Cliente();
        cliente.setNome(model.getNome());
        cliente.setEndereco(this.buscaEndereco(model.getCep()));
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizar(Long id, AtualizarClienteDTO model) {

        Cliente cliente = clienteRepository.findById(id).orElse(null);

        if (cliente == null) {
            return null;
        }

        cliente.setNome(model.getNome());
        cliente.setEndereco(this.buscaEndereco(model.getCep()));

        return clienteRepository.save(cliente);
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private Endereco buscaEndereco(String cep) {
        return enderecoRepository.findById(cep).orElseGet(() -> {

            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
    }

}