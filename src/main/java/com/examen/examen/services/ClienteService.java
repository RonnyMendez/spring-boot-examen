package com.examen.examen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.examen.models.Cliente;
import com.examen.examen.repositories.ClienteRepository;

import java.util.List;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long codigo) {
        return clienteRepository.findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con código: " + codigo));
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long codigo, Cliente cliente) {
        if (!clienteRepository.existsById(codigo)) {
            throw new IllegalArgumentException("Cliente no encontrado con código: " + codigo);
        }
        cliente.setCodigo(codigo); // asegura que el cliente tenga el código correcto para la actualización
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long codigo) {
        clienteRepository.deleteById(codigo);
    }
}
