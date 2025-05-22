package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CAM_OCO_CAPTURA")
@IdClass(CameraOcorrenciaId.class)
public class CameraOcorrencia extends PanacheEntityBase {

    @Column(name = "DATA_CAPTURA", nullable = false)
    public LocalDate dataCaptura;

    @ManyToOne
    @JoinColumn(name = "FK_CAMERA_ID_CAMERA")
    @Id
    public Camera camera;

    @ManyToOne
    @JoinColumn(name = "FK_OCORRENCIA_ID_OCORRENCIA")
    @Id
    public Ocorrencia ocorrencia;
} 