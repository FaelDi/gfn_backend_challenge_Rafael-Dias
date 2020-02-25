
package com.wordpress.faeldi.gfn_backend_challenge_RafaelDias.controller;


import com.wordpress.faeldi.gfn_backend_challenge_RafaelDias.model.Customers;
import com.wordpress.faeldi.gfn_backend_challenge_RafaelDias.repository.CustomersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/customers"})
public class CustomersController {

    private CustomersRepository repository;

    CustomersController(CustomersRepository customersRepository) {
        this.repository = customersRepository;
    }


    @GetMapping(path = {"/list"})
    public List<Customers> findAll(){
        System.out.println("Listando clientes");
        return repository.findAll();
    }

    @GetMapping(path = {"/list/{name}"})
    public ResponseEntity findById(@PathVariable String name){
        System.out.println("Listando clientes: "+name);
        return repository.findById(name)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = {"/addCustomer"})
    public Customers create(@RequestBody Customers customers){
        System.out.println("Adicionando cliente: "+customers.getName());
        return repository.save(customers);
    }

    @PutMapping(value="/updateCustomer/{name}")
    public ResponseEntity update(@PathVariable("name") String name,
                                 @RequestBody Customers customers) {
        System.out.println("Alterando cliente: "+customers.getName());
        return repository.findById(name)
                .map(record -> {
                    record.setName(customers.getName());
                    record.setCity(customers.getCity());
                    record.setState(customers.getState());
                    record.setLongitude(customers.getLongitude());
                    record.setLatitude(customers.getLatitude());

                    Customers updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping(path ={"/deleteCustomer/{name}"})
    public ResponseEntity<?> delete(@PathVariable String name) {
        System.out.println("Cliente removido da base de dados: "+name);
        return repository.findById(name)
                .map(record -> {
                    repository.deleteById(name);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}