package org.fiap.sentinel.model;

import java.io.Serializable;
import java.util.Objects;

public class FuncionarioOcorrenciaId implements Serializable {
    private Long funcionario;
    private Long ocorrencia;

    public FuncionarioOcorrenciaId() {
    }

    public FuncionarioOcorrenciaId(Long funcionario, Long ocorrencia) {
        this.funcionario = funcionario;
        this.ocorrencia = ocorrencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuncionarioOcorrenciaId that = (FuncionarioOcorrenciaId) o;
        return Objects.equals(funcionario, that.funcionario) &&
                Objects.equals(ocorrencia, that.ocorrencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(funcionario, ocorrencia);
    }
} 