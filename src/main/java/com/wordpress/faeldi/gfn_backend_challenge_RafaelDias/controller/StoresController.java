package com.wordpress.faeldi.gfn_backend_challenge_RafaelDias.controller;

import com.wordpress.faeldi.gfn_backend_challenge_RafaelDias.model.Stores;
import com.wordpress.faeldi.gfn_backend_challenge_RafaelDias.repository.StoresRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/stores"})
public class StoresController {

    private StoresRepository repository;

    StoresController(StoresRepository storesRepository) {
        this.repository = storesRepository;
    }

    @GetMapping(path = {"/list"})
    public List<Stores> findAll() {

        System.out.println("Listando Lojas");
        return repository.findAll();
    }

    @GetMapping(path = {"/list/{name}"})
    public ResponseEntity findById(@PathVariable String name) {
        System.out.println("Listando Loja: "+name);
        return repository.findById(name)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = {"/addStore"})
    public Stores create(@RequestBody Stores stores) {

        System.out.println("Adicionando Loja: "+stores.getName());
        return repository.save(stores);
    }

    @PutMapping(value="/updateStore/{name}")
    public ResponseEntity update(@PathVariable("name") String name,
                                 @RequestBody Stores stores) {
        System.out.println("Alterando Loja: "+stores.getName());
        return repository.findById(name)
                .map(record -> {
                    record.setName(stores.getName());
                    record.setCity(stores.getCity());
                    record.setState(stores.getState());
                    record.setLongitude(stores.getLongitude());
                    record.setLatitude(stores.getLatitude());
                    record.setRevenue(stores.getRevenue());
                    Stores updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping(path ={"/deleteStore/{name}"})
    public ResponseEntity<?> delete(@PathVariable String name) {
        System.out.println("Loja removida da base de dados: "+name);
        return repository.findById(name)
                .map(record -> {
                    repository.deleteById(name);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}