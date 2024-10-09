package br.com.bossini.t1_bossini_api_musica.repository;

import br.com.bossini.t1_bossini_api_musica.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {
    boolean existsByNome(String nome);

    List<Musica> findAllByOrderByAvaliacaoDescNomeAsc();
}
