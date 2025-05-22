package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "ESTACAO")
public class Estacao extends PanacheEntity {

    @Column(name = "NOME_ESTACAO", length = 30)
    public String nomeEstacao;

    @Column(name = "NR_PLATAFORMAS")
    public Integer nrPlataformas;
} 