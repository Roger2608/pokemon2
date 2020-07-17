package com.example.demo.daos.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import static com.example.demo.util.Util.*;

import com.example.demo.daos.PokemonDao;
import com.example.demo.entidades.Pokemon;

@Repository
public class PokemonDaoImpl implements PokemonDao {
	@Override
	public Pokemon find(int id) throws JSONException, IOException {
		Pokemon pokemon = null;
		for(Pokemon p : findAll()) {
			if(p.getId() == id) {
				pokemon =p; 
			}
		}
		return pokemon;
	}

	@Override
	public List<Pokemon> findAll() throws JSONException, IOException {
		JSONObject json = leerUrl(LINK);
		JSONArray array = (JSONArray)json.get("results");
		List<Pokemon> lista = new ArrayList<>(); 
		for(int i = 0;i<array.length();i++) {
			JSONObject obj = (JSONObject) array.get(i);
			lista.add(new Pokemon(i+1, obj.getString("name"), obj.getString("url")));
		}
		return lista;
	}
	
	
	public static JSONObject leerUrl(String url) throws IOException, JSONException {
		URLConnection urlConnection = new URL(url).openConnection();
		urlConnection.addRequestProperty("User-Agent", "Mozilla");
		urlConnection.setReadTimeout(1000);
		urlConnection.setConnectTimeout(1000);
		try (InputStream is = urlConnection.getInputStream();
				BufferedReader rd = new BufferedReader(new InputStreamReader(is));) {
			JSONObject json = new JSONObject(leer(rd));
			return json;
		}
	}
	
	private static String leer(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	
}
