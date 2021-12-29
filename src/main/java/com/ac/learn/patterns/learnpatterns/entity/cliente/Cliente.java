package com.ac.learn.patterns.learnpatterns.entity.cliente;

import com.ac.learn.patterns.learnpatterns.entity.endereco.Endereco;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @ManyToOne
    private Endereco endereco;
}
