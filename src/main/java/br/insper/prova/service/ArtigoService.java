package br.insper.prova.service;

import br.insper.prova.entity.Artigo;
import br.insper.prova.repository.ArtigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;

    public List<Artigo> listar() {
        return artigoRepository.findAll();
    }

    public Artigo buscarPorId(Integer id) {
        return artigoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Artigo não encontrado(a)"));
    }

    public Artigo criar(Artigo artigo) {
        return artigoRepository.save(artigo);
    }

    public void deletar(Integer id) {
        Artigo existente = buscarPorId(id);
        artigoRepository.delete(existente);
    }
}
