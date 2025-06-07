package com.danilo.realEstateSystem.service;

import com.danilo.realEstateSystem.model.Anuncio;
import com.danilo.realEstateSystem.repository.AnuncioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnuncioService {

    private final AnuncioRepository anuncioRepository;

    public AnuncioService(AnuncioRepository anuncioRepository) {
        this.anuncioRepository = anuncioRepository;
    }

    public Anuncio salvarAnuncio(Anuncio anuncio) {
        return anuncioRepository.save(anuncio);
    }

    public List<Anuncio> listarAnuncio() {
        return anuncioRepository.findAll();
    }

    public Anuncio obterAnuncioPorId(Long id) {
        Optional<Anuncio> anuncio = anuncioRepository.findById(id);
        return anuncio.orElse(null);
    }

    public void excluirAnuncio(Long id) {
        anuncioRepository.deleteById(id);
    }

    public List<Anuncio> buscarPorCorretor(Long idCorretor) {
        return anuncioRepository.findByCorretorId(idCorretor);
    }

    public List<Anuncio> buscarPorNomeCorretor(String nomeCorretor) {
        return anuncioRepository.findByCorretorNomeContainingIgnoreCase(nomeCorretor);
    }

    public List<Anuncio> buscarPorBairro(String bairro) {
        return anuncioRepository.findByImovelBairroIgnoreCase(bairro);
    }
}
