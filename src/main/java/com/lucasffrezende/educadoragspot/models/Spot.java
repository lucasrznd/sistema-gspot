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
    @Column(name = "id")
    private Long codigo;

    @Column(name = "spot_date")
    private LocalDate data;

    @Column(name = "title")
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "announcer_id")
    private Locutor locutor;

    @Column(name = "duration")
    private Double duracao;

    @Column(name = "active_contract")
    private boolean contratoAtivo;

    @Column(name = "price")
    private Double preco;

}
