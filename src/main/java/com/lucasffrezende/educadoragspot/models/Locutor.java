package com.lucasffrezende.educadoragspot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_locutor")
public class Locutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

}
