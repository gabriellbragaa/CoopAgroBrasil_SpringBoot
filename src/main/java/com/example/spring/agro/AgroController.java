package com.example.spring.agro;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000") // Permite acesso do frontend React
@RestController
@RequestMapping("/agro")
public class AgroController {

    @Autowired
    private AgroRepository repository;

    // Criar novo agro (POST)
    @PostMapping
    public ResponseEntity<AgroResponseDTO> createAgro(@RequestBody AgroRequestDTO data) {
        Agro agro = new Agro(data);
        repository.save(agro);
        return ResponseEntity.ok(new AgroResponseDTO(agro));
    }

    // Listar todos (GET)
    @GetMapping
    public List<AgroResponseDTO> getAllAgros() {
        return repository.findAll().stream().map(AgroResponseDTO::new).collect(Collectors.toList());
    }

    // Buscar por ID (GET /{id})
    @GetMapping("/{id}")
    public ResponseEntity<AgroResponseDTO> getAgroById(@PathVariable Long id) {
        return repository.findById(id)
            .map(agro -> ResponseEntity.ok(new AgroResponseDTO(agro)))
            .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar por ID (PUT /{id})
    @PutMapping("/{id}")
    public ResponseEntity<AgroResponseDTO> updateAgro(@PathVariable Long id, @RequestBody AgroRequestDTO data) {
        return repository.findById(id).map(agro -> {
            agro.setTitle(data.getTitle());
            agro.setImage(data.getImage());
            agro.setPrice(data.getPrice());
            repository.save(agro);
            return ResponseEntity.ok(new AgroResponseDTO(agro));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Deletar por ID (DELETE /{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgro(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
