
package com.example.filmes;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.filmes.entities.Diretor;
import com.example.filmes.entities.Filme;
import com.example.filmes.repositories.DiretorRepository;
import com.example.filmes.repositories.FilmeRepository;

@SpringBootApplication
public class FilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmesApplication.class, args);
	}

	@Bean
	CommandLineRunner init(
			FilmeRepository filmeRepository,
			DiretorRepository diretorRepository) {

		return args -> {

			Diretor akira = new Diretor(null, "Akira Kurosawa", null);
			Diretor david = new Diretor(null, "David Lynch", null);
			Diretor christopher = new Diretor(null, "Christopher Nolan", null);

			diretorRepository.save(akira);
			diretorRepository.save(david);
			diretorRepository.save(christopher);

			filmeRepository.save(new Filme(null, "Os Sete Samurais", 207, akira));
			filmeRepository.save(new Filme(null, "Cidade dos Sonhos", 147, david));
			filmeRepository.save(new Filme(null, "Interestelar", 169, christopher));

			System.out.println("\nFILMES COM DURACAO MAIOR QUE 150:");

			List<Filme> filmesMaiores = filmeRepository.findByDuracaoGreaterThan(150);

			filmesMaiores.forEach(filme -> System.out.println(
					filme.getTitulo()
							+ " - "
							+ filme.getDuracao()
							+ " minutos"));

			System.out.println("\nFILMES COM DURACAO MENOR OU IGUAL A 150:");

			List<Filme> filmesMenores = filmeRepository.findByDuracaoLessThanEqual(150);

			filmesMenores.forEach(filme -> System.out.println(
					filme.getTitulo()
							+ " - "
							+ filme.getDuracao()
							+ " minutos"));

			System.out.println("\nFILMES QUE COMEÇAM COM A:");

			List<Filme> filmesTitulo = filmeRepository.findByTituloStartingWith("A");

			filmesTitulo.forEach(filme -> System.out.println(filme.getTitulo()));

			System.out.println("\nDIRETORES QUE COMEÇAM COM C:");

			List<Diretor> diretores = diretorRepository.findByNomeStartingWith("C");

			diretores.forEach(diretor -> System.out.println(diretor.getNome()));

			System.out.println("\nFILMES E SEUS DIRETORES:");

			filmeRepository.findAll().forEach(filme -> System.out.println(
					filme.getTitulo()
							+ " - Diretor: "
							+ filme.getDiretor().getNome()));
		};
	}
}
