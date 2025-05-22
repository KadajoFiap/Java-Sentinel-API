package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "LINHA")
public class Linha extends PanacheEntity {

    @Column(name = "NOME", nullable = false, length = 100)
    public String nome;

    @Column(name = "DESCRICAO", length = 200)
    public String descricao;

    @Column(name = "EXTENCAO")
    public Double extencao;

    @Column(name = "REGIOES_PERTENC", length = 30)
    public String regioesPertenc;
} 