package com.lucasffrezende.educadoragspot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "tb_empresa")
@ToString
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long codigo;

    @Column(name = "name")
    private String nome;

    @Column(name = "phone_number")
    private String telefone;

}
