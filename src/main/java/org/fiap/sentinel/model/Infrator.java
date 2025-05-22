package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import oracle.sql.DATE;

import java.time.LocalDate;

@Entity
@Table(name = "INFRATOR")
public class Infrator extends PanacheEntity {

    @Column(name = "NOME", nullable = false, length = 55)
    public String nome;

    @Column(name = "CPF", nullable = false, length = 11)
    public String cpf;

    @Column(name = "TIPO_INFRACAO", nullable = false, length = 35)
    public String tipoInfracao;

    @Column(name = "DATA_INFRACAO", nullable = false)
    public DATE dataInfracao;

    @Column(name = "LOCAL", nullable = false, length = 50)
    public String local;

    @Column(name = "DESCRICAO", nullable = false, length = 150)
    public String descricao;
} 