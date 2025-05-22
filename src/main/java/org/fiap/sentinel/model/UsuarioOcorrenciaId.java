package org.fiap.sentinel.model;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioOcorrenciaId implements Serializable {
    private Long usuario;
    private Long ocorrencia;

    public UsuarioOcorrenciaId() {
    }

    public UsuarioOcorrenciaId(Long usuario, Long ocorrencia) {
        this.usuario = usuario;
        this.ocorrencia = ocorrencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioOcorrenciaId that = (UsuarioOcorrenciaId) o;
        return Objects.equals(usuario, that.usuario) &&
                Objects.equals(ocorrencia, that.ocorrencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, ocorrencia);
    }
} 