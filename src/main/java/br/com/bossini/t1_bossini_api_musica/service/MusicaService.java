package br.com.bossini.t1_bossini_api_musica.service;

import br.com.bossini.t1_bossini_api_musica.model.Musica;
import br.com.bossini.t1_bossini_api_musica.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository musicaRepository;

    public Musica salvar(Musica musica) {
        if (musicaRepository.existsByNome(musica.getNome())) {
            throw new RuntimeException("Nome da música já existe.");
        }
        return this.musicaRepository.save(musica);
    }

    public List<Musica> listar() {
        return this.musicaRepository.findAllByOrderByAvaliacaoDescNomeAsc();
    }

    public void avaliar(Long id, int avaliacao) {
        if (avaliacao < 1 || avaliacao > 5) {
            throw new RuntimeException("Avaliação deve estar entre 1 e 5.");
        }
        Musica musica = this.musicaRepository.findById(id).orElseThrow(() -> new RuntimeException("Música não encontrada"));
        musica.setAvaliacao(avaliacao);
        this.musicaRepository.save(musica);
    }
}
