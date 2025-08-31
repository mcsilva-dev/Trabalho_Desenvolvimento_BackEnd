package com.example.trabalho_ru4620654.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trabalho_ru4620654.model.Tarefa;
import com.example.trabalho_ru4620654.repository.TarefaRepository;

@RestController
@RequestMapping({ "/tarefas" })
public class TarefaController {
    private TarefaRepository repository;

    TarefaController(TarefaRepository tarefaRepository) {
		this.repository = tarefaRepository;
	}

    @GetMapping("/listar")
    public List<?> findAll() {
        return repository.findAll();
    }

    @GetMapping(path={ "/{id}" })
    public ResponseEntity<?> findById(@PathVariable long id){
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path="/criar")
    public Tarefa create(@RequestBody Tarefa tarefa){
        return repository.save(tarefa);
    }

    @PutMapping(value = { "/editar/{id}" })
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Tarefa tarefa){
        return repository.findById(id).map(record -> {
            record.setNome(tarefa.getNome());
            record.setDataEntrega(tarefa.getDataEntrega());
            record.setResponsavel(tarefa.getResponsavel());
            Tarefa updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = { "/excluir/{id}" })
    public ResponseEntity<?> delete(@PathVariable long id){
        return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
    
}
