package br.insper.prova.repository;

import br.insper.prova.entity.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtigoRepository extends JpaRepository<Artigo, Integer> {
}
