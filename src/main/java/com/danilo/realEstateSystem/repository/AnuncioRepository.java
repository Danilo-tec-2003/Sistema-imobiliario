package com.danilo.realEstateSystem.repository;

import com.danilo.realEstateSystem.model.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
    List<Anuncio> findByCorretorId(Long id);
    List<Anuncio> findByImovelBairroIgnoreCase(String bairro);
    List<Anuncio> findByCorretorNomeContainingIgnoreCase(String nomeCorretor);
}
