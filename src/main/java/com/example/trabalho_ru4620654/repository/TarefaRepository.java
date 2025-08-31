package com.example.trabalho_ru4620654.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trabalho_ru4620654.model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository <Tarefa, Long>{
    
}
