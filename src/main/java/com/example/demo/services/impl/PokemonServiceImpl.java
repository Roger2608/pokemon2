package com.example.demo.services.impl;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.daos.PokemonDao;
import com.example.demo.entidades.Pokemon;
import com.example.demo.services.PokemonService;

@Service
public class PokemonServiceImpl implements PokemonService {
	@Autowired
	PokemonDao pokemonDao;

	@Override
	public Pokemon buscar(int id) {
		
		Pokemon pokemon = null;
		try {
			 pokemon = pokemonDao.find(id);
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
		return pokemon;
	}

	@Override
	public List<Pokemon> mostrar() {
		List<Pokemon> lista= null;
		try {
			lista = pokemonDao.findAll();
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
