package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Pokemon;
import com.example.demo.services.PokemonService;

//mi commmt
@RestController
@RequestMapping("/pokemon")
public class PokemonController {
	
	@Autowired
	PokemonService pokemonService;
	
	@GetMapping("{id}")
	public ResponseEntity<Pokemon> buscarPokemon(@PathVariable(value = "id") int id) {
		return ResponseEntity.ok().body(pokemonService.buscar(id));
	}
	
	@GetMapping
	public List<Pokemon> mostrarPokemon(){
		return pokemonService.mostrar();
	}

	public pokemonService(){
		return null;
	}
	
}
