package org.fiap.sentinel.model;

import java.io.Serializable;

public class EfetivoId implements Serializable {
    private Long id;
    private Long funcionario;

    public EfetivoId() {
    }

    public EfetivoId(Long id, Long funcionario) {
        this.id = id;
        this.funcionario = funcionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EfetivoId efetivoId = (EfetivoId) o;
        if (!id.equals(efetivoId.id)) return false;
        return funcionario.equals(efetivoId.funcionario);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + funcionario.hashCode();
        return result;
    }
} 