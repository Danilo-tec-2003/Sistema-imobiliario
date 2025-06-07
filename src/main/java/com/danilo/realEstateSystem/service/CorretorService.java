package com.danilo.realEstateSystem.service;

import com.danilo.realEstateSystem.model.Corretor;
import com.danilo.realEstateSystem.repository.CorretorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorretorService {

    @Autowired
    private CorretorRepository corretorRepository;

    public Corretor salvarCorretor(Corretor corretor) {
        return corretorRepository.save(corretor);
    }
    public List<Corretor> listarCorretores() {
        return corretorRepository.findAll();
    }
    public Corretor obterCorretorPorId(Long id) {
        return corretorRepository.findById(id).orElse(null);
    }
    public void excluirCorretor(Long id) {
        corretorRepository.deleteById(id);
    }
}
