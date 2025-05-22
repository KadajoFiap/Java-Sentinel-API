package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "USU_OCORRENCIA")
@IdClass(UsuarioOcorrenciaId.class)
public class UsuarioOcorrencia extends PanacheEntityBase {

    @ManyToOne
    @JoinColumn(name = "FK_USUARIO_ID_USUARIO")
    @Id
    public Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "FK_OCORRENCIA_ID_OCORRENCIA")
    @Id
    public Ocorrencia ocorrencia;
} 