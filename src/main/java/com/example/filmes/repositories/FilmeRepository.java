
package com.example.filmes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.filmes.entities.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    List<Filme> findByDuracaoGreaterThan(Integer duracao);

    List<Filme> findByDuracaoLessThanEqual(Integer duracao);

    List<Filme> findByTituloStartingWith(String titulo);
}
