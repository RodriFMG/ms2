package com.example.ms2_funcionaaa.application;

import com.example.ms2_funcionaaa.Domain.Compra;
import com.example.ms2_funcionaaa.Domain.Cliente;

import com.example.ms2_funcionaaa.Service.ClienteService;
//import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Cliente", description = "Cliente de la pagina")
@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:19006")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> AllClientes(){
        List<Cliente> clientes = clienteService.getAllClient();
        return new ResponseEntity<>(clientes,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientById(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.getClientById(id);
        if (clienteOptional.isPresent()) {
            return new ResponseEntity<>(clienteOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<String> PostCliente(@RequestBody Cliente cliente){
        clienteService.saveCliente(cliente);
        return ResponseEntity.status(201).body("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        Optional<Cliente> updatedCliente = clienteService.updateCliente(id,cliente);
        return updatedCliente.isPresent() ? ResponseEntity.status(200).body("Updated") :
                ResponseEntity.status(404).body("Not Found");

    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> patchCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        Optional<Cliente> patchedCLiente = clienteService.patchCliente(id,cliente);
        return patchedCLiente.isPresent() ? ResponseEntity.status(200).body("Updated partially") :
                ResponseEntity.status(404).body("Not Found");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
        Optional<Cliente> deletedCliente = clienteService.deleteCliente(id);
        return deletedCliente.isPresent() ? ResponseEntity.status(200).body("Deleted") : ResponseEntity.status(404).body("Not Found");
    }

    @PostMapping("/realizar_compra/{id}/{id2}")
    public ResponseEntity<String> realizarCompra(@PathVariable Long id, @PathVariable Long id2) {
        clienteService.AgregarCompra(id, id2);
        return ResponseEntity.ok("Compra realizada con éxito");
    }

}