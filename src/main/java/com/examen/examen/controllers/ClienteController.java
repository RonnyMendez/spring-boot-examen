package com.examen.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examen.examen.models.Cliente;
import com.examen.examen.services.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long codigo) {
        Cliente cliente = clienteService.getClienteById(codigo);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente createdCliente = clienteService.createCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCliente);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long codigo, @RequestBody Cliente cliente) {
        Cliente updatedCliente = clienteService.updateCliente(codigo, cliente);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long codigo) {
        clienteService.deleteCliente(codigo);
        return ResponseEntity.noContent().build();
    }
}
