package com.example.trabalho_ru4620654.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Tarefa {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome", nullable = false, unique = true)
    private String nome;
    @Column(name="dataEntrega", nullable = false, columnDefinition = "DATE")
    private LocalDate dataEntrega;
    @Column(name="responsavel", nullable = false)
    private String responsavel;
    
}
