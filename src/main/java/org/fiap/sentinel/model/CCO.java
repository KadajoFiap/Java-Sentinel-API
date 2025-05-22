package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "CCO")
public class CCO extends PanacheEntity {

    @Column(name = "ENDERECO_CCO", length = 60)
    public String enderecoCco;

    @Column(name = "TELEFONE", length = 9)
    public String telefone;
} 