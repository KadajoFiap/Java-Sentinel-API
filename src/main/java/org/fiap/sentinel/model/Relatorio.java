package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import oracle.sql.DATE;

@Entity
@Table(name = "RELATORIO")
public class Relatorio extends PanacheEntity {

    @Column(name = "NOME_RELATORIO", nullable = false, length = 35)
    public String nome;

    @Column(name = "RAZAO", nullable = false)
    public float razao;

    @Column(name = "DATA_EMISSAO", nullable = false)
    public DATE data;

    @Column(name = "URL_RELATORIO", nullable = false, length = 100)
    public String urlRelatorio;
}
