package br.insper.prova.controller;

import br.insper.prova.entity.Artigo;
import br.insper.prova.service.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artigos")
public class ArtigoController {

    @Autowired
    private ArtigoService artigoService;

    @GetMapping
    public List<Artigo> listar() {
        return artigoService.listar();
    }

    @GetMapping("/{id}")
    public Artigo buscarPorId(@PathVariable Integer id) {
        return artigoService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Artigo criar(@RequestBody Artigo artigo) {
        return artigoService.criar(artigo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        artigoService.deletar(id);
    }
}
