package com.clientecrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientecrud.model.Cliente;
import com.clientecrud.repository.ClienteJdbcRepository;
import com.clientecrud.repository.ClienteRepository;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteJdbcRepository clienteJdbcRepository;

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> consultarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> consultarTodos() {
        return clienteJdbcRepository.findAll(); 
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            cliente.setId(id);  
            return clienteRepository.save(cliente);
        }
        return null;  
    }

	public Object save(Cliente any) {
		return null;
	}

	public Object findById(long l) {
		return null;
	}
}