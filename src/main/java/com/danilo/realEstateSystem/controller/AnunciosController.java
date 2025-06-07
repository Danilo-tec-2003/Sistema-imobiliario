package com.danilo.realEstateSystem.controller;

import com.danilo.realEstateSystem.model.Anuncio;
import com.danilo.realEstateSystem.service.AnuncioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("anuncios")
public class AnunciosController {

    @Autowired
    private AnuncioService anuncioService;

    @PostMapping
    public ResponseEntity<Anuncio> criarAnuncio(@RequestBody Anuncio anuncio) {
        Anuncio savedAnuncio = anuncioService.salvarAnuncio(anuncio);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAnuncio);
    }

    @GetMapping
    public List<Anuncio> listarAnuncios() {
        return anuncioService.listarAnuncio();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anuncio> obterAnuncio(@PathVariable Long id) {
        Anuncio anuncio = anuncioService.obterAnuncioPorId(id);
        return anuncio != null ? ResponseEntity.ok(anuncio) : ResponseEntity.notFound().build();
    }


    @GetMapping("/corretor/id/{id}")
    public ResponseEntity<List<Anuncio>> listarPorCorretorId(@PathVariable Long id) {
        return ResponseEntity.ok(anuncioService.buscarPorCorretor(id));
    }


    @GetMapping("/corretor/nome/{nome}")
    public ResponseEntity<List<Anuncio>> listarPorCorretorNome(@PathVariable String nome) {
        return ResponseEntity.ok(anuncioService.buscarPorNomeCorretor(nome));
    }


    @GetMapping("/bairro/{bairro}")
    public ResponseEntity<List<Anuncio>> listarPorBairro(@PathVariable String bairro) {
        return ResponseEntity.ok(anuncioService.buscarPorBairro(bairro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Anuncio> atualizarAnuncio(@PathVariable Long id, @RequestBody Anuncio anuncio) {
        anuncio.setId(id);
        Anuncio updateAnuncio = anuncioService.salvarAnuncio(anuncio);
        return ResponseEntity.ok(updateAnuncio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAnuncio(@PathVariable Long id) {
        anuncioService.excluirAnuncio(id);
        return ResponseEntity.noContent().build();
    }

}
