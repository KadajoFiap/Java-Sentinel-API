package org.fiap.sentinel.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USUARIO")
public class Usuario extends PanacheEntity {

    @Column(name = "NOME", nullable = false, length = 100)
    public String nome;

    @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
    public String email;

    @Column(name = "SENHA", nullable = false, length = 100)
    public String senha;

    @Column(name = "DATA_CADASTRO", nullable = false)
    public LocalDate dataCadastro;
} 