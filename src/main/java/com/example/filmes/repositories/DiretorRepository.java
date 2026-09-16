
package com.example.filmes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.filmes.entities.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Long> {

    List<Diretor> findByNomeStartingWith(String nome);
}
