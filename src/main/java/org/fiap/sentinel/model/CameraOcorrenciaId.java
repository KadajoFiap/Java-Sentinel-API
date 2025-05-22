package org.fiap.sentinel.model;

import java.io.Serializable;
import java.util.Objects;

public class CameraOcorrenciaId implements Serializable {
    private Long camera;
    private Long ocorrencia;

    public CameraOcorrenciaId() {
    }

    public CameraOcorrenciaId(Long camera, Long ocorrencia) {
        this.camera = camera;
        this.ocorrencia = ocorrencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CameraOcorrenciaId that = (CameraOcorrenciaId) o;
        return Objects.equals(camera, that.camera) &&
                Objects.equals(ocorrencia, that.ocorrencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(camera, ocorrencia);
    }
} 