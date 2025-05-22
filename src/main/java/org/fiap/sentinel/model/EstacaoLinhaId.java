package org.fiap.sentinel.model;

import java.io.Serializable;
import java.util.Objects;

public class EstacaoLinhaId implements Serializable {
    private Long estacao;
    private Long linha;

    public EstacaoLinhaId() {
    }

    public EstacaoLinhaId(Long estacao, Long linha) {
        this.estacao = estacao;
        this.linha = linha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstacaoLinhaId that = (EstacaoLinhaId) o;
        return Objects.equals(estacao, that.estacao) &&
                Objects.equals(linha, that.linha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estacao, linha);
    }
} 