package com.danilo.realEstateSystem.controller;

import com.danilo.realEstateSystem.model.Imovel;
import com.danilo.realEstateSystem.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imoveis")

public class ImoveisController {

    @Autowired
    private ImovelService imovelService;

    @PostMapping
    public ResponseEntity<Imovel> criarImovel(@RequestBody Imovel imovel) {
        Imovel savedImovel = imovelService.salvarImovel(imovel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedImovel);
    }

    @GetMapping
    public List<Imovel> listarImoveis() {
        return imovelService.listarImoveis();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imovel> obterImovel(@PathVariable Long id) {
        Imovel imovel = imovelService.obterImovelPorId(id);
        return imovel != null ? ResponseEntity.ok(imovel) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imovel> atualizarImovel(@PathVariable Long id, @RequestBody Imovel imovel) {
        imovel.setId(id);
        Imovel updateImovel = imovelService.salvarImovel(imovel);
        return ResponseEntity.ok(updateImovel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirImovel(@PathVariable Long id) {
        imovelService.excluirImovel(id);
        return ResponseEntity.noContent().build();
    }
}
