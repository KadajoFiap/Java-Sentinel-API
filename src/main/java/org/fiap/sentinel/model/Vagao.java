package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import oracle.sql.DATE;

@Entity
@Table(name = "VAGAO")
public class Vagao extends PanacheEntity {

    @Column(name = "NUMERO_VAGAO", nullable = false)
    public int numero;

    @Column(name = "STATUS", nullable = false, length = 10)
    public String status;

    @Column(name = "ULTIMA_MANUTENCAO", nullable = false)
    public DATE ultimaManutencao;

    @Column(name = "PROXIMA_MANUTENCAO", nullable = false)
    public DATE proximaManutencao;

    @Column(name = "OBSERVACOES", nullable = false, length = 50)
    public String observacoes;


} 