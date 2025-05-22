package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TREM")
public class Trem extends PanacheEntity {

    @Column(name = "FABRICANTE", length = 10)
    public String fabricante;

    @Column(name = "DATA_FABR_TREM", nullable = false)
    public LocalDate dataFabrTrem;

    @Column(name = "MODELO_TREM", length = 10)
    public String modeloTrem;

    @Column(name = "NUMERO_TREM", nullable = false)
    public int numero;

    @Column(name = "STATUS", nullable = false, length = 10)
    public String status;

    @Column(name = "ORIGEM", nullable = false, length = 30)
    public String origem;

    @Column(name = "DESTINO", nullable = false, length = 30)
    public String destino;

    @Column(name = "OBSERVACOES", nullable = false, length = 50)
    public String observacoes;
} 