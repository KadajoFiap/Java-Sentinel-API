package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "FUNC_OCORRENCIA")
@IdClass(FuncionarioOcorrenciaId.class)
public class FuncionarioOcorrencia extends PanacheEntityBase {

    @ManyToOne
    @JoinColumn(name = "FK_FUNCIONARIO_ID_FUNCIONARIO")
    @Id
    public Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "FK_OCORRENCIA_ID_OCORRENCIA")
    @Id
    public Ocorrencia ocorrencia;
} 