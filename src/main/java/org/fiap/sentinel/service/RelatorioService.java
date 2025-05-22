package org.fiap.sentinel.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.fiap.sentinel.model.Relatorio;
import java.util.List;

@ApplicationScoped
public class RelatorioService {

    public List<Relatorio> listarTodosRelatorios(){
        return Relatorio.listAll();
    }

    public Relatorio buscarPorId(Long id){
        return Relatorio.findById(id);
    }

    @Transactional
    public void salvar(Relatorio relatorio){
        relatorio.persist();
    }

    @Transactional
    public void deletarRelatorio(Long id){
        Relatorio relatorio = Relatorio.findById(id);
        if (relatorio != null) relatorio.delete();
    }

    @Transactional
    public void atualizarRelatorio(Long id, Relatorio atualizado){
        Relatorio relatorio = Relatorio.findById(id);
        if (relatorio == null){
            throw new IllegalArgumentException("A ocorrência não pode ser nula");
        }
    }
}
