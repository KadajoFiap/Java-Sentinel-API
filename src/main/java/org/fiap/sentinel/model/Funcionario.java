package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import oracle.sql.DATE;

import java.time.LocalDate;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario extends PanacheEntity {

    @Column(name = "NOME", nullable = false, length = 50)
    public String nome;

    @Column(name = "CPF", nullable = false, length = 11)
    public String cpf;

    @Column(name = "STATUS", nullable = false)
    public Integer status;

    @Column(name = "SEXO_FUNCIONARIO", length = 1)
    public String sexoFuncionario;

    @ManyToOne
    @JoinColumn(name = "FK_CARGO_ID_CARGO")
    public Cargo cargo;

    @Column(name = "DEPARTAMENTO", nullable = false, length = 35)
    public String departamento;

    @Column(name = "DATA_CONTRATACAO", nullable = false)
    public DATE dataContratacao;

    @Column(name = "EMAIL", nullable = false, length = 35)
    public String email;

    @Column(name = "TELEFONE", nullable = false, length = 13)
    public String telefone;
} 