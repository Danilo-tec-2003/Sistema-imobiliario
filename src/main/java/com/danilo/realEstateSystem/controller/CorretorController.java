package com.danilo.realEstateSystem.controller;

import com.danilo.realEstateSystem.model.Corretor;
import com.danilo.realEstateSystem.service.CorretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corretores")
public class CorretorController {

    @Autowired
    private CorretorService corretorService;

    @PostMapping
    public ResponseEntity<Corretor> criarCorretor(@RequestBody Corretor corretor) {
        Corretor savedCorretor = corretorService.salvarCorretor(corretor);
        return
                ResponseEntity.status(HttpStatus.CREATED).body(savedCorretor);
    }

    @GetMapping
    public List<Corretor> listarCorretores() {
        return corretorService.listarCorretores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Corretor> obterCorretor(@PathVariable Long id) {
        Corretor corretor = corretorService.obterCorretorPorId(id);
        return corretor != null ? ResponseEntity.ok(corretor) :
                ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Corretor> atualizarCorretor(@PathVariable Long id, @RequestBody Corretor corretor) {
        corretor.setId(id);
        Corretor updateCorretor = corretorService.salvarCorretor(corretor);
        return ResponseEntity.ok(updateCorretor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCorretor(@PathVariable Long id) {
        corretorService.excluirCorretor(id);
        return ResponseEntity.noContent().build();
    }

}
