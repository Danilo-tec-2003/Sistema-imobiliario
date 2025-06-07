package com.danilo.realEstateSystem.service;

import com.danilo.realEstateSystem.model.Imovel;
import com.danilo.realEstateSystem.repository.ImovelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    public Imovel salvarImovel(Imovel imovel) {
        return imovelRepository.save(imovel);
    }

    public List<Imovel> listarImoveis() {
        return imovelRepository.findAll();
    }

    public Imovel obterImovelPorId(Long id) {
        return imovelRepository.findById(id).orElse(null);
    }

    public void excluirImovel(Long id) {
        imovelRepository.deleteById(id);
    }
}
