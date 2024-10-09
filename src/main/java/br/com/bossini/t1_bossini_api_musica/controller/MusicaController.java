package br.com.bossini.t1_bossini_api_musica.controller;

import br.com.bossini.t1_bossini_api_musica.model.Musica;
import br.com.bossini.t1_bossini_api_musica.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    @Autowired
    private MusicaService musicaService;

    @PostMapping("/salvar")
    public Musica salvar(@RequestBody Musica musica) {
        return this.musicaService.salvar(musica);
    }

    @GetMapping
    public List<Musica> listar() {
        return this.musicaService.listar();
    }

    @PutMapping("/avaliar/{id}")
    public void avaliar(@PathVariable Long id, @RequestParam int avaliacao) {
        this.musicaService.avaliar(id, avaliacao);
    }
}
