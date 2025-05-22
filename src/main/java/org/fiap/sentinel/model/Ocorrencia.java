package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "OCORRENCIA")
public class Ocorrencia extends PanacheEntity {

    @Column(name = "DATA_INICIO", nullable = false)
    public LocalDate dataInicio;

    @Column(name = "DATA_FIM")
    public LocalDate dataFim;

    @Column(name = "TIPO_OCORRENCIA", length = 36)
    public String tipoOcorrencia;

    @Column(name = "DESCRICAO_OCORRENCIA", length = 500)
    public String descricaoOcorrencia;

    @Column(name = "SEVERIDADE", nullable = false)
    public Integer severidadeOcorrencia;

    @Column(name = "STATUS_OCORRENCIA", length = 20, nullable = false)
    public String statusOcorrencia = "ABERTO";
} 