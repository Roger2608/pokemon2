package com.example.demo.services;

import java.util.List;

import com.example.demo.entidades.Pokemon;

public interface PokemonService {

	public Pokemon buscar(int id);

	public List<Pokemon> mostrar();

}
