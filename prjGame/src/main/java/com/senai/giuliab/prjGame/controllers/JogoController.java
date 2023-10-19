package com.senai.giuliab.prjGame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.giuliab.prjGame.entities.Jogo;
import com.senai.giuliab.prjGame.servicos.JogoServicies;

@RestController
@RequestMapping("/jogos")
public class JogoController {

	@GetMapping("/home")
    public String paginaInicial() {
        return "index";	
}
	private final JogoServicies jogoServico;
	
	@Autowired
	public JogoController(JogoServicies jogoServico) {
		this.jogoServico = jogoServico;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Jogo> getJogo(@PathVariable Long id) {
		Jogo jogo = jogoServico.getJogoById(id);
		if (jogo != null) {
			return ResponseEntity.ok(jogo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	public Jogo createjogo(@RequestBody Jogo jogo) {
		return jogoServico.saveJogo(jogo);
	}
	@GetMapping
	public List<Jogo> getAllJogos() {
		return jogoServico.getAllJogos();
	}
	
	@DeleteMapping("/{id}")
	public void deleteJogo(@PathVariable Long id) {
		jogoServico.deleteJogo(id);
	}

}
