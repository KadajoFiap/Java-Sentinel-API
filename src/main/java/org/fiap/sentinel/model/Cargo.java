package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CARGO")
public class Cargo extends PanacheEntity {

    @Column(name = "NOME_CARGO", unique = true, length = 50)
    public String nomeCargo;

    @Column(name = "SALARIO_BASE")
    public Double salarioBase;
} 