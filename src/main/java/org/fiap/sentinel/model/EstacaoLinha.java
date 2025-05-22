package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "ESTACAO_LINHA")
@IdClass(EstacaoLinhaId.class)
public class EstacaoLinha extends PanacheEntityBase {

    @ManyToOne
    @JoinColumn(name = "FK_ESTACAO_ID_ESTACAO")
    @Id
    public Estacao estacao;

    @ManyToOne
    @JoinColumn(name = "FK_LINHA_ID_LINHA")
    @Id
    public Linha linha;
} 