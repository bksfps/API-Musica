package br.com.bossini.t1_bossini_api_musica.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/ping")
public class PingPongController {
    @GetMapping
    public String executando (){
        return "pong";
    }
}
