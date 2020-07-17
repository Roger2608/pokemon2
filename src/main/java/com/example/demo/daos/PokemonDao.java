package com.example.demo.daos;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;

import com.example.demo.entidades.Pokemon;

public interface PokemonDao {
	public Pokemon find(int id) throws JSONException, IOException;

	public List<Pokemon> findAll() throws JSONException, IOException;

}
