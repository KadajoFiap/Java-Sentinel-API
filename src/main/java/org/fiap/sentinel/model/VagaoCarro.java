package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "VAGAO_CARRO")
public class VagaoCarro extends PanacheEntity {

    @Column(name = "DATA_FABR_VAGAO", nullable = false)
    public LocalDate dataFabrVagao;

    @Column(name = "MODELO_VAGAO", length = 10)
    public String modeloVagao;

    @Column(name = "FABRICANTE_VAGAO", length = 50)
    public String fabricanteVagao;

    @ManyToOne
    @JoinColumn(name = "FK_TREM_NMR_TREM")
    public Trem trem;
} 