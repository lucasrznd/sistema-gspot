package com.lucasffrezende.educadoragspot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_spot")
@ToString
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;

    @Column(name = "data_spot")
    private LocalDate data;

    @Column(name = "titulo")
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "empresa_codigo")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "locutor_codigo")
    private Locutor locutor;

    @JoinColumn(name = "duracao")
    private Double duracao;

    @JoinColumn(name = "contrato_ativo")
    private boolean contratoAtivo;

    @JoinColumn(name = "preco")
    private Double preco;

}
