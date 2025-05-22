package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "EVIDENCIA")
public class Evidencia extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "ID_OCORRENCIA")
    public Ocorrencia ocorrencia;

    @Column(name = "S3_KEY", nullable = false, length = 512)
    public String s3Key;

    @Column(name = "DESCRICAO", length = 200)
    public String descricao;

    @Column(name = "DATA_UPLOAD")
    public LocalDateTime dataUpload;
} 