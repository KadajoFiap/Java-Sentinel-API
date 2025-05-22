package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "EFETIVO")
@IdClass(EfetivoId.class)
public class Efetivo extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EFETIVO")
    public Long id;

    @OneToOne
    @JoinColumn(name = "FK_FUNCIONARIO_ID_FUNCIONARIO")
    @Id
    public Funcionario funcionario;

    @Column(name = "CTPS", unique = true, length = 15)
    public String ctps;

    @Column(name = "CPF_EFETIVO", length = 11)
    public String cpfEfetivo;

    @Column(name = "DATA_REGISTRO", nullable = false)
    public LocalDate dataRegistro;
} 