package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "CAMERA")
public class Camera extends PanacheEntity {

    @Column(name = "MODELO_CAMERA", length = 10)
    public String modeloCamera;

    @Column(name = "RESOLUCAO_CAMERA", length = 2)
    public String resolucaoCamera;

    @Column(name = "POSICAO_NO_VAGAO", length = 2)
    public String posicaoNoVagao;

    @ManyToOne
    @JoinColumn(name = "FK_VAGAO_CARRO_ID_CARRO")
    public VagaoCarro vagaoCarro;
} 