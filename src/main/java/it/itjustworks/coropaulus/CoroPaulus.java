package it.itjustworks.coropaulus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CoroPaulus {

	private static final String CANTO_URL = "url";
	private static final String CANTO_NOME = "nome";
	private static final String ENDPOINT = "http://coropaulus.altervista.org/request.php";
	
	public List<Canto> parseCanti(String canti) {
		List<Canto> response = new ArrayList<Canto>();
		
		JsonParser parser = new JsonParser();
		JsonArray array = parser.parse(canti).getAsJsonArray();
		Iterator<JsonElement> iterator = array.iterator();
		while(iterator.hasNext()){
			JsonObject object = iterator.next().getAsJsonObject();
			Canto canto = new Canto(object.get(CANTO_NOME).getAsString(), object.get(CANTO_URL).getAsString());
			response.add(canto);
		}
		return response;
	}

	public List<Canto> prendiCanti() throws IOException {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(ENDPOINT).build();
		Response response = client.newCall(request).execute();
		return parseCanti(response.body().string());
	}

	public ListaCanti listaCanti() throws IOException {
		List<Canto> canti = prendiCanti();
		return new ListaCanti(canti);
	}

}
