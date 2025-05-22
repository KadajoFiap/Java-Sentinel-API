package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TERCERIZADO")
public class Tercerizado extends PanacheEntity {

    @OneToOne
    @JoinColumn(name = "FK_FUNCIONARIO_ID_FUNCIONARIO")
    public Funcionario funcionario;

    @Column(name = "EMPRESA", nullable = false, length = 100)
    public String empresa;

    @Column(name = "DATA_CONTRATO", nullable = false)
    public LocalDate dataContrato;
} 