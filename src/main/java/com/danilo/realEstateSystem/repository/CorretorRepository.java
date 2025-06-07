package com.danilo.realEstateSystem.repository;

import com.danilo.realEstateSystem.model.Corretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorretorRepository extends JpaRepository<Corretor, Long> {

}
