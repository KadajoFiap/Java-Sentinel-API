package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "MANUTENCAO")
public class Manutencao extends PanacheEntity {
    @Column()
    public String tipo;
    public LocalDateTime dataInicio;
    public LocalDateTime dataFim;
    public String descricao;
    public String status;
    public String responsavel;
    public String equipamento;
    public String prioridade;


} 