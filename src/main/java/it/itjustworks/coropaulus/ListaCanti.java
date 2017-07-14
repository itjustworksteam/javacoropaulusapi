package it.itjustworks.coropaulus;

import java.util.ArrayList;
import java.util.List;

public class ListaCanti {

	private List<Canto> canti;
	private List<Canto> cantiCercati;
	
	public ListaCanti(List<Canto> canti) {
		this.canti = canti;
		this.cantiCercati = new ArrayList<Canto>();
	}

	public List<Canto> canti() {
		return this.canti;
	}

	public int dimensione() {
		return this.canti.size();
	}

	public void cerca(String ricerca) {
		List<Canto> ricercati = new ArrayList<Canto>();
		for(int index = 0; index < this.canti.size(); index++){
			Canto c = this.canti.get(index);
			if(c.nome().contains(ricerca)){
				ricercati.add(c);
			}
		}
		this.cantiCercati = ricercati;
	}

	public int trovati() {
		return this.cantiCercati.size();
	}
	
	private String singolareOPlurale(int numero) {
		return (numero == 1) ? "o" : "i";
	}

	public String prettyToString() {
		String response = "";
		if(this.cantiCercati.size() == 0) {
			return "nessun canto trovato";
		} else {
			response += "Ho trovato " + this.cantiCercati.size() + " cant"
					+ singolareOPlurale(this.cantiCercati.size())
					+ ". Eccol"
					+ singolareOPlurale(this.cantiCercati.size())
					+ ":\n\n";
			for(int index = 0; index < this.cantiCercati.size(); index++){
				Canto c = this.cantiCercati.get(index);
				response += c.prettyToString() + "\n";
			}
		}
		return response;
	}

}
