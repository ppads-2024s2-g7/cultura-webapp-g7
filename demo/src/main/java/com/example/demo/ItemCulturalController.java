package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/item-cultural")
public class ItemCulturalController {

    @Autowired
    private ItemCulturalRepository itemCulturalRepository;

    // Criar um novo ItemCultural
    @PostMapping
    public ResponseEntity<ItemCultural> createItemCultural(@RequestBody ItemCultural itemCultural) {
        ItemCultural savedItem = itemCulturalRepository.save(itemCultural);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    // Obter todos os itens culturais
    @GetMapping
    public Iterable<ItemCultural> getAllItemsCultural() {
        return itemCulturalRepository.findAll();
    }

    // Obter um item cultural pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<ItemCultural> getItemCulturalById(@PathVariable("id") Long id) {
        Optional<ItemCultural> item = itemCulturalRepository.findById(id);
        if (item.isPresent()) {
            return new ResponseEntity<>(item.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Buscar itens culturais pelo nome
    @GetMapping("/search")
    public Iterable<ItemCultural> getItemsCulturalByNome(@RequestParam("nome") String nome) {
        return itemCulturalRepository.findByNome(nome);
    }

    // Atualizar um item cultural existente
    @PutMapping("/{id}")
    public ResponseEntity<ItemCultural> updateItemCultural(@PathVariable("id") Long id,
                                                           @RequestBody ItemCultural updatedItemCultural) {
        Optional<ItemCultural> itemOptional = itemCulturalRepository.findById(id);
        if (itemOptional.isPresent()) {
            ItemCultural existingItemCultural = itemOptional.get();
            existingItemCultural.setNome(updatedItemCultural.getNome());
            ItemCultural savedItem = itemCulturalRepository.save(existingItemCultural);
            return new ResponseEntity<>(savedItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Excluir um item cultural
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemCultural(@PathVariable("id") Long id) {
        if (itemCulturalRepository.existsById(id)) {
            itemCulturalRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
